package com.example.logmaarin.learningmaterialdesign;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by LogMaarIn on 15-5-2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    CharSequence titles[];
    int numberOfTabs;

    public ViewPagerAdapter(FragmentManager fm, CharSequence titles[], int numberOfTabs) {
        super(fm);

        this.titles = titles;
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }




    @Override
    public Fragment getItem(int position) {

        if (position == 0){
            tab1 tab = new tab1();
            return tab;
        } else {
            tab2 tab = new tab2();
            return tab;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
