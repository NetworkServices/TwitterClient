package com.example.logmaarin.learningmaterialdesign;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by LogMaarIn on 15-5-2015.
 */
public class TweetAdapter extends ArrayAdapter<Tweet> {
    public TweetAdapter(Context context, List<Tweet> objects) {
        super(context, R.layout.tweet, objects);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View ItemView = convertView;

        if (ItemView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.tweet, null);
        }


        TextView naam = (TextView) convertView.findViewById(R.id.naam);
        TextView username = (TextView) convertView.findViewById(R.id.username);
        TextView tweet = (TextView) convertView.findViewById(R.id.tweet);


        Tweet currentItem = getItem(position);
        naam.setText(currentItem.getUser().getNaam());
        username.setText("@" + currentItem.getUser().getUserName());
        tweet.setText(currentItem.getTweet());
        //pf.setImageAlpha(currentItem.getPf());


        return convertView;
    }
}