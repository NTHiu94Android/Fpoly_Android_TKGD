package com.example.tkgd_android.Lab6.FragmentLab6;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tkgd_android.R;
public class Lab6Bai1LeftFragment extends Fragment {

    public Lab6Bai1LeftFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Lab6Bai1LeftFragment newInstance() {
        Lab6Bai1LeftFragment fragment = new Lab6Bai1LeftFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lab6_bai1_left, container, false);
        Button btn1 = view.findViewById(R.id.btnLab6Bai1Show1);
        Button btn2 = view.findViewById(R.id.btnLab6Bai1Show2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.framelayoutLab6Bai1, Lab6Bai1Right1Fragment.newInstance()).commit();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.framelayoutLab6Bai1, Lab6Bai1Right2Fragment.newInstance()).commit();
            }
        });
        return view;
    }
}