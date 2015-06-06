package com.example.logmaarin.learningmaterialdesign;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by LogMaarIn on 5-6-2015.
 */
public class SearchResultsActivity extends Activity {

    private TextView lol;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.lolilol);
        lol = (TextView) findViewById(R.id.textView2);
        handleIntent(getIntent());
    }

    @Override
    protected void onNewIntent(Intent intent) {

        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            lol.setText(query);

        }
    }

}
