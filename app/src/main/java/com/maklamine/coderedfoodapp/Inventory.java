package com.maklamine.coderedfoodapp;

/**
 * Created by davidcruz on 10/29/16.
 */

public class Inventory {

    Inventory(String title, int quantity, String units){
        this.title = title;
        this.quantity = quantity;
        this.units = units;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnits() {
        return units;
    }

    public void setUnits(String units) {
        this.units = units;
    }

    private String title;
    private int quantity;
    private String units;
}
