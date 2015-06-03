package com.example.logmaarin.learningmaterialdesign;

import android.app.Activity;
import android.os.Bundle;
import android.util.Base64;
import android.widget.SearchView;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by LogMaarIn on 2-6-2015.
 */


public class SearchClass extends Activity {

    private	static final String	API_KEY	= "8IRhj6hsyRl5mrU0Aj7n2eEEX";
    private static final String	API_SECRET	= "2PR7M2x6M8vYpHdbtITjoVvM6bOwSh18R8xIT2wUPlzpYtUaZh";

    SearchView search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        search = (SearchView) findViewById(R.id.searchView);
        //	Plak	key	en	secret	aan	elkaar	en	zorg	dat	er	nooit	‘rare’
        //	tekens	inzitten
        String	authString	=	API_KEY +	":"	+	API_SECRET;
        String	base64	=	Base64.encodeToString(
                authString.getBytes(), Base64.NO_WRAP);
        //	Maak een	POST-request
        HttpPost request	=
                new HttpPost("https://api.twitter.com/oauth2/token");
        //	Voeg key+secret	toe
        request.setHeader("Authorization",	"Basic	"	+	base64);
        request.setHeader("Content-Type",
                "application/x-www-form-urlencoded;charset=UTF-8");
        //	Vul	body:	vertel dat	je	inlogt	met	app	key	en	secret
        try {
            request.setEntity(
                    new StringEntity("grant_type=client_credentials"));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        search.setOnQueryTextListener(new TextListener());

    }

    class TextListener implements SearchView.OnQueryTextListener{

        @Override
        public boolean onQueryTextSubmit(String query) {
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {

            try {
                String s = URLEncoder.encode(newText , "UTF-8");
                HttpGet httpGet =new HttpGet("https:/api.twitter.com/1.1/search/tweets.json?q=" + s);
                httpGet.setHeader("Authorization", "Bearer " + token);
                ResponseHandler<String> handler
                        = new BasicResponseHandler();
                String searchJSON = client.execute(httpGet, handler);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }


        }
    }
}
