package com.example.tkgd_android.Lab6.FragmentLab6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tkgd_android.R;

public class Lab6Bai1Right1Fragment extends Fragment {

    public Lab6Bai1Right1Fragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static Lab6Bai1Right1Fragment newInstance() {
        Lab6Bai1Right1Fragment fragment = new Lab6Bai1Right1Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lab6_bai1_right1, container, false);
    }
}