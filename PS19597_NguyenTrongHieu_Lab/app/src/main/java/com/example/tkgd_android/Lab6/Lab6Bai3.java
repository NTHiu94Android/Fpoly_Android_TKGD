package com.example.tkgd_android.Lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.tkgd_android.Lab6.ViewPagerAdapter.Lab6Bai3ViewPager;
import com.example.tkgd_android.R;
import com.google.android.material.tabs.TabLayout;

public class Lab6Bai3 extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_bai3);
        viewPager = findViewById(R.id.viewPagerLab6Bai3);
        tabLayout = findViewById(R.id.tabLayoutLab6Bai3);

        Lab6Bai3ViewPager viewPagerAdapter = new Lab6Bai3ViewPager(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}