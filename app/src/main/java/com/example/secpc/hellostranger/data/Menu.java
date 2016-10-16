package com.example.secpc.hellostranger.data;

import java.util.HashMap;

/**
 * Created by secpc on 2016-09-05.
 */
public class Menu {
    private String menuId;
    private String name;
    private int price;
    private int isQuickMenu;
    //재료, 맛, 조리법 hashmap으로 저장해서 언어별로 저장. db에서 얻어올 때 id값으로 한꺼번에 받아와서 저장.
    // key값으로 0 : 한국어 1: 영어 2: 일본어 3: 중국어
    private HashMap<Integer, String> foodGlossary1;
    private HashMap<Integer, String> foodGlossary2;
    private HashMap<Integer, String> taste;
    private HashMap<Integer, String> cookingmethod;

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

    public int getIsQuickMenu() {
        return isQuickMenu;
    }

    public void setIsQuickMenu(int isQuickMenu) {
        this.isQuickMenu = isQuickMenu;
    }

    public HashMap<Integer, String> getFoodGlossary1() {
        return foodGlossary1;
    }

    public void setFoodGlossary1(HashMap<Integer, String> foodGlossary1) {
        this.foodGlossary1 = foodGlossary1;
    }

    public HashMap<Integer, String> getFoodGlossary2() {
        return foodGlossary2;
    }

    public void setFoodGlossary2(HashMap<Integer, String> foodGlossary2) {
        this.foodGlossary2 = foodGlossary2;
    }

    public HashMap<Integer, String> getTaste() {
        return taste;
    }

    public void setTaste(HashMap<Integer, String> taste) {
        this.taste = taste;
    }

    public HashMap<Integer, String> getCookingmethod() {
        return cookingmethod;
    }

    public void setCookingmethod(HashMap<Integer, String> cookingmethod) {
        this.cookingmethod = cookingmethod;
    }

    public Menu(String menuId, String name, int price, int isQuickMenu, HashMap<Integer, String> foodGlossary1, HashMap<Integer, String> foodGlossary2, HashMap<Integer, String> taste, HashMap<Integer, String> cookingmethod) {
        this.menuId = menuId;
        this.name = name;
        this.price = price;
        this.isQuickMenu = isQuickMenu;
        this.foodGlossary1 = foodGlossary1;
        this.foodGlossary2 = foodGlossary2;
        this.taste = taste;
        this.cookingmethod = cookingmethod;
    }
}
