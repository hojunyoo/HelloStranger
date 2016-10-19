package com.example.secpc.hellostranger.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.secpc.hellostranger.R;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        /*
        * 2016.10.20
        * by dobeeisfsree
        * gif file with glide image loading
        */
        ImageView splashView = (ImageView) findViewById(R.id.fullscreen_content_controls);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(splashView);
        if(splashView != null)
            Glide.with(this).load(R.drawable.splash_hello_stranger).crossFade().into(imageViewTarget);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashActivity.this, LogInActivity.class));
                finish();
         //       overridePendingTransition(R.anim.intro_in, R.anim.intro_out);

            }
        }, secondsDelayed * 1500);


    }
}

