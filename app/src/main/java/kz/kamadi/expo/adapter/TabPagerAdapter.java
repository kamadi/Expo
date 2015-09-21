package kz.kamadi.expo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import kz.kamadi.expo.R;
import kz.kamadi.expo.fragment.EventFragment;
import kz.kamadi.expo.fragment.GuideFragment;
import kz.kamadi.expo.fragment.MapFragment;
import kz.kamadi.expo.fragment.VisitFragment;

/**
 * Created by Madiyar on 21.09.2015.
 */
public class TabPagerAdapter extends FragmentStatePagerAdapter {

    Context context;
    String [] tabs;
    public TabPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context = context;
        tabs = context.getResources().getStringArray(R.array.tabs);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;

        switch (position){
            case 0:
                fragment = new EventFragment();
                break;
            case 1:
                fragment = new VisitFragment();
                break;
            case 2:
                fragment = new MapFragment();
                break;
            case 3:
                fragment = new GuideFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
