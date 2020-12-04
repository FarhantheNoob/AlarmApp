package com.example.alarmapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 2500;
    private TextView appName, teamName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        appName = findViewById(R.id.AppName);
        teamName = findViewById(R.id.teamName);

        Animation animation_down = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_bottom);
        appName.setAnimation(animation_down);

        Animation animation_up = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_up);
        teamName.setAnimation(animation_up);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this, MainActivity.class));
                finish();
            }
        }, SPLASH_TIME_OUT);
    }
}