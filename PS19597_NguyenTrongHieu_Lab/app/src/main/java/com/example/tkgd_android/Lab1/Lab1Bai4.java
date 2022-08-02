package com.example.tkgd_android.Lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.example.tkgd_android.R;
import java.util.Random;

public class Lab1Bai4 extends AppCompatActivity {

    private FrameLayout fl;
    private int imageCards[]={
                    R.drawable.c1,R.drawable.c2,R.drawable.c3,R.drawable.c4,R.drawable.c5,
                    R.drawable.c6,R.drawable.c7,R.drawable.c8,R.drawable.c9,R.drawable.c10,
                    R.drawable.cj,R.drawable.cq,R.drawable.ck,

//                    R.drawable.d1,R.drawable.d2,R.drawable.d3,R.drawable.d4,R.drawable.d5,
//                    R.drawable.d6,R.drawable.d7,R.drawable.d8,R.drawable.d9,R.drawable.d10,
//                    R.drawable.dj,R.drawable.dq,R.drawable.dk,
//
//                    R.drawable.h1,R.drawable.h2,R.drawable.h3,R.drawable.h4,R.drawable.h5,
//                    R.drawable.h6,R.drawable.h7,R.drawable.h8,R.drawable.h9,R.drawable.h10,
//                    R.drawable.hj,R.drawable.hq,R.drawable.hk,
//
//                    R.drawable.s1,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
//                    R.drawable.s6,R.drawable.s7,R.drawable.s8,R.drawable.s9,R.drawable.s10,
//                    R.drawable.sj,R.drawable.sq,R.drawable.sk
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab1_bai4);
        day1();
    }
    public void day1(){
        fl = findViewById(R.id.FrameLayoutLab1);
        int batky;
        for (int i = 0; i < 13; i++) {
            Random r = new Random();
            batky = r.nextInt(imageCards.length);

            FrameLayout.LayoutParams paramsbt = new FrameLayout.LayoutParams(220, 100);
            Button bt = new Button(this);
            bt.setText("Xếp bài");
            bt.setTextSize(12);
            paramsbt.topMargin = 500;
            paramsbt.leftMargin = 100;
            bt.setLayoutParams(paramsbt);

            ImageView iv = new ImageView(this);
            iv.setImageResource(imageCards[batky]);
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(350, 400);
            params.leftMargin = (i+1) * 50;
            params.topMargin = 50;
            iv.setLayoutParams(params);

            fl.addView(iv);
            fl.addView(bt);

            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ImageView imv = (ImageView) view;
                    FrameLayout.LayoutParams params1 = (FrameLayout.LayoutParams) imv.getLayoutParams();
                    if(params1.topMargin == 50) {
                        params1.topMargin = 30;
                    }else if(params1.topMargin == 30) {
                        params1.topMargin = 50;
                    }
                    imv.setLayoutParams(params1);
                }
            });
        }
    }
}