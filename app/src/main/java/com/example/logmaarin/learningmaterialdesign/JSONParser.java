package com.example.logmaarin.learningmaterialdesign;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by LogMaarIn on 6-6-2015.
 */
public class JSONParser {

    private ArrayList<Tweet> tweetList;
    JSONObject objct;
    private JSONArray tweets;

    public JSONParser(JSONObject obj) throws JSONException {
            tweetList= new ArrayList<Tweet>();
            objct = obj;
            tweets= objct.getJSONArray("statuses");
            for(int i=0;i<tweets.length();i++){
                JSONObject obj1 = tweets.getJSONObject(i);
                JSONObject u = obj1.getJSONObject("user");
                User user = new User(u);
                Tweet t= new Tweet(obj1.getString("text"), user, new Entity(obj1.getJSONObject("entities")));
                tweetList.add(t);
                Log.d("hoi", "Tayfun zijn kleine dick");
            }


    }

    public ArrayList<Tweet> getTweetList(){
        return tweetList;
    }



}
