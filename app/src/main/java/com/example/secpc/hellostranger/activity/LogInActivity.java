package com.example.secpc.hellostranger.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;

import com.example.secpc.hellostranger.R;

public class LogInActivity extends AppCompatActivity {

    boolean btState = false;    //login 버튼이 눌렸는지 상태 저장 변수
    Button join, login;
    EditText etID, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etID = (EditText)findViewById(R.id.LoginActivity_editText_id);
        etPassword = (EditText)findViewById(R.id.LoginActivity_editText_password);
        join = (Button)findViewById(R.id.LoginActivity_button_join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogInActivity.this, JoinActivity.class));
            }
        });
        login = (Button)findViewById(R.id.LoginActivity_button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btState = true;
                buttonEffect();
            }
        });
        AutoLogin();
    }

    private void buttonEffect() {
        join.setText("로그인");
        login.startAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        login.setVisibility(View.GONE);
        new Handler().postDelayed(new Runnable() {
            public void run() {
                etID.startAnimation(AnimationUtils.loadAnimation(getBaseContext(), android.R.anim.fade_in));
                etID.setVisibility(View.VISIBLE);
                etPassword.setAnimation(AnimationUtils.loadAnimation(getBaseContext(), android.R.anim.fade_in));
                etPassword.setVisibility(View.VISIBLE);
            }
        }, 700);

    }

    //후에 자동로그인 기능
    protected void AutoLogin(){

    }
}
