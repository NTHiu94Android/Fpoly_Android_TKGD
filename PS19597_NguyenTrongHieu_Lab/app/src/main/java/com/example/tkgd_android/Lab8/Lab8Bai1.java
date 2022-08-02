package com.example.tkgd_android.Lab8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.tkgd_android.Lab8.Fragment.Lab8Bai1Fragment1;
import com.example.tkgd_android.Lab8.Fragment.Lab8Bai1Fragment2;
import com.example.tkgd_android.Lab8.Fragment.Lab8Bai1Fragment3;
import com.example.tkgd_android.R;
import com.google.android.material.navigation.NavigationView;

public class Lab8Bai1 extends AppCompatActivity {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab8_bai1);
        toolbar = findViewById(R.id.toolbarLab8);
        navigationView = findViewById(R.id.navViewLAb8);
        drawerLayout = findViewById(R.id.drawerLayoutLab8);

        setSupportActionBar(toolbar);
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                Class fragmentClass = null;
                switch (item.getItemId()){
                    case R.id.lab8Bai1_Fragment1:
                        fragmentClass = Lab8Bai1Fragment1.class; break;
                    case R.id.lab8Bai1_Fragment2:
                        fragmentClass = Lab8Bai1Fragment2.class; break;
                    case R.id.lab8Bai1_Fragment3:
                        fragmentClass = Lab8Bai1Fragment3.class; break;
                }
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                    FragmentManager manager = getSupportFragmentManager();
                    manager.beginTransaction().replace(R.id.frameLayoutLa88Bai1, fragment).commit();
                    setTitle(item.getTitle());
                    drawerLayout.closeDrawer(GravityCompat.START);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }
}