package com.example.logmaarin.learningmaterialdesign;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by LogMaarIn on 15-5-2015.
 */
public class tab2 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private TweetModel m;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_2, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.cardview);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        TweetApp app = (TweetApp) getActivity().getApplicationContext();
        m = app.getModel();

        mAdapter = new cardViewAdapter(m.getTweetList());
        mRecyclerView.setAdapter(mAdapter);



        return v;
    }
}
