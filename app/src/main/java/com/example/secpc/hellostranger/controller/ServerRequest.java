package com.example.secpc.hellostranger.controller;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sejini on 2016-11-07.
 */

public class ServerRequest extends Application{

    public static void sendRequest(Context context){
        RequestQueue queue = Volley.newRequestQueue(context);
        String url ="https://hello-stranger-dobeeisfree.c9users.io/v1/users/new?foreigners[name]=sejin";

        /*
        onResponse 함수의 인자값인 response에 저장된다.

    저장된 데이터를 파싱하는 일만 남는데, 파싱은 getString, getInt,등등의 함수들을 호출해 파싱하면된다. 아래와 같이.

    String id = response.getString("name");

    String recordDate = response.getString("email");

    JSONObject distance = response.getJSONObject("phone");

    이제 파싱 된 데이터들을 그냥 사용하거나 해당 데이터들을 묶어주는 객체로 생성해 사용하면 된다.

        * */
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            String id = response.getString("id");
                            Log.e("id : ", id);
                            String name = response.getString("name");
                            Log.e("name : ", name);
                            JSONObject distance = response.getJSONObject("phone");
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        // queue에 Request를 추가해준다.
        queue.add(jsonObjectRequest);
    }


}
