package com.example.loginandregistration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    private TextView signUpTv;
    private Button loginBtn;
    private EditText username;
    private EditText password;
    private String user, pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();

        user = username.getText().toString();
        pass = password.getText().toString();

        if(!(user.equals("")) && !(pass.equals(""))){
            loginBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Login.this, Welcome.class);
                    startActivity(intent);
                }
            });
        }else{
            Toast.makeText(this, "Nothing Happened", Toast.LENGTH_SHORT).show();
        }

        signUpTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, SignUp.class);
                startActivity(intent);
            }
        });
    }

    private void init() {
        signUpTv = findViewById(R.id.signUpTv);
        loginBtn = findViewById(R.id.loginBtn);
        username = findViewById(R.id.usernameEt);
        password = findViewById(R.id.passwordEt);
    }
}
