package com.example.tkgd_android.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.tkgd_android.Lab3.Adapter.AdapterLab3Bai2;
import com.example.tkgd_android.Lab3.Class.ClassLab3Bai2;
import com.example.tkgd_android.Lab3.Class.ClassLab3Bai4;
import com.example.tkgd_android.R;

import java.util.ArrayList;

public class Lab3Bai2 extends AppCompatActivity {
    private Spinner spn;
    private ArrayList<ClassLab3Bai2> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_bai2);
        spn = findViewById(R.id.spnLab3Bai2);
        list.add(new ClassLab3Bai2(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai2(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai2(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai2(R.drawable.kimtaehee, "kimtaehee"));
        list.add(new ClassLab3Bai2(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai2(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai2(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai2(R.drawable.kimtaehee, "kimtaehee"));
        list.add(new ClassLab3Bai2(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai2(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai2(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai2(R.drawable.kimtaehee, "kimtaehee"));

        AdapterLab3Bai2 adapter = new AdapterLab3Bai2(list, Lab3Bai2.this);
        spn.setAdapter(adapter);
    }
}