package com.example.tkgd_android.Lab7;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.tkgd_android.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Lab7Bai4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7_bai4);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNGV_lab7);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_home_lab7:
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_favorite_lab7:
                        Toast.makeText(getApplicationContext(), "Favorite", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ic_settings_lab7:
                        Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}