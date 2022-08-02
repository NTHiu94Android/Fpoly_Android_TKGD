package com.example.tkgd_android.Asm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.tkgd_android.R;

public class AsmLogin extends AppCompatActivity {

    private Button btnLogin, btnSingUp;
    //private CheckBox chkRmb;
    private EditText edtUsername, edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asm_login);
        btnLogin = findViewById(R.id.btnLoginLoginAsm);
        btnSingUp = findViewById(R.id.btnSignUpLoginAsm);
        //chkRmb = findViewById(R.id.chkRememberLoginAsm);
        edtUsername = findViewById(R.id.edtUsernameLoginAsm);
        edtPassword = findViewById(R.id.edtPasswordLoginAsm);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
        btnSingUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AsmSignUp.class);
                startActivity(intent);
            }
        });
    }
    private void login(){
        Intent intent = new Intent(AsmLogin.this, AsmHome.class);
        startActivity(intent);
//        String user = edtUsername.getText().toString();
//        String pass = edtPassword.getText().toString();
//        if(user.equals("admin") && pass.equals("admin")){
//            Intent intent = new Intent(AsmLogin.this, AsmHome.class);
//            startActivity(intent);
//        }else{
//            Toast.makeText(AsmLogin.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
//        }
    }
}