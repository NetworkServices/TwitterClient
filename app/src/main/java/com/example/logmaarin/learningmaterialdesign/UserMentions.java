package com.example.logmaarin.learningmaterialdesign;

import org.json.JSONObject;

/**
 * Created by Tayfun on 19-5-2015.
 */

public class UserMentions {

    String userName;
    int begin;
    int eind;

    public UserMentions(JSONObject obj){
        userName = obj.getString("screen_name");
        begin = obj.getJSONArray("indices").getInt(0);
        eind = obj.getJSONArray("indices").getInt(1);
    }
}
