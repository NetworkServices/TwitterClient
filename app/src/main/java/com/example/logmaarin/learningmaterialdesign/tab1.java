package com.example.logmaarin.learningmaterialdesign;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * Created by LogMaarIn on 15-5-2015.
 */
public class tab1 extends Fragment {

    ListView list;
    private TweetModel m;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TweetApp app = (TweetApp) getActivity().getApplicationContext();
        View v = inflater.inflate(R.layout.tab_1, container, false);

        list = (ListView) v.findViewById(R.id.listView1);

        m = app.getModel();
        TweetAdapter adapter = new TweetAdapter(getActivity(), m.getTweetList());
        list.setAdapter(adapter);

        return v;
    }
}
