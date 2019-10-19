package edu.calvin.cs262.myapplication;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class sLoader extends AsyncTaskLoader<String> {

    public sLoader(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }
    private String mQueryString;

    sLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }
}
