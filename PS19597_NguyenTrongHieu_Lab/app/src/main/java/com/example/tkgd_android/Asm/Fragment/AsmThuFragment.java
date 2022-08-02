package com.example.tkgd_android.Asm.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.tkgd_android.Asm.Adapter.ViewPagerAdapterThu;
import com.example.tkgd_android.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
public class AsmThuFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AsmThuFragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static AsmThuFragment newInstance(String param1, String param2) {
        AsmThuFragment fragment = new AsmThuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private TabLayout tabLayout;
    private ViewPager2 viewPager2;
    private ViewPagerAdapterThu viewPageAdapterThu;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_asm_thu, container, false);
        tabLayout = view.findViewById(R.id.tabLayoutThuAsm);
        viewPager2 = view.findViewById(R.id.viewPagerThuAsm);
        viewPageAdapterThu = new ViewPagerAdapterThu(getActivity());
        viewPager2.setAdapter(viewPageAdapterThu);

        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                switch (position){
                    case 0:
                        tab.setText("Loại thu");
                        break;
                    case 1:
                        tab.setText("Khoản thu");
                        break;
                }
            }
        }).attach();
        return view;
    }
}