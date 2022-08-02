package com.example.tkgd_android.Lab6.ViewPagerAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.tkgd_android.Lab6.FragmentLab6.Lab6Bai3Tab1Fragment;
import com.example.tkgd_android.Lab6.FragmentLab6.Lab6Bai3Tab2Fragment;
import com.example.tkgd_android.Lab6.FragmentLab6.Lab6Bai3Tab3Fragment;

public class Lab6Bai3ViewPager extends FragmentStatePagerAdapter {
    public Lab6Bai3ViewPager(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Lab6Bai3Tab1Fragment();
            case 1:
                return new Lab6Bai3Tab2Fragment();
            case 2:
                return new Lab6Bai3Tab3Fragment();
            default:
                return new Lab6Bai3Tab1Fragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "Tab1";
                break;
            case 1:
                title = "Tab2";
                break;
            case 2:
                title = "Tab3";
                break;
            default:
                title = "Tab1";
                break;
        }
        return title;
    }
}
