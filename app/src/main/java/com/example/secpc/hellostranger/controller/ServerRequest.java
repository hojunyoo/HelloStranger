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
import com.example.secpc.hellostranger.data.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sejini on 2016-11-07.
 */

public class ServerRequest extends Application{

    //기본 url 주소
    public static String SeverUrl ="https://hello-stranger-dobeeisfree.c9users.io/v1";


    public static Object sendUserRequest(Context context, String url, int a){
        RequestQueue queue = Volley.newRequestQueue(context);
        final User user = null;
        final int type = a;

        JsonObjectRequest jsonObjectRequest2;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                            try {
                                //정보를 담을 곳에 담아 보내준다.
                               user.setUserId(response.getString("id"));
                                String name = response.getString("name");
                                Log.e("name : ", name);
                                String password = response.getString("password");
                                Log.e("pass : ", password);
                                String language = response.getString("lang");
                                Log.e("lang : ", String.valueOf(language));

                                String stTaboo = response.getString("for_taboo");
                                int taboo = 0;
                                try
                                {
                                    if(stTaboo != null)
                                        taboo = Integer.parseInt(stTaboo);
                                }
                                catch (NumberFormatException e)
                                {
                                    taboo = -1;
                                }

                                Log.e("taboo : ", String.valueOf(taboo));


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
        return null;
    }



    }

