package com.example.tkgd_android.Lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.tkgd_android.R;

import java.util.Calendar;

public class Lab5Bai1 extends AppCompatActivity {

    Button btn1, btn2;
    Calendar time = Calendar.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_bai1);

        btn1 = findViewById(R.id.btnLab5Bai1TPA);
        btn2 = findViewById(R.id.btnLab5Bai1DPA);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(Lab5Bai1.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        Toast.makeText(Lab5Bai1.this, i+":"+i1, Toast.LENGTH_SHORT).show();
                    }
                },time.get(Calendar.HOUR), time.get(Calendar.MINUTE), true);
                timePickerDialog.show();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Lab5Bai1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                        Toast.makeText(getApplicationContext(), i2+"/"+(i1+1)+"/"+i, Toast.LENGTH_SHORT).show();
                    }
                },time.get(Calendar.YEAR), time.get(Calendar.MONTH), time.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });
    }
}