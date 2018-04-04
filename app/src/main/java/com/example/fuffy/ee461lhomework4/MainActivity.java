package com.example.fuffy.ee461lhomework4;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import junit.framework.Test;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button enter = findViewById(R.id.enter_location_button);
//        enter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
//        Intent intent = new Intent(this, MapsActivity.class);
//        startActivity(intent);

        SectionsPagerAdapter pagerAdapter =
                new SectionsPagerAdapter(getSupportFragmentManager());

        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(pager);
        //startActivity(new Intent(), MapsActivity);
    }


    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm){
            super(fm);
        }


        @Override
        public int getCount(){
            return 2;
        }

        @Override public Fragment getItem(int position){
            if(position==0){
                return new MapFragment();
            }
            else{
                return new MapFragmentTabTwo();
            }
        }

        @Override
        public CharSequence getPageTitle(int position){
            if(position==0){
                return getResources().getText(R.string.location_tab);
            }
            else{
                return getResources().getText(R.string.coordinate_tab);
            }
        }

    }
}
