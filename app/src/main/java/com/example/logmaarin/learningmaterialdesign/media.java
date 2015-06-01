package com.example.logmaarin.learningmaterialdesign;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by LogMaarIn on 1-6-2015.
 */
public class media {
    int begin, eind;
    String url, mediaURL;

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

            JSONArray indices = obj.getJSONArray("indices");
            begin = indices.getInt(0);
            eind = indices.getInt(1);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
