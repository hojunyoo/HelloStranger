package com.example.secpc.hellostranger.controller;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.secpc.hellostranger.R;
import com.example.secpc.hellostranger.activity.Main2Activity;
import com.example.secpc.hellostranger.data.Menu;
import com.example.secpc.hellostranger.data.Store;
import com.example.secpc.hellostranger.data.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ServerRequest extends Application{
    //파싱 값을 저장 및 전달할 instance
     public static User instanceUser = null;
     //퀵 메뉴 조회 시 얻어오는 store_id를 배열로 저장해서 넘겨줌.
    public static Store instanceStore;
    public static Menu[] instanceMenu = new Menu[20];

    //이미지 로딩
    public static Bitmap image;
     //파싱 시 array 제어 변수
    static Context publiccontext;

    //기본 url 주소
    public static String SeverUrl ="https://hello-stranger-dobeeisfree.c9users.io/v1/";
    //넘겨줄 때 user/new? 그리고 그 뒤 값들 붙여줘야함.

    //회원가입 시 서버에 날려줄 url 형식을 맞추는 함수 여러 user name, value들을 "&"로 붙여 보내주면된다.
    public static String joinURL(String name, String value){
        return "foreigners["+name+"]="+value;
    }


    //회원가입, 로그인 시 json parsing함수
    public static void sendUserRequest(Context context, String url){
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                           try {
                               //getString()으로 받아올 json 데이터의 name을 넣어주고 그에 맞는 값들을 바로 user 객체 생성자에 넣어 생성해 준다.
                               // 생성 후에 ServerRequest의 instanceuser에 담아 함수를 호출한 후 값을 전달받는다.

                               User user = new User(response.getString("id"), response.getString("name"), response.getString("password"), Integer.parseInt(response.getString("lang"))
                               , null, Integer.parseInt(response.getString("for_taboo")));
                               DataInstance.setUser(user);

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
    //menu_id 값, 언어에 따라 메뉴 정보 넘겨줌
    public static void sendMenuTransferRequest(Context context, String url, final int MenuIndex){
        RequestQueue queue = Volley.newRequestQueue(context);

        Log.d("뭐지url?", url);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //menu_id와 언어 태그에 맞는 menu 정보를 받아와 instance에 저장한다.
                            Log.d("menuindex:", String.valueOf(MenuIndex));
                            instanceMenu[MenuIndex].setName(response.getString("foodname"));
                            Log.d("menuindex:", String.valueOf(instanceMenu[MenuIndex].getName()));
                            instanceMenu[MenuIndex].setFoodGlossary1(response.getString("foodstuff_1"));
                            instanceMenu[MenuIndex].setFoodGlossary2(response.getString("foodstuff_2"));
                            instanceMenu[MenuIndex].setTaste(response.getString("taste"));
                            instanceMenu[MenuIndex].setCookingmethod(response.getString("cookingmethod"));

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
    //store_id 값에 따라 가게 정보 넘겨줌
    public static void sendStoreRequest(Context context, String url){
        RequestQueue queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            //menu_id와 언어 태그에 맞는 menu 정보를 받아와 instance에 저장한다.
                            instanceStore.setName(response.getString("name"));
                            Log.d("가게이름 : ", response.getString("name"));
                            instanceStore.setLocation(response.getString("location"));
                            instanceStore.setCategory(Integer.parseInt(response.getString("category")));
                            String imageurl = response.getJSONObject("main_picture").getString("url");
                            if(imageurl.equals(null)){
                                instanceStore.setStoreImage(null);
                            }
                            else {
                                ImageRequest request = new ImageRequest(imageurl,
                                        new Response.Listener<Bitmap>() {
                                            @Override
                                            public void onResponse(Bitmap bitmap) {
                                                instanceStore.setStoreImage(bitmap);
                                            }
                                        }, 0, 0, null,
                                        new Response.ErrorListener() {
                                            public void onErrorResponse(VolleyError error) {
                                                instanceStore.setStoreImage(null);
                                            }
                                        });
                                // Access the RequestQueue through your singleton class.
                                //     Singleton.getInstance(publiccontext).addToRequestQueue(request);
                            }


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
    //quick-menu 정보를 받아온다
    public static void sendQuickMenuRequest(Context context, String url){
        RequestQueue queue = Volley.newRequestQueue(context);
        publiccontext = context;
        instanceStore = new Store();

        Log.d("들어왓니?", "응");
         JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        String url = ServerRequest.SeverUrl;
                        int MenuIndex;
                     try
                        {
                            instanceStore.setStoreId(response.getString("store_id"));
                           Log.d("여기는? : ", instanceStore.getStoreId());
                            url += "streets/get_here_store?store_id="+instanceStore.getStoreId();
                            sendStoreRequest(publiccontext, url);

                           JSONArray datas = response.getJSONArray("menu");
                            int size = datas.length();
                            Log.i("size", String.valueOf(size));

                            for(int i=0; i<size; i++)
                            {

                                MenuIndex = i;
                                instanceMenu[MenuIndex] = new Menu();
                                instanceMenu[MenuIndex].setMenuId(datas.getJSONObject(i).getString("id"));
                                Log.d("메뉴 : ", instanceMenu[i].getMenuId());
                                instanceMenu[MenuIndex].setPrice(Integer.parseInt(datas.getJSONObject(i).getString("price")));
                                Log.d("가격!!!! : ", String.valueOf(instanceMenu[MenuIndex].getPrice()));

                                String imageURL = datas.getJSONObject(i).getJSONObject("picture").getString("url");
                                Log.d("이미지 : ", imageURL);
                                instanceMenu[MenuIndex].setIsQuickMenu(Boolean.parseBoolean(datas.getJSONObject(i).getString("quick_menu")));
                                url = ServerRequest.SeverUrl;
                                url += "transfer/menu_pan?menu_id="+instanceMenu[MenuIndex].getMenuId() +
                                        "&lang_id="+1;
                                sendMenuTransferRequest(publiccontext, url, MenuIndex);

                                if(imageURL.equals(null)){
                                    instanceMenu[MenuIndex].setMenuImage(null);
                                }
                                else{
                                    final int finalMenuIndex = MenuIndex;
                                    ImageRequest request = new ImageRequest(imageURL,
                                            new Response.Listener<Bitmap>() {
                                                @Override
                                                public void onResponse(Bitmap bitmap) {
                                                    instanceMenu[finalMenuIndex].setMenuImage(bitmap);
                                                }
                                            }, 0, 0, null,
                                            new Response.ErrorListener() {
                                                public void onErrorResponse(VolleyError error) {
                                                    instanceMenu[finalMenuIndex].setMenuImage(null);
                                                }
                                            });
                                    // Access the RequestQueue through your singleton class.
                               //     Singleton.getInstance(publiccontext).addToRequestQueue(request);
                                }

                            }
                            instanceStore.setMenus(instanceMenu);
                            DataInstance.store.add(instanceStore);
                            Log.d("가게이름 : ", ((Store)DataInstance.store.get(DataInstance.storeIndex)).getName());
                            DataInstance.storeIndex=(DataInstance.storeIndex+1)%10;
                        }
                        catch (Exception e)
                        {
                            e.getMessage();
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

    //ImageRequest 이미지 url 파싱


}

