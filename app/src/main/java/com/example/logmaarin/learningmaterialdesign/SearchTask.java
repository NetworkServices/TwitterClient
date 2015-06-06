package com.example.logmaarin.learningmaterialdesign;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by LogMaarIn on 4-6-2015.
 */
public class SearchTask extends AsyncTask<String, Void, String> {
    private String result;
    @Override
    protected String doInBackground(String... params) {

        try {
            HttpClient client = new DefaultHttpClient();

            String s = URLEncoder.encode(params[0], "UTF-8");
            HttpGet httpGet =new HttpGet("https://api.twitter.com/1.1/search/tweets.json?q=" + s);
            httpGet.setHeader("Authorization", "Bearer " + params[1]);
            Log.d("hoi", params[0] + "  " + params[1]);
            HttpEntity searchJSON = client.execute(httpGet).getEntity();
            result = EntityUtils.toString(searchJSON);
            Log.d("hoi", "gelukt!");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
