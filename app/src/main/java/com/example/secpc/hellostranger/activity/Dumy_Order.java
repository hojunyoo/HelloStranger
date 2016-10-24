package com.example.secpc.hellostranger.activity;

/**
 * Created by jubee on 16. 10. 25.
 */
public class Dumy_Order {
    int menu_picture;
    String menu_name;
    String menu_qauntity;
    String menu_price;

    int getMenu_picture() {
        return this.menu_picture;
    }
    String getMenu_name() {
        return this.menu_name;
    }
    String getMenu_qauntity() {
        return this.menu_qauntity;
    }
    String getMenu_price() {
        return this.menu_price;
    }

    Dumy_Order(int menu_picture, String menu_name, String menu_qauntity, String menu_price) {
        this.menu_picture = menu_picture;
        this.menu_name = menu_name;
        this.menu_price = menu_price;
        this.menu_qauntity = menu_qauntity;
    }
}
