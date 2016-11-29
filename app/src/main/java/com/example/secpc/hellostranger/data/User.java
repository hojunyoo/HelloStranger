package com.example.secpc.hellostranger.data;

/**
 * Created by secpc on 2016-09-05.
 */
public class User {
    private String userId;
    private String name;
    private String password;
    private int language;
    private Store[] keep;
    private int taboo;

    public User(){}
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLanguage() {
        return language;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public Store[] getKeep() {
        return keep;
    }

    public void setKeep(Store[] keep) {
        this.keep = keep;
    }

    public int getTaboo() {
        return taboo;
    }

    public void setTaboo(int taboo) {
        this.taboo = taboo;
    }

    public User(String userId, String name, String password, int language, Store[] keep, int taboo) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.language = language;
        this.keep = keep;
        this.taboo = taboo;
    }
}
