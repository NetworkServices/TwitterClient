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
    private ArrayList<media> medias = new ArrayList<media>();


    public ArrayList<Hashtag> getHashtags() {
        return hashtags;
    }

    public ArrayList<media> getMedias() {
        return medias;
    }

    public Entity(JSONObject obj)  {
        JSONArray tempArray = null;
        try {
            tempArray = obj.getJSONArray("hashtags");
            for(int i= 0;i<tempArray.length();i++){
                Hashtag h = new Hashtag(tempArray.getJSONObject(i));
                hashtags.add(h);

            }

            tempArray = obj.getJSONArray("media");

            for(int i= 0; i<tempArray.length();i++){
                media m = new media(tempArray.getJSONObject(i));
                medias.add(m);

            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

}


}
