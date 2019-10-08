package edu.calvin.cs262.yp27;

import android.os.AsyncTask;
import android.os.AsyncTask;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.ref.WeakReference;

import edu.calvin.cs262.yp27.R;

public class FetchBook extends AsyncTask<String,Void,String> {

    private WeakReference<TextView> mTitleText;
    private WeakReference<TextView> mAuthorText;


    FetchBook(TextView titleText, TextView authorText) {
        this.mTitleText = new WeakReference<>(titleText);
        this.mAuthorText = new WeakReference<>(authorText);
    }

    @Override
    protected String doInBackground(String... strings) {
        return NetworkUtils.getBookInfo(strings[0]);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            //initialize the variables used for the parsing loop
            int i = 0;
            String title = null;
            String authors = null;

            while (i < itemsArray.length() &&
                    (authors == null && title == null)) {
                // Get the current item information.
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                // Try to get the author and title from the current item,
                // catch if either field is empty and move on.
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Move to the next item.
                i++;
            }

            if (title != null && authors != null) {
                mTitleText.get().setText(title);
                mAuthorText.get().setText(authors);
            }

            else {
                mTitleText.get().setText(R.string.no_results);
                mAuthorText.get().setText("");
            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        try {
            //obtain the JSON array of items from the result string
            JSONObject jsonObject = new JSONObject(s);
            JSONArray itemsArray = jsonObject.getJSONArray("items");

            //initialize the variables used for the parsing loop
            int i = 0;
            String title = null;
            String authors = null;

            //iterate through the itemsArray array, checking each book for title and author information
            //Only entries with both a title and author will be displayed
            while (i < itemsArray.length() &&
                    (authors == null && title == null)) {
                // Get the current item information.
                JSONObject book = itemsArray.getJSONObject(i);
                JSONObject volumeInfo = book.getJSONObject("volumeInfo");

                // Try to get the author and title from the current item,
                // catch if either field is empty and move on.
                try {
                    title = volumeInfo.getString("title");
                    authors = volumeInfo.getString("authors");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                // Move to the next item.
                i++;
            }
            //if a matching response is found, update the UI with that response.
            if (title != null && authors != null) {
                mTitleText.get().setText(title);
                mAuthorText.get().setText(authors);

                //if the loop has stopped and the result has no items with both a valid author
                //and a valid title
            } else {
                mTitleText.get().setText(R.string.no_results);
                mAuthorText.get().setText("");
            }
        } catch (Exception e) {
            // If onPostExecute does not receive a proper JSON string,
            // update the UI to show failed results.
            mTitleText.get().setText(R.string.no_results);
            mAuthorText.get().setText("");
            e.printStackTrace();
        }
    }
}