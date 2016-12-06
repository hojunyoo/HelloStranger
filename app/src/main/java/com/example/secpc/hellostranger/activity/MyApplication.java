package com.example.secpc.hellostranger.activity;

import android.app.Application;
import android.support.design.widget.FloatingActionButton;

import com.example.secpc.hellostranger.data.User;

/**
 * Created by secpc on 2016-10-16.
 */
public class MyApplication extends Application {
    private FloatingActionButton floating_back;
    private FloatingActionButton floating_select;
    private FloatingActionButton floating_keep;

    private User user;


    public FloatingActionButton getFloating_select() {
        return floating_select;
    }

    public void setFloating_select(FloatingActionButton floating_select) {
        this.floating_select = floating_select;
    }

    public FloatingActionButton getFloating_keep() {
        return floating_keep;
    }

    public void setFloating_keep(FloatingActionButton floating_keep) {
        this.floating_keep = floating_keep;
    }

    public FloatingActionButton getFloating_back() {
        return floating_back;
    }

    public void setFloating_back(FloatingActionButton floating_back) {
        this.floating_back = floating_back;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
