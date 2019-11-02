package edu.calvin.cs262.myapplication;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class sLoader extends AsyncTaskLoader {
    private String urlString;

    sLoader(@NonNull Context context, String queryString) {
        super(context);
        urlString = queryString;
    }

    @Nullable
    @Override
    public String loadInBackground() {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String html = "";

        try {
            Log.d("||||||||||||||||||||||", urlString);

            URL url = new URL(urlString);
            HttpURLConnection response = (HttpURLConnection) url.openConnection();

            // Get the InputStream.
            InputStream in = response.getInputStream();

            // Create a buffered reader from that input stream.
            reader = new BufferedReader(new InputStreamReader(in));

            // Use a StringBuilder to hold the incoming response.
            StringBuilder str = new StringBuilder();
            String line;// = null;
            while((line = reader.readLine()) != null){
                str.append(line);
            }
            in.close();
            html = str.toString();

            if (html.length() == 0) {
                // Stream was empty. No point in parsing.
                return null;
            }

        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
            return "url was not found :(";
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }

        Log.d("|||||||||||||||||||||||", html);
        return html;
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
}
