package com.example.logmaarin.learningmaterialdesign;

import android.graphics.Bitmap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by LogMaarIn on 1-6-2015.
 */
public class media {
    int begin, eind;
    String url, mediaURL;
    Bitmap image;

    public Bitmap getImage() {
        return image;
    }

    public String getUrl() {
        return url;
    }

    public String getMediaURL() {

        return mediaURL;
    }

    public int getEind() {

        return eind;
    }

    public int getBegin() {

        return begin;
    }

    public media(JSONObject obj)  {

        try {
            url = obj.getString("url");
            mediaURL = obj.getString("media_url");
            image = new MyAsyncTask().execute(mediaURL).get();
            JSONArray indices = obj.getJSONArray("indices");
            begin = indices.getInt(0);
            eind = indices.getInt(1);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
