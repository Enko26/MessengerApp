package com.example.messengerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class SplashActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    Thread sure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Tools.context=getApplicationContext();
        firebaseAuth=FirebaseAuth.getInstance();
        Splashthread();

        if(firebaseAuth.getCurrentUser()!=null){
            Tools.Message("Giriş tanımlandı.Yönlendiriliyorsunuz.");
            sure.start();
        }
        else
        {
            Tools.Message("Giriş yapın veya kayıt olun.");
        }
    }
    public void Splashthread(){
        sure = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    public void loginClick(View view) {
        startActivity(new Intent(SplashActivity.this,loginActivity.class));
    }

    public void signClick(View view) {
        startActivity(new Intent(SplashActivity.this,signupActivity.class));
    }
}