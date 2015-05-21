package com.example.logmaarin.learningmaterialdesign;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Tayfun on 19-5-2015.
 */
public class Hashtag {

    int begin;
    int eind;
    String text;

    public Hashtag(JSONObject obj)throws JSONException{

        text= obj.getString("text");
        JSONArray indices = obj.getJSONArray("indices");
        begin = indices.getInt(0);
        eind = indices.getInt(1);
    }

    public String getText() {
        return text;
    }

    public int getEind() {

        return eind;
    }

    public int getBegin() {

        return begin;
    }
}
