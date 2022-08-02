package com.example.tkgd_android.Lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tkgd_android.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class Lab7Bai2 extends AppCompatActivity {
    TextInputEditText edtName, edtEmail, edtPass;
    TextView tvName, tvEmail, tvPass;
    FloatingActionButton flbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab7_bai2);
        tvName = findViewById(R.id.tv1Lab7Bai2);
        tvEmail = findViewById(R.id.tv2Lab7Bai2);
        tvPass = findViewById(R.id.tv3Lab7Bai2);
        edtName = findViewById(R.id.edt1Lab7Bai2);
        edtEmail = findViewById(R.id.edt2Lab7Bai2);
        edtPass = findViewById(R.id.edt3Lab7Bai2);
        flbutton = findViewById(R.id.ftbLab7Bai2);

        flbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean thanhcong = true;
                if(edtName.getText().toString().isEmpty()){
                    tvName.setText("Tên không được bỏ trống!");
                    thanhcong = false;
                    return;
                }else {
                    tvName.setText("");
                }
                String email = edtEmail.getText().toString();
                String emailRegex = "\\b[a-z0-9._%-]+@[a-z0-9.-]+\\.[a-z]{2,4}\\b";
                if(email.matches(emailRegex)){
                    tvEmail.setText("");
                }else {
                    tvEmail.setText("Email không hợp lệ");
                    thanhcong = false;
                    return;
                }
                if(edtPass.getText().toString().length()<6){
                    tvPass.setText("Password phải từ 6 ký tự trở lên");
                    thanhcong = false;
                    return;
                }
                else {
                    tvPass.setText("");
                }
                if(thanhcong == true){
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}