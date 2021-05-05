package com.promo.engine;

public class CartItem {
    private SKU item;
    private int qty;

    public CartItem(SKU item, int qty) {
        this.item = item;
        this.qty = qty;
    }

    public SKU getItem() {
        return item;
    }

    public int getQty() {
        return qty;
    }
}
