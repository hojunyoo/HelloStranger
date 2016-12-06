package com.example.secpc.hellostranger.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.secpc.hellostranger.R;
import com.example.secpc.hellostranger.controller.DataInstance;
import com.example.secpc.hellostranger.controller.ServerRequest;
import com.example.secpc.hellostranger.data.User;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONException;
import org.json.JSONObject;

public class LogInActivity extends AppCompatActivity {

    boolean btState = false;    //login 버튼이 눌렸는지 상태 저장 변수
    Button join, login;
    EditText etID, etPassword;


    ////////////////////////
    // This string will hold the results
   // Defining the Volley request queue that handles the URL request concurrently
     /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        etID = (EditText) findViewById(R.id.LoginActivity_editText_id);
        etPassword = (EditText) findViewById(R.id.LoginActivity_editText_password);
        join = (Button) findViewById(R.id.LoginActivity_button_join);
        join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btState){
                    LoginAction();
                    if(DataInstance.getUser() == null){
                        Toast.makeText(getApplicationContext(), "아이디와 비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        startActivity(new Intent(LogInActivity.this, MainActivity.class));
                        Log.d("user_id : ", DataInstance.getUser().getUserId());
                        Log.d("user_name : ", DataInstance.getUser().getName());
                        Log.d("user_password : ", DataInstance.getUser().getPassword());
                        Log.d("user_language : ", String.valueOf(DataInstance.getUser().getLanguage()));
                        Log.d("user_fortaboo : ", String.valueOf(DataInstance.getUser().getLanguage()));
                    }
                }
                else{
                    startActivity(new Intent(LogInActivity.this, JoinActivity.class));
                }
            }
        });
        login = (Button) findViewById(R.id.LoginActivity_button_login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btState = true;
                buttonEffect();
            }
        });
        AutoLogin();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void LoginAction() {

//        Log.d("id ", id);
//        Log.d("password ", password);
//        Log.d("language ", language);
//        Log.d("taboo ", String.valueOf(Taboo));
        String url = ServerRequest.SeverUrl;
        url += "users/login?name="+ etID.getText().toString()+"&password="+etPassword.getText().toString();   ServerRequest.sendUserRequest(getApplicationContext(), url);

    }

    private void buttonEffect() {
        join.setText("Log in");
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
    protected void AutoLogin() {

    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("LogIn Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
