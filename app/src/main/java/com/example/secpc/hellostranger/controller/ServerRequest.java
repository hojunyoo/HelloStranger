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
import com.example.secpc.hellostranger.activity.MyApplication;
import com.example.secpc.hellostranger.data.Store;
import com.example.secpc.hellostranger.data.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by sejini on 2016-11-07.
 */

public class ServerRequest extends Application{
     public static User instanceuser = null;
    Store store;

    //기본 url 주소
    public static String SeverUrl ="https://hello-stranger-dobeeisfree.c9users.io/v1/";
    //넘겨줄 때 user/new? 그리고 그 뒤 값들 붙여줘야함.

    public static String joinURL(String name, String value){
        return "foreigners["+name+"]="+value;
    }


    public static void sendUserRequest(Context context, String url){
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                           try {
                                //정보를 담을 곳에 담아 보내준다.
//                               user.setUserId(response.getString("id"));
//                                String name = response.getString("name");
//                                Log.e("name : ", user.getName());
//                                user.setPassword(response.getString("password"));
//                                Log.e("pass : ", user.getPassword());
//                                String language = response.getString("lang");
//                                user.setLanguage(Integer.parseInt(response.getString("lang")));
//                                Log.e("lang : ", String.valueOf(user.getLanguage()));
//                               user.setTaboo(Integer.parseInt(response.getString("for_taboo")));
//                                Log.e("taboo : ", String.valueOf(response.getString("for_taboo")));

                               User user = new User(response.getString("id"), response.getString("name"), response.getString("password"), Integer.parseInt(response.getString("lang"))
                               , null, Integer.parseInt(response.getString("for_taboo")));
                               instanceuser = user;
                               Log.d("user_id : ", instanceuser.getUserId());
                               Log.d("user_name : ", instanceuser.getName());
                               Log.d("user_password : ", instanceuser.getPassword());
                               Log.d("user_language : ", String.valueOf(instanceuser.getLanguage()));
                               Log.d("user_fortaboo : ", String.valueOf(instanceuser.getTaboo()));

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

    public static void sendStoreRequest(Context context, String url){
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        User user = null;
                        try {
                            //정보를 담을 곳에 담아 보내준다.
                            user.setUserId(response.getString("id"));
                            String name = response.getString("name");
                            Log.e("name : ", user.getName());
                            user.setPassword(response.getString("password"));
                            Log.e("pass : ", user.getPassword());
                            String language = response.getString("lang");
                            user.setLanguage(Integer.parseInt(response.getString("lang")));
                            Log.e("lang : ", String.valueOf(user.getLanguage()));
                            user.setTaboo(Integer.parseInt(response.getString("for_taboo")));
                            Log.e("taboo : ", String.valueOf(response.getString("for_taboo")));

                            ServerRequest.instanceuser = user;
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

