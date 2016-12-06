package com.example.secpc.hellostranger.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.provider.ContactsContract;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.secpc.hellostranger.R;
import com.example.secpc.hellostranger.controller.DataInstance;
import com.example.secpc.hellostranger.controller.ServerRequest;
import com.example.secpc.hellostranger.data.User;

public class SettingTabooActivity extends Activity {
    int Taboo=-1;
    String id;
    String password;
    String language;
    String pageType="0";
    ImageButton[] taboo = new ImageButton[7];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_taboo);
        Intent intent = getIntent();
        pageType = intent.getExtras().getString("page");
        if(pageType.equals(JoinActivity.JOINPAGE)){
            id = intent.getExtras().getString("id");
            password = intent.getExtras().getString("password");
            language = intent.getExtras().getString("language");

        }



        taboo[0] = (ImageButton)findViewById(R.id.TabooActivity_ImageButton_pollo);
        taboo[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Taboo = User.TABOO_POLLO;
                checkedButton(taboo[0]);
            }
        });
        taboo[1] = (ImageButton)findViewById(R.id.TabooActivity_ImageButton_pesco);
        taboo[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Taboo = User.TABOO_PESCO;
                checkedButton(taboo[1]);
            }
        });
        taboo[2] = (ImageButton)findViewById(R.id.TabooActivity_ImageButton_lacto);
        taboo[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Taboo = User.TABOO_LACTO; checkedButton(taboo[2]);
            }
        });
        taboo[3] = (ImageButton)findViewById(R.id.TabooActivity_ImageButton_ovo);
        taboo[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Taboo = User.TABOO_OVO; checkedButton(taboo[3]);
            }
        });
        taboo[4] = (ImageButton)findViewById(R.id.TabooActivity_ImageButton_lactovo);
        taboo[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Taboo = User.TABOO_LACTOVO;
                checkedButton(taboo[4]);
            }
        });
        taboo[5] = (ImageButton)findViewById(R.id.TabooActivity_ImageButton_hinduism);
        taboo[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Taboo = User.TABOO_HINDUISM;
                checkedButton(taboo[5]);
            }
        });
        taboo[6] = (ImageButton)findViewById(R.id.TabooActivity_ImageButton_muslim);
        taboo[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Taboo = User.TABOO_MUSLIM;
                checkedButton(taboo[6]);
            }
        });
        ImageButton button_skip = (ImageButton)findViewById(R.id.TabooActivity_ImageButton_skip);
        button_skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Taboo = User.TABOO_NOME;
                createUser();
                Intent goMain = new Intent(SettingTabooActivity.this, MainActivity.class);
                startActivity(goMain);
                finish();
            }
        });
        ImageButton button_select = (ImageButton)findViewById(R.id.TabooActivity_ImageButton_selet);
        button_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Taboo==-1){
                    Toast.makeText(getApplicationContext(), "타부를 선택하여 주십시오.", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(pageType.equals(JoinActivity.JOINPAGE)){
                        createUser();
                    }
                    else{
                        //타부만 update;
                    }
                    Intent goMain = new Intent(SettingTabooActivity.this, MainActivity.class);
                    startActivity(goMain);
                    finish();
                }
            }
        });
    }

    private void checkedButton(ImageButton imageButton) {
        for(int i=0;i<7;i++){
            taboo[i].setImageResource(R.drawable.quick_nothing_icon);
        }
        imageButton.setImageResource(R.drawable.taboo_select_icon);
    }

    private void createUser(){
        String url = ServerRequest.SeverUrl;

        Log.d("id ", id);
        Log.d("password ", password);
        Log.d("language ", language);
        Log.d("taboo ", String.valueOf(Taboo));

        url += "users/new?"+ServerRequest.joinURL("name", id)+"&"+ServerRequest.joinURL("password", password)+"&"
                + ServerRequest.joinURL("lang", language)+"&" + ServerRequest.joinURL("for_taboo", String.valueOf(Taboo));
        ServerRequest.sendUserRequest(getApplicationContext(), url);
        //회원가입한 사용자 등록\
        //후에 자동로그인 sharedpreference적용 예정
    }
}
