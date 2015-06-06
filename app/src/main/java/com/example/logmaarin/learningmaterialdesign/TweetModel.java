package com.example.logmaarin.learningmaterialdesign;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by LogMaarIn on 15-5-2015.
 */
public class TweetModel {
    private ArrayList<Tweet> timeLine;
    private ArrayList<Tweet> searchLine;
    JSONObject objct;
    private JSONArray tweets;
    public TweetModel(JSONObject object) {
        timeLine = new ArrayList<>();
        try {
            timeLine = new JSONParser(object).getTweetList();
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }




    public ArrayList<Tweet> getTweetList() {
        return timeLine;
    }




}
