package com.example.logmaarin.learningmaterialdesign;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Tayfun on 19-5-2015.
 */
public class Entity {

    private ArrayList<Hashtag> hashtags = new ArrayList<Hashtag>();

    public ArrayList<Hashtag> getHashtags() {
        return hashtags;
    }

    public Entity(JSONObject obj) throws JSONException {
        JSONArray tempArray = obj.getJSONArray("hashtags");
        for(int i= 0;i<tempArray.length();i++){
            Hashtag h = new Hashtag(tempArray.getJSONObject(i));
            hashtags.add(h);

        }

        JSONArray tempArray1 = obj.getJSONArray("user_mentions");
    }


}
