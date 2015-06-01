package com.example.logmaarin.learningmaterialdesign;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by LogMaarIn on 1-6-2015.
 */
public class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {


    @Override
    protected Bitmap doInBackground(String... params) {
        String url = params[0];
        Bitmap b = null;
        try {
             URL newurl = new URL(url);
            b = BitmapFactory.decodeStream(newurl.openConnection() .getInputStream());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return b;
    }

    // Sets the Bitmap returned by doInBackground
    @Override
    protected void onPostExecute(Bitmap result) {
        
    }



}