package com.example.tkgd_android.Lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tkgd_android.Lab5.Lab5;
import com.example.tkgd_android.Lab5.Lab5Bai1;
import com.example.tkgd_android.Lab5.Lab5Bai2;
import com.example.tkgd_android.Lab5.Lab5Bai3;
import com.example.tkgd_android.R;

public class Lab6 extends AppCompatActivity {
    Button btnLab6Bai1, btnLab6Bai2, btnLab6Bai3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6);

        btnLab6Bai1 = findViewById(R.id.btnLab6Bai1);
        btnLab6Bai2 = findViewById(R.id.btnLab6Bai2);
        btnLab6Bai3 = findViewById(R.id.btnLab6Bai3);

        btnLab6Bai1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab6.this, Lab6Bai1.class);
                startActivity(intent);
            }
        });
        btnLab6Bai2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab6.this, Lab6Bai2.class);
                startActivity(intent);
            }
        });
        btnLab6Bai3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Lab6.this, Lab6Bai3.class);
                startActivity(intent);
            }
        });
    }
}