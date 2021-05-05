package com.promo.engine;

public class SKU {
    private String id;
    private double price;
    //Not considering the item stock. assuming enough stock is available


    public SKU(String id, double price) {
        this.id = id;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}
