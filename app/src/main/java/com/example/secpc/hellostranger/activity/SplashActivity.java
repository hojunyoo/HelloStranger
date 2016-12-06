package com.example.secpc.hellostranger.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.example.secpc.hellostranger.R;
import com.example.secpc.hellostranger.controller.ServerRequest;

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
        ServerRequest.sendQuickMenuRequest(getApplicationContext(), ServerRequest.SeverUrl+"streets/manu_pan?beacon_id=uzqxdbpwheomjatgklrs170350");
        ServerRequest.sendQuickMenuRequest(getApplicationContext(), ServerRequest.SeverUrl+"streets/manu_pan?beacon_id=kfdrpwbmjnutahzisloc197033");
        ServerRequest.sendQuickMenuRequest(getApplicationContext(), ServerRequest.SeverUrl+"streets/manu_pan?beacon_id=pbftlzeusymqhwgxjnak204675");
        ServerRequest.sendQuickMenuRequest(getApplicationContext(), ServerRequest.SeverUrl+"streets/manu_pan?beacon_id=oesglxniztvbmycjfqrp212125");
        ServerRequest.sendQuickMenuRequest(getApplicationContext(), ServerRequest.SeverUrl+"streets/manu_pan?beacon_id=bcygkxdwazsfilujvopm239331");
        ServerRequest.sendQuickMenuRequest(getApplicationContext(), ServerRequest.SeverUrl+"streets/manu_pan?beacon_id=buzheilkwcxrvdgspatn252154");
        ServerRequest.sendQuickMenuRequest(getApplicationContext(), ServerRequest.SeverUrl+"streets/manu_pan?beacon_id=uozvygwbpcmkrnjdxitl258705");

        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(splashView);
        if(splashView != null)
            Glide.with(this).load(R.drawable.splash_hello_stranger0).crossFade().into(imageViewTarget);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
//                startActivity(new Intent(SplashActivity.this, LogInActivity.class));
//                finish();
//                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

                Intent goMain = new Intent(SplashActivity.this, LogInActivity.class);
                startActivity(goMain);
                finish();
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

            }
        }, secondsDelayed * 1500);


    }
}

