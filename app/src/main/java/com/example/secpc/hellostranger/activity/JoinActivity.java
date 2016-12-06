package com.example.secpc.hellostranger.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.secpc.hellostranger.R;
import com.example.secpc.hellostranger.data.User;

public class JoinActivity extends AppCompatActivity {
    int languageData=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        ImageButton next = (ImageButton)findViewById(R.id.JoinActivity_Button_join);
        final EditText editText_id = (EditText)findViewById(R.id.JoinActivity_EditText_id);
        final EditText editText_password = (EditText)findViewById(R.id.JoinActivity_EditText_password);

        ImageButton[] buttons_languages = new ImageButton[4];
        buttons_languages[0]=(ImageButton) findViewById(R.id.JoinActivity_button_language_kor);
        buttons_languages[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageData = User.LANGUAGES_KOR;
            }
        });
        buttons_languages[1]=(ImageButton)findViewById(R.id.JoinActivity_button_language_eng);
        buttons_languages[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageData = User.LANGUAGES_ENG;
            }
        });
        buttons_languages[2]=(ImageButton)findViewById(R.id.JoinActivity_button_language_chin);
        buttons_languages[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageData = User.LANGUAGES_CHIN;
            }
        });
        buttons_languages[3]=(ImageButton)findViewById(R.id.JoinActivity_button_language_jan);
        buttons_languages[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                languageData = User.LANGUAGES_JAN;
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(languageData==-1){
                    Toast.makeText(getApplicationContext(), "Please check your language", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent goTaboo = new Intent(JoinActivity.this, SettingTabooActivity.class);
                    goTaboo.putExtra("id", editText_id.getText().toString());
                    Log.d("id ", editText_id.getText().toString());
                    goTaboo.putExtra("password", editText_password.getText().toString());
                    Log.d("password ", editText_password.getText().toString());
                    goTaboo.putExtra("language", String.valueOf(languageData));
                    Log.d("language ", String.valueOf(languageData));
                    startActivity(goTaboo);
                    finish();
                }

            }
        });
    }
}
