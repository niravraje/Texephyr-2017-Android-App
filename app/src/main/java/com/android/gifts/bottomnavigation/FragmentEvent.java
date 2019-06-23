package com.android.gifts.bottomnavigation;


import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentEvent extends Fragment {

    public static TabLayout tabLayout;
    public static ViewPager viewPager;
    public static int int_items = 5;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View x =  inflater.inflate(R.layout.event_fragment,null);
        getActivity().setTitle("Rules");
        tabLayout = (TabLayout) x.findViewById(R.id.tabs);
        viewPager = (ViewPager) x.findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        return x;

    }

    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }



        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            switch (position){
                case 0 : return new FragmentBrainstorming();
                case 1 : return new FragmentCoding();
                case 2 : return new FragmentRacing();
                case 3 : return new FragmentRobots();
                case 4 : return new FragmentGaming();
                case 5 : return new FragmentSports();
            }
            return null;
        }

        @Override
        public int getCount() {
            return int_items;
        }

        public CharSequence getPageTitle(int position) {

            switch (position){
                case 0 :
                    return "Brainstorming";
                case 1 :
                    return "Coding";
                case 2 :
                    return "Racing";
                case 3 :
                    return "Robots";
                case 4 :
                    return "Gaming";
                case 5 :
                    return "Sports";
            }
            return null;
        }
    }

}
