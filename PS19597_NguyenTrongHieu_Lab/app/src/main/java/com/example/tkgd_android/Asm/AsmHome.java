package com.example.tkgd_android.Asm;

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
import android.widget.Toast;

import com.example.tkgd_android.Asm.Fragment.AsmChiFragment;
import com.example.tkgd_android.Asm.Fragment.AsmGioiThieuFragment;
import com.example.tkgd_android.Asm.Fragment.AsmThongKeFragment;
import com.example.tkgd_android.Asm.Fragment.AsmThuFragment;
import com.example.tkgd_android.R;
import com.google.android.material.navigation.NavigationView;

public class AsmHome extends AppCompatActivity {
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private long back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asm_home);
        toolbar = findViewById(R.id.tbAsm);
        drawerLayout = findViewById(R.id.drawerLayoutAsm);
        navigationView = findViewById(R.id.navigationViewAsm);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_apple);
        actionBar.setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment;
                Class fragmentClass = null;
                switch (item.getItemId()) {
                    case R.id.asmMenuChi:
                        fragmentClass = AsmChiFragment.class;
                        break;
                    case R.id.asmMenuThu:
                        fragmentClass = AsmThuFragment.class;
                        break;
                    case R.id.asmMenuThongKe:
                        fragmentClass = AsmThongKeFragment.class;
                        break;
                    case R.id.asmMenuThoat:
                        AsmHome.super.onBackPressed();
                        break;
                    case R.id.asmMenuGioiThieu:
                        fragmentClass = AsmGioiThieuFragment.class;
                        break;
                }
                try {
                    fragment = (Fragment) fragmentClass.newInstance();
                    FragmentManager fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction().replace(R.id.frameLayout, fragment).commit();

                    //item.setChecked(true);
                    setTitle(item.getTitle());
                    drawerLayout.closeDrawer(GravityCompat.START);
                } catch (Exception exception) {
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        if(back + 2000 > System.currentTimeMillis()){
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(AsmHome.this, "Trở lại lần nữa để thoát", Toast.LENGTH_SHORT).show();
        }
        back = System.currentTimeMillis();
    }
}