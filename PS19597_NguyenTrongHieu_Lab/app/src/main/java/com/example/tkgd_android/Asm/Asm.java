package com.example.tkgd_android.Asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.example.tkgd_android.MainActivity;
import com.example.tkgd_android.R;
import com.ramotion.paperonboarding.PaperOnboardingEngine;
import com.ramotion.paperonboarding.PaperOnboardingPage;
import com.ramotion.paperonboarding.listeners.PaperOnboardingOnRightOutListener;

import java.util.ArrayList;

public class Asm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_asm);

        setContentView(R.layout.onboarding_main_layout);
        PaperOnboardingEngine engine = new PaperOnboardingEngine(findViewById(R.id.onboardingRootView), getPaperOnboardingPagesData(), this);
        engine.setOnRightOutListener(new PaperOnboardingOnRightOutListener() {
            @Override
            public void onRightOut() {
                Intent intent = new Intent(Asm.this, AsmLogin.class);
                startActivity(intent);
                finish();
            }
        });
    }
    private ArrayList<PaperOnboardingPage> getPaperOnboardingPagesData(){
        PaperOnboardingPage scr1 = new PaperOnboardingPage("School",
                "All Student and hostels are sorted by hospitality rating",
                Color.parseColor("#678FB4"), R.mipmap.school, R.mipmap.keys);
        PaperOnboardingPage scr2 = new PaperOnboardingPage("Banks",
                "We carefully verify all banks before add them into the app",
                Color.parseColor("#65B0B4"), R.mipmap.classroom, R.mipmap.cap);
        PaperOnboardingPage scr3 = new PaperOnboardingPage("Stores",
                "All local stores are categorized for your convenience",
                Color.parseColor("#9B90BC"), R.mipmap.classroom1, R.mipmap.students);

        ArrayList<PaperOnboardingPage> elements = new ArrayList<>();
        elements.add(scr1);
        elements.add(scr2);
        elements.add(scr3);
        return elements;
    }
}