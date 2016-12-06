package com.example.secpc.hellostranger.data;

import android.graphics.Bitmap;

/**
 * Created by secpc on 2016-09-05.
 */
public class Store {
    private String storeId;
    private String name;
    private String location;
    private Bitmap storeImage;
    private int category;
    private String openTime;
    private String closeTime;
    //storeid와 일치하는 menu의 테이블을 받아와서 menu 객체 생성후 store 객체에 바로 저장
    private Menu[] menus;

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Bitmap getStoreImage() {
        return storeImage;
    }

    public void setStoreImage(Bitmap storeImage) {
        this.storeImage = storeImage;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(String closeTime) {
        this.closeTime = closeTime;
    }

    public Menu[] getMenus() {
        return menus;
    }

    public void setMenus(Menu[] menus) {
        this.menus = menus;
    }
    public Store(){}

    public Store(String storeId, String name, String location, Bitmap storeImage, int category, String openTime, String closeTime, Menu[] menus) {
        this.storeId = storeId;
        this.name = name;
        this.location = location;
        this.storeImage = storeImage;
        this.category = category;
        this.openTime = openTime;
        this.closeTime = closeTime;
        this.menus = menus;
    }
}
