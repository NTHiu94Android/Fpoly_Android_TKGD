package com.example.tkgd_android.Lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tkgd_android.R;

public class Lab1 extends AppCompatActivity {
    Button btnLab1Bai1, btnLab1Bai2, btnLab1Bai3, btnLab1Bai4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1);
        btnLab1Bai1 = findViewById(R.id.btnLab1Bai1);
        btnLab1Bai2 = findViewById(R.id.btnLab1Bai2);
        btnLab1Bai3 = findViewById(R.id.btnLab1Bai3);
        btnLab1Bai4 = findViewById(R.id.btnLab1Bai4);

        btnLab1Bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1.this, Lab1Bai1.class);
                startActivity(intent);
            }
        });
        btnLab1Bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1.this, Lab1Bai2.class);
                startActivity(intent);
            }
        });
        btnLab1Bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1.this, Lab1Bai3.class);
                startActivity(intent);
            }
        });
        btnLab1Bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab1.this, Lab1Bai4.class);
                startActivity(intent);
            }
        });
    }
}