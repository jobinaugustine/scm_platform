package com.promo.engine;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Promotion> promotions;
    private List<CartItem> items;
    private double total;
    private double discount;

    public Cart(List<Promotion> promotions) {
        this.promotions = promotions;
        items = new ArrayList<>();
        total=0;
        discount=0;
    }

    public List<CartItem> add(CartItem item) {
        this.items.add(item);
        this.total+=item.getItem().getPrice()*item.getQty();

        return items;
    }

    private void applyPromotion(){
        promotions.stream().forEach(promotion -> promotion.apply(this));
    }

    public void checkout(){
        applyPromotion();
        System.out.println("Checkout completed: Total Amount to Pay : " + total);
        System.out.println("Applied Promotion : " + discount);
    }

    public List<CartItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    public double getDiscount() {
        return discount;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
