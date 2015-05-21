package com.example.logmaarin.learningmaterialdesign;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Tayfun on 19-5-2015.
 */
public class User {


    private String naam;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public String getNaam() {

        return naam;
    }

    public User(JSONObject obj) throws JSONException {

        naam = obj.getString("name");
        userName = obj.getString("screen_name");

    }
}
