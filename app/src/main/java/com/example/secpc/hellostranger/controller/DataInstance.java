package com.example.secpc.hellostranger.controller;

import com.example.secpc.hellostranger.data.User;

/**
 * Created by sejini on 2016-12-06.
 */

public class DataInstance {
    private static User user;

    public static User getUser() {
        return user;
    }

    public static void setUser(User user2) {
        user = user2;
    }
}
