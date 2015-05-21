package com.example.logmaarin.learningmaterialdesign;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Tayfun on 19-5-2015.
 */

public class UserMentions {
    //cOOLER MENSEN ZIJN COOL
    String userName;
    int begin;
    int eind;

    public UserMentions(JSONObject obj) throws JSONException {
        userName = obj.getString("screen_name");
        begin = obj.getJSONArray("indices").getInt(0);
        eind = obj.getJSONArray("indices").getInt(1);
    }
}
