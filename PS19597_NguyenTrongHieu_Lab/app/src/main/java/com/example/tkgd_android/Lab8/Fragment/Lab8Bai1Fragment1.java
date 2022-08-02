package com.example.tkgd_android.Lab8.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tkgd_android.Lab8.Adapter.Lab8Bai2Adapter;
import com.example.tkgd_android.Lab8.Modul.SanPham;
import com.example.tkgd_android.R;

import java.util.ArrayList;

public class Lab8Bai1Fragment1 extends Fragment {

    private ArrayList<SanPham> list = new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lab8_bai1, container, false);
        recyclerView = view.findViewById(R.id.rcvLab8Bai2);

        Lab8Bai2Adapter adapter = new Lab8Bai2Adapter();
        addlist();
        adapter.setData(list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        //layoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        return view;
    }

    private void addlist() {
        list.add(new SanPham("Kimsoeun", R.drawable.kimsoeun));
        list.add(new SanPham("kimtaehee", R.drawable.kimtaehee));
        list.add(new SanPham("kimnamjoo", R.drawable.kimnamjoo));
        list.add(new SanPham("kimheesun", R.drawable.kimheesun));
        list.add(new SanPham("Kimsoeun", R.drawable.kimsoeun));
        list.add(new SanPham("kimtaehee", R.drawable.kimtaehee));
        list.add(new SanPham("kimnamjoo", R.drawable.kimnamjoo));
        list.add(new SanPham("kimheesun", R.drawable.kimheesun));
    }
}