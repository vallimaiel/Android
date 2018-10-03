package com.example.vallimaielc.smoothiesprototype;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

public class PagerAdapterDetails extends FragmentStatePagerAdapter {
    int NoOfTabs;
    public PagerAdapterDetails(FragmentManager fm,int NoOfTabs)
    {
        super(fm);
        this.NoOfTabs=NoOfTabs;

    }

    @Override
    public Fragment getItem(int i) {
        switch(i) {
            case 0:
                Ingredients tab1=new Ingredients();
                return tab1;
            case 1:
                Preparation tab2 = new Preparation();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return NoOfTabs;
    }
}
