package com.example.tkgd_android.Asm.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tkgd_android.Asm.Adapter.ViewPageAdapterChi;
import com.example.tkgd_android.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
public class AsmChiFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewPageAdapterChi viewPageAdapterChi;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asm_chi, container, false);
        tabLayout = view.findViewById(R.id.tabLayoutChiAsm);
        viewPager2 = view.findViewById(R.id.viewPagerChiAsm);
        viewPageAdapterChi = new ViewPageAdapterChi(getActivity());
        viewPager2.setAdapter(viewPageAdapterChi);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Loại chi");
                        break;
                    case 1:
                        tab.setText("Khoản chi");
                        break;
                }
            }
        }).attach();
        return view;
    }
}