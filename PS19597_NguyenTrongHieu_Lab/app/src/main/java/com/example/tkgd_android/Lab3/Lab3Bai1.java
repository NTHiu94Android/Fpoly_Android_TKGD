package com.example.tkgd_android.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.tkgd_android.Lab3.Adapter.AdapterLab3Bai1;
import com.example.tkgd_android.Lab3.Class.ClassLab3Bai1;
import com.example.tkgd_android.R;

import java.util.ArrayList;

public class Lab3Bai1 extends AppCompatActivity {
    private ListView lv;
    private ArrayList<ClassLab3Bai1> list = new ArrayList<>();
    private AdapterLab3Bai1 adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_bai1);
        lv = findViewById(R.id.lvLab3Bai1);
        list.add(new ClassLab3Bai1(R.drawable.kimheesun, "kimheesun", 18));
        list.add(new ClassLab3Bai1(R.drawable.kimnamjoo, "kimnamjoo", 19));
        list.add(new ClassLab3Bai1(R.drawable.kimtaehee, "kimtaehee", 20));
        list.add(new ClassLab3Bai1(R.drawable.kimsoeun, "kimsoeun", 21));

        adapter = new AdapterLab3Bai1(list, Lab3Bai1.this);
        lv.setAdapter(adapter);
    }
}