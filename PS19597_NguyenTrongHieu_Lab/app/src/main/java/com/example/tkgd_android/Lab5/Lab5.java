package com.example.tkgd_android.Lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tkgd_android.Lab3.Lab3;
import com.example.tkgd_android.Lab3.Lab3Bai1;
import com.example.tkgd_android.Lab3.Lab3Bai2;
import com.example.tkgd_android.Lab3.Lab3Bai3;
import com.example.tkgd_android.Lab3.Lab3Bai4;
import com.example.tkgd_android.R;

public class Lab5 extends AppCompatActivity {
    Button btnLab5Bai1, btnLab5Bai2, btnLab5Bai3, btnLab5Bai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5);

        btnLab5Bai1 = findViewById(R.id.btnLab5Bai1);
        btnLab5Bai2 = findViewById(R.id.btnLab5Bai2);
        btnLab5Bai3 = findViewById(R.id.btnLab5Bai3);
        btnLab5Bai4 = findViewById(R.id.btnLab5Bai4);

        btnLab5Bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab5.this, Lab5Bai1.class);
                startActivity(intent);
            }
        });
        btnLab5Bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab5.this, Lab5Bai2.class);
                startActivity(intent);
            }
        });
        btnLab5Bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab5.this, Lab5Bai3.class);
                startActivity(intent);
            }
        });
        btnLab5Bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab5.this, Lab5Bai4.class);
                startActivity(intent);
            }
        });
    }
}