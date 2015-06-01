package com.example.logmaarin.learningmaterialdesign;

import android.app.Application;
import android.content.res.AssetManager;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by LogMaarIn on 15-5-2015.
 */
public class TweetApp extends Application{

    private TweetModel model;
    private JSONObject obj;
    private String s;

    @Override
    public void onCreate() {

        try {
            s = readAssetIntoString("lol.json");
            obj = new JSONObject(s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        try {

            model = new TweetModel(obj);
            Log.d("doei", "Tayfun has a tiny penis");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        super.onCreate();

    }

    private String readAssetIntoString(String filename) throws IOException {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            InputStream is = getAssets().open(filename, AssetManager.ACCESS_BUFFER);
            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    public TweetModel getModel() {
        return model;
    }



}