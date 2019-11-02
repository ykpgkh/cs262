package edu.calvin.cs262.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String> {

    RadioGroup protocol;
    private EditText websiteURL;
    private TextView pageSourceText;
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        websiteURL = findViewById(R.id.websiteInput);
        pageSourceText = findViewById(R.id.pageSourceText);
    }

    public void getPageSource(View view) {

        //Get the search string from the input field.
        String urlString = websiteURL.getText().toString();
//        int protocolType = protocol.getCheckedRadioButtonId();

        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        if (inputManager != null ) {
            inputManager.hideSoftInputFromWindow(view.getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }

        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = null;
        if (connMgr != null) {
            networkInfo = connMgr.getActiveNetworkInfo();
        }

        // If user has given input and we are connected to network
        if (networkInfo != null && networkInfo.isConnected()
                && urlString.length() != 0 ) {

            // Combine protocol string with user typed url to create final url
//            String finalSearchString = protocolType + (urlString);
            Bundle queryBundle = new Bundle();
            queryBundle.putString("urlString", null);
//            queryBundle.putString("urlString", finalSearchString);

            // Restart loader to get results
            getSupportLoaderManager().restartLoader(0, queryBundle, this);

            pageSourceText.setText("Loading...");

            // No search term or no network
        } else {
            if (urlString.length() == 0) {
                pageSourceText.setText("");
            } else {
                pageSourceText.setText("Check your network connection.");
            }
        }
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String urlSource = "";

        if (args != null) { urlSource = args.getString("urlString"); }

        return new sLoader(this, urlSource);
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
            String results = data;
            if (results != null) {
                pageSourceText.setText(results);

                // no valid response
            } else {
                pageSourceText.setText("");
            }

    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {

    }
}
