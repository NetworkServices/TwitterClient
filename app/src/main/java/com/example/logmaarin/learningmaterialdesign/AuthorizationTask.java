package com.example.logmaarin.learningmaterialdesign;

import android.os.AsyncTask;
import android.util.Base64;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/**
 * Created by LogMaarIn on 6-6-2015.
 */
    public class AuthorizationTask extends AsyncTask<Void,Void,String> {

    private	static final String	API_KEY	= "8IRhj6hsyRl5mrU0Aj7n2eEEX";
    private static final String	API_SECRET	= "2PR7M2x6M8vYpHdbtITjoVvM6bOwSh18R8xIT2wUPlzpYtUaZh";
    private String token;
    private ArrayList<String> strings = new ArrayList<String>();
    @Override
    protected String doInBackground(Void... params) {
        HttpClient client = new DefaultHttpClient();
        //	Plak	key	en	secret	aan	elkaar	en	zorg	dat	er	nooit	‘rare’
        //	tekens	inzitten
        String authString = API_KEY + ":" + API_SECRET;
        String base64 = Base64.encodeToString(
                authString.getBytes(), Base64.NO_WRAP);
        //	Maak een	POST-request
        HttpPost request =
                new HttpPost("https://api.twitter.com/oauth/request_token");
        //	Voeg key+secret	toe
        request.setHeader("Authorization", "Basic " + base64);
        request.setHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=UTF-8");
        //	Vul	body:	vertel dat	je	inlogt	met	app	key	en	secret

        try {
            request.setEntity(
                    new StringEntity("grant_type=client_credentials"));
            HttpEntity entity = client.execute(request).getEntity();
            token = EntityUtils.toString(entity);
            JSONObject obj = new JSONObject(token);
            strings.add(obj.getString("oauth_token"));
            strings.add(obj.getString("oauth_token_secret"));
            Log.d("hoi", strings.get(0));
            Log.d("hoi", strings.get(1));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return token;
    }
}
