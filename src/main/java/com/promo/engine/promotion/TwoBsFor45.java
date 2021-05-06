package com.promo.engine.promotion;

import com.promo.engine.Cart;
import com.promo.engine.CartItem;
import com.promo.engine.Promotion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TwoBsFor45 implements Promotion {
    Logger logger = LoggerFactory.getLogger(TwoBsFor45.class);
    private static final String description="T2BFor45";

    @Override
    public Cart apply(Cart cart) {

        return cart;
    }
}
