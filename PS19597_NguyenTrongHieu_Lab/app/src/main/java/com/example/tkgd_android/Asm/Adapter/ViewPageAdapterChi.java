package com.example.tkgd_android.Asm.Adapter;


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tkgd_android.Asm.Fragment.AsmKhoanChiFragment;
import com.example.tkgd_android.Asm.Fragment.AsmLoaiChiFragment;

public class ViewPageAdapterChi extends FragmentStateAdapter {

    public ViewPageAdapterChi(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) {
            return new AsmLoaiChiFragment();
        }
        return new AsmKhoanChiFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
