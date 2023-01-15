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

public class signupActivity extends AppCompatActivity {
    Button sign;
    EditText name,mail,pass;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        sign=(Button) findViewById(R.id.signbtn);
        name=(EditText) findViewById(R.id.editTextTextPersonName);
        mail=(EditText) findViewById(R.id.editTextTextPersonEmail);
        pass=(EditText) findViewById(R.id.editTextTextPassword);

        firebaseAuth= FirebaseAuth.getInstance();

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }

    private void signup() {
        String username =name.getText().toString();
        String usermail =mail.getText().toString();
        String userpass =pass.getText().toString();
        if(username.isEmpty()){
            Tools.Message("name kısmı boş olamaz");
        }
        if(usermail.isEmpty()){
            Tools.Message("mail kısmı boş olamaz");
        }
        if(userpass.isEmpty()||userpass.length()<6){
            Tools.Message("password kısmı boş veya 6 haneden düşük olamaz");
        }
        firebaseAuth.createUserWithEmailAndPassword(usermail,userpass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Tools.Message("Kayıt Başarılı");
                    startActivity(new Intent(signupActivity.this,SplashActivity.class));
                }
                else{
                    Tools.Message("Kayıt Başarısız");
                }
            }
        });

    }

    public void loginClick(View view) {
        startActivity(new Intent(signupActivity.this,loginActivity.class));
    }
}