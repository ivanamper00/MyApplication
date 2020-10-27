package com.ivandeveloper.application2.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;

import com.ivandeveloper.application2.Controller.Connection;
import com.ivandeveloper.application2.Controller.MinorController;
import com.ivandeveloper.application2.R;

public class SplashScreen extends AppCompatActivity {
    CountDownTimer countTimer;
    MinorController intentController;
    Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        connection = new Connection();
        intentController = new MinorController();


        countTimer = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                if(connection.isConnected(SplashScreen.this)){
                    intentController.NextIntent(SplashScreen.this,Listings.class);
                    finish();
                }
            }
        }.start();

    }
}