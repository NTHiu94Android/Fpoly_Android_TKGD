package com.example.tkgd_android.Lab6.FragmentLab6;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tkgd_android.R;
public class Lab6Bai2RightFragment extends Fragment {
    public TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lab6_bai2_right, container, false);
        tv = view.findViewById(R.id.tvLab6Bai2);
        return view;
    }
}