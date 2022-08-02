package com.example.tkgd_android.Lab5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tkgd_android.R;

public class Lab5Bai4 extends AppCompatActivity {

    Button btnCancel, btnLogin;
    EditText edtUser, edtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab5_bai4);
        Button btn = findViewById(R.id.btnLab5Bai4Nut1);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Lab5Bai4.this);
        LayoutInflater inflater = Lab5Bai4.this.getLayoutInflater();
        View v = inflater.inflate(R.layout.dialog_lab5_bai4, null);

        builder.setView(v);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        btnCancel = v.findViewById(R.id.btnLab5Bai4Cancel);
        btnLogin = v.findViewById(R.id.btnLab5Bai4Login);
        edtUser = v.findViewById(R.id.edtLab5Bai4User);
        edtPass = v.findViewById(R.id.edtLab5Bai4Pass);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Lab5Bai4.this, "Hủy thành công", Toast.LENGTH_SHORT).show();
                alertDialog.dismiss();
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = edtUser.getText().toString().trim();
                String pass = edtPass.getText().toString().trim();
                if(user.equals("admin") && pass.equals("admin")){
                    Toast.makeText(Lab5Bai4.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                }else {
                    Toast.makeText(Lab5Bai4.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    alertDialog.dismiss();
                }
            }
        });

    }
}