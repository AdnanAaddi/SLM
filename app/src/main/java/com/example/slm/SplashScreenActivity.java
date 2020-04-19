package com.example.slm;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.database.collection.LLRBNode;

import gr.net.maroulis.library.EasySplashScreen;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        EasySplashScreen config = new EasySplashScreen(SplashScreenActivity.this).withFullScreen()
                .withTargetActivity(login.class).withSplashTimeOut(2000).withBackgroundColor(Color.WHITE)
                .withHeaderText("").withLogo(R.drawable.home);
        config.getHeaderTextView().setTextColor(Color.WHITE);
        View easySplashScreen = config.create();
        setContentView(easySplashScreen);
    }
}
