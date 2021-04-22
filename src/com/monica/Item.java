package com.monica;

public class Item {
    public String name;
    public double price;
    public int numOfProductAvailable;

    /*Items (and others, maybe) should be built using a constructor, not hard coded*/
    public Item(String name, double price){
        this.name = name;
        this.price = price;
    }
}
