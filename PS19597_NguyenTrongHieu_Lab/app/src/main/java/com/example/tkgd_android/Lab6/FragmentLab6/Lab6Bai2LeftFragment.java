package com.example.tkgd_android.Lab6.FragmentLab6;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.tkgd_android.R;
public class Lab6Bai2LeftFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lab6_bai2_left, container, false);
        EditText edt = view.findViewById(R.id.edtLab6Bai2);
        Button btn = view.findViewById(R.id.btnLab6Bai2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noidung = edt.getText().toString();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                Lab6Bai2RightFragment fragment = (Lab6Bai2RightFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView3);
                fragment.tv.setText(noidung);
            }
        });
        return view;
    }
}