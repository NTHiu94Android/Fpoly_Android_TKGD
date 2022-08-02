package com.example.tkgd_android.Lab5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tkgd_android.R;

public class Lab5Bai3 extends AppCompatActivity {
    Button nut1, nut2, nut3, nut4;
    String mangNut[] = {"Nút 1", "Nút 2", "Nút 3", "Nút 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_bai3);
        nut1 = findViewById(R.id.btnLab5Bai3Nut1);
        nut2 = findViewById(R.id.btnLab5Bai3Nut2);
        nut3 = findViewById(R.id.btnLab5Bai3Nut3);
        nut4 = findViewById(R.id.btnLab5Bai3Nut4);

        nut1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertNut1();
            }
        });
        nut2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertNut2();
            }
        });
        nut3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertNut3();
            }
        });
        nut4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertNut4();
            }
        });
    }

    private void AlertNut4() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Lab5Bai3.this);
        builder.setTitle("Nút 4");
        builder.setMultiChoiceItems(mangNut, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                Toast.makeText(Lab5Bai3.this, ""+mangNut[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void AlertNut3() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Lab5Bai3.this);
        builder.setTitle("Nút 3");
        builder.setSingleChoiceItems(mangNut, R.color.black, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Lab5Bai3.this, ""+mangNut[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    private void AlertNut2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Lab5Bai3.this);
        builder.setTitle("Nút 2");
        builder.setItems(mangNut, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(Lab5Bai3.this, ""+mangNut[i], Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void AlertNut1() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Lab5Bai3.this);
        builder.setTitle("Nút 1");
        builder.setMessage("Nội dung nút 1");

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}