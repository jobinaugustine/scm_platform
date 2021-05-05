package com.promo.engine.promotion;

import com.promo.engine.Cart;
import com.promo.engine.Promotion;

import java.util.List;

public class ThreeAFor130 implements Promotion {
    private static final String description="3AFor130";

    @Override
    public Cart apply(List<Promotion> promotions, Cart cart) {
        return cart;
    }
}
