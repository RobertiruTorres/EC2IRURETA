package com.example.ec2irureta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class LoginActivity extends AppCompatActivity {
    private EditText email;
    private Boolean email_status = false;
    private EditText password;
    private Boolean password_status = false;
    private Button login_btn;

    //Regex
    private Pattern regexEmail = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}\\.[a-zA-Z]{2,}$");
    private Pattern regexPassword = Pattern.compile("^(?=.*[a-zA-Z])(?=.*[0-9]).{8,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login_btn = findViewById(R.id.login_btn);

        email.addTextChangedListener(handlerEmail());
        password.addTextChangedListener(handlerPassword());

        login_btn.setOnClickListener(handlerBtnLogin());
    }

    private TextWatcher handlerEmail(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(regexEmail.matcher(s).matches()){
                    email_status = true;
                }else{
                    email_status = false;
                }

                if(email_status && password_status){
                    login_btn.setEnabled(true);
                }else{
                    login_btn.setEnabled(false);
                }

            }
        };
    }

    private TextWatcher handlerPassword(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(regexPassword.matcher(s).matches()){
                    password_status = true;
                }else{
                    password_status = false;
                }

                if(email_status && password_status){
                    login_btn.setEnabled(true);
                }else{
                    login_btn.setEnabled(false);
                }
            }
        };
    }

    private View.OnClickListener handlerBtnLogin(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MMainActivity.class);
                startActivity(intent);
            }
        };
    }
}