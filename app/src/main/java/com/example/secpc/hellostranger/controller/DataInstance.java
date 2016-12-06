package com.example.secpc.hellostranger.controller;

import com.example.secpc.hellostranger.data.Store;
import com.example.secpc.hellostranger.data.User;

import java.util.ArrayList;

/**
 * Created by sejini on 2016-12-06.
 */

public class DataInstance {
    private static User user;
    // ArrayList 생성
    public static ArrayList store = new ArrayList<Store>();
    public static int storeIndex=0;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user2) {
        user = user2;
    }
}
