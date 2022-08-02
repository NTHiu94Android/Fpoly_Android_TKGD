package com.example.tkgd_android.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.GridView;

import com.example.tkgd_android.Lab3.Adapter.AdapterLab3Bai3;
import com.example.tkgd_android.Lab3.Class.ClassLab3Bai2;
import com.example.tkgd_android.Lab3.Class.ClassLab3Bai3;
import com.example.tkgd_android.R;

import java.util.ArrayList;

public class Lab3Bai3 extends AppCompatActivity {
    private GridView gv;
    private ArrayList<ClassLab3Bai3> list = new ArrayList<>();
    private AdapterLab3Bai3 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_bai3);
        gv = findViewById(R.id.gvLab3Bai3);

        list.add(new ClassLab3Bai3(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai3(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai3(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai3(R.drawable.kimtaehee, "kimtaehee"));
        list.add(new ClassLab3Bai3(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai3(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai3(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai3(R.drawable.kimtaehee, "kimtaehee"));
        list.add(new ClassLab3Bai3(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai3(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai3(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai3(R.drawable.kimtaehee, "kimtaehee"));

        adapter = new AdapterLab3Bai3(list, getApplicationContext());
        gv.setAdapter(adapter);
    }
}