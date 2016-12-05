package com.example.secpc.hellostranger.data;

import java.util.HashMap;

/**
 * Created by secpc on 2016-09-05.
 */
public class Menu {
    private String menuId;
    private String name;
    private int price;
    private boolean isQuickMenu;
    //재료, 맛, 조리법 hashmap으로 저장해서 언어별로 저장. db에서 얻어올 때 id값으로 한꺼번에 받아와서 저장.
    private String foodGlossary1;
    private String foodGlossary2;
    private String taste;
    private String cookingmethod;


    public Menu(){}
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getIsQuickMenu() {
        return isQuickMenu;
    }

    public void setIsQuickMenu(boolean isQuickMenu) {
        this.isQuickMenu = isQuickMenu;
    }



    public Menu(String menuId, String name, int price, boolean isQuickMenu,String foodGlossary1, String foodGlossary2, String taste , String cookingmethod) {
        this.menuId = menuId;//
        this.name = name;//
        this.price = price;//
        this.isQuickMenu = isQuickMenu;//
        this.foodGlossary1 = foodGlossary1;//
        this.foodGlossary2 = foodGlossary2;//
        this.taste = taste;//
        this.cookingmethod = cookingmethod;//
    }

    public String getCookingmethod() {
        return cookingmethod;
    }

    public void setCookingmethod(String cookingmethod) {
        this.cookingmethod = cookingmethod;
    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getFoodGlossary2() {
        return foodGlossary2;
    }

    public void setFoodGlossary2(String foodGlossary2) {
        this.foodGlossary2 = foodGlossary2;
    }

    public String getFoodGlossary1() {
        return foodGlossary1;
    }

    public void setFoodGlossary1(String foodGlossary1) {
        this.foodGlossary1 = foodGlossary1;
    }
}
