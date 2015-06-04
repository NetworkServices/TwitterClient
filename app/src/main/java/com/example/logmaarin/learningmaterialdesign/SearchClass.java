package com.example.logmaarin.learningmaterialdesign;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.widget.SearchView;
import android.widget.TextView;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.concurrent.ExecutionException;

/**
 * Created by LogMaarIn on 2-6-2015.
 */


public class SearchClass extends Activity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    String token;
    SearchView search;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        search = (SearchView) findViewById(R.id.searchView);
        text = (TextView) findViewById(R.id.textView);

        try {
            token = new TokenAsyncTask().execute().get();
            Log.d("hoi", "gelukt!");
            Log.d("hoi", token);
        }
        catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        search.setOnQueryTextListener(new TextListener());





    }

    class TextListener implements SearchView.OnQueryTextListener{

        @Override
        public boolean onQueryTextSubmit(String query) {
            String[] params = new String[]{query, token};
            try {
                String s = new SearchTask().execute(params).get();
                text.setText(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }


           return true;
        }

        @Override
        public boolean onQueryTextChange(String newText) {



            return false;
        }
    }
}
