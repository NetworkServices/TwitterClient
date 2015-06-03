package com.example.logmaarin.learningmaterialdesign;

import android.graphics.Bitmap;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by Tayfun on 19-5-2015.
 */
public class User {


    private String naam;
    private String userName;
    Bitmap pf;

    public String getUserName() {
        return userName;
    }

    public String getNaam() {

        return naam;
    }

    public Bitmap getPf() {
        return pf;
    }

    public User(JSONObject obj) throws JSONException {

        naam = obj.getString("name");
        userName = obj.getString("screen_name");
        String s = obj.getString("profile_image_url");
        try {
            pf =  new MyAsyncTask().execute(s).get();
        } catch (InterruptedException e) {
            e.printStackTrace();

        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
