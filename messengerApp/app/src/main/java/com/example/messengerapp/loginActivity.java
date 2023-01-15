package com.example.messengerapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginActivity extends AppCompatActivity {
    Button login;
    EditText mail,pass;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login=(Button) findViewById(R.id.loginbtn);
        mail=(EditText) findViewById(R.id.editTextTextPersonEmail);
        pass=(EditText) findViewById(R.id.editTextTextPassword);

        firebaseAuth= FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginclick();
            }
        });


    }

    private void loginclick() {
        String usermail =mail.getText().toString();
        String userpass =pass.getText().toString();
        if(usermail.isEmpty()){
            Tools.Message("mail kısmı boş olamaz");
        }
        if(userpass.isEmpty()||userpass.length()<6){
            Tools.Message("password kısmı boş veya 6 haneden düşük olamaz");
        }
        firebaseAuth.signInWithEmailAndPassword(usermail,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(loginActivity.this,MainActivity.class));
                }
                else
                {
                    Tools.Message("Başarısız giriş denemesi");
                }
            }
        });
    }

    public void signClick(View view) {
        startActivity(new Intent(loginActivity.this,signupActivity.class));
    }
}