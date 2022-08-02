package com.example.tkgd_android.Lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tkgd_android.R;

public class Lab5Bai2 extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_bai2);
        btn = findViewById(R.id.btnLab5Bai2ProgressDialog);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ProgressDialog progressDialog = ProgressDialog.show(Lab5Bai2.this, "Lab5Bai2", "Loading...");
                CountDownTimer timer = new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long l) {

                    }

                    @Override
                    public void onFinish() {
                        progressDialog.dismiss();
                        Toast.makeText(Lab5Bai2.this, "Finish", Toast.LENGTH_SHORT).show();
                    }
                };
                timer.start();
            }
        });
    }
}