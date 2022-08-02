package com.example.tkgd_android.Asm.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.tkgd_android.Asm.Fragment.AsmKhoanThuFragment;
import com.example.tkgd_android.Asm.Fragment.AsmLoaiThuFragment;

public class ViewPagerAdapterThu extends FragmentStateAdapter {
    public ViewPagerAdapterThu(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 1) {
            return new AsmKhoanThuFragment();
        }
        return new AsmLoaiThuFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
