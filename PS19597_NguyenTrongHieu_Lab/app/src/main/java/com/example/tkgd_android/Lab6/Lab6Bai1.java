package com.example.tkgd_android.Lab6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.example.tkgd_android.Asm.AsmHome;
import com.example.tkgd_android.Asm.Fragment.AsmChiFragment;
import com.example.tkgd_android.Asm.Fragment.AsmGioiThieuFragment;
import com.example.tkgd_android.Asm.Fragment.AsmThongKeFragment;
import com.example.tkgd_android.Asm.Fragment.AsmThuFragment;
import com.example.tkgd_android.Lab6.FragmentLab6.Lab6Bai1LeftFragment;
import com.example.tkgd_android.R;

public class Lab6Bai1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab6_bai1);
    }
}