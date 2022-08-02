package com.example.tkgd_android.Lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tkgd_android.R;

public class Lab7 extends AppCompatActivity {

    private Button btnBai1, btnBai2, btnBai3, btnBai4, btnBai5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7);
        btnBai1 = findViewById(R.id.btnLab7Bai1);
        btnBai2 = findViewById(R.id.btnLab7Bai2);
        btnBai3 = findViewById(R.id.btnLab7Bai3);
        btnBai4 = findViewById(R.id.btnLab7Bai4);
        btnBai5 = findViewById(R.id.btnLab7Bai5);

        btnBai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab7.this, Lab7Bai1.class);
                startActivity(intent);
            }
        });
        btnBai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab7.this, Lab7Bai2.class);
                startActivity(intent);
            }
        });
        btnBai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab7.this, Lab7Bai3.class);
                startActivity(intent);
            }
        });
        btnBai4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab7.this, Lab7Bai4.class);
                startActivity(intent);
            }
        });
        btnBai5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab7.this, Lab7Bai5.class);
                startActivity(intent);
            }
        });
    }
}