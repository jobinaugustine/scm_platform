package com.promo.engine;

import java.util.List;

public class Cart {
    private List<Promotion> promotions;
    private List<CartItem> items;
    private double total;
    private double discount;

    public List<CartItem> add(CartItem item) {
        this.items.add(item);
        this.total+=item.getItem().getPrice()*item.getQty();

        return items;
    }

    public void applyPromotion(){

    }
}
