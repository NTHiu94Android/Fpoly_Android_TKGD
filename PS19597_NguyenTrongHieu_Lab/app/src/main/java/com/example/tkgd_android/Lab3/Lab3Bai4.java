package com.example.tkgd_android.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.tkgd_android.Lab3.Adapter.AdapterLab3Bai4;
import com.example.tkgd_android.Lab3.Class.ClassLab3Bai4;
import com.example.tkgd_android.R;

import java.util.ArrayList;

public class Lab3Bai4 extends AppCompatActivity {
    private ListView lv;
    private ArrayList<ClassLab3Bai4> list = new ArrayList<>();
    private AdapterLab3Bai4 adpter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3_bai4);
        lv = findViewById(R.id.lvLab3Bai4);
        list.add(new ClassLab3Bai4(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai4(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai4(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai4(R.drawable.kimtaehee, "kimtaehee"));
        list.add(new ClassLab3Bai4(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai4(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai4(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai4(R.drawable.kimtaehee, "kimtaehee"));
        list.add(new ClassLab3Bai4(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai4(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai4(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai4(R.drawable.kimtaehee, "kimtaehee"));

        list.add(new ClassLab3Bai4(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai4(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai4(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai4(R.drawable.kimtaehee, "kimtaehee"));
        list.add(new ClassLab3Bai4(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai4(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai4(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai4(R.drawable.kimtaehee, "kimtaehee"));
        list.add(new ClassLab3Bai4(R.drawable.kimheesun, "kimheesun"));
        list.add(new ClassLab3Bai4(R.drawable.kimnamjoo, "kimnamjoo"));
        list.add(new ClassLab3Bai4(R.drawable.kimsoeun, "kimsoeun"));
        list.add(new ClassLab3Bai4(R.drawable.kimtaehee, "kimtaehee"));

        adpter = new AdapterLab3Bai4(list, Lab3Bai4.this);
        lv.setAdapter(adpter);
    }
}