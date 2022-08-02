package com.example.tkgd_android.Lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.tkgd_android.R;
import com.google.android.material.snackbar.Snackbar;

public class Lab7Bai1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7_bai1);
        Button btn = findViewById(R.id.btnLab7Bai1Snackbar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "Xin chào lab7", Snackbar.LENGTH_LONG)
                        .setAction("Hoàn tác", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                            }
                        });
                snackbar.show();
            }
        });
    }
}