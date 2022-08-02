package com.example.tkgd_android.Lab6.FragmentLab6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tkgd_android.R;
public class Lab6Bai1Right2Fragment extends Fragment {

    public Lab6Bai1Right2Fragment() {
        // Required empty public constructor
    }
    // TODO: Rename and change types and number of parameters
    public static Lab6Bai1Right2Fragment newInstance() {
        Lab6Bai1Right2Fragment fragment = new Lab6Bai1Right2Fragment();
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
        return inflater.inflate(R.layout.fragment_lab6_bai1_right2, container, false);
    }
}