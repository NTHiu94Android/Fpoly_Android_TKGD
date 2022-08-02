package com.example.tkgd_android.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tkgd_android.R;

public class Lab3 extends AppCompatActivity {

    Button btnLab3Bai1, btnLab3Bai2, btnLab3Bai3, btnLab3Bai4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab3);
        btnLab3Bai1 = findViewById(R.id.btnLab3Bai1);
        btnLab3Bai2 = findViewById(R.id.btnLab3Bai2);
        btnLab3Bai3 = findViewById(R.id.btnLab3Bai3);
        btnLab3Bai4 = findViewById(R.id.btnLab3Bai4);

        btnLab3Bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3.this, Lab3Bai1.class);
                startActivity(intent);
            }
        });
        btnLab3Bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3.this, Lab3Bai2.class);
                startActivity(intent);
            }
        });
        btnLab3Bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3.this, Lab3Bai3.class);
                startActivity(intent);
            }
        });
        btnLab3Bai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab3.this, Lab3Bai4.class);
                startActivity(intent);
            }
        });
    }
}