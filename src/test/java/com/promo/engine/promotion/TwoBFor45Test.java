package com.promo.engine.promotion;

import com.promo.engine.Cart;
import com.promo.engine.CartItem;
import com.promo.engine.Promotion;
import com.promo.engine.SKU;
import com.promo.engine.promotion.ThreeAFor130;
import com.promo.engine.promotion.TwoBsFor45;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TwoBFor45Test {
    SKU a = new SKU("A", 50);
    SKU b = new SKU("B", 30);
    SKU c = new SKU("C", 20);
    SKU d = new SKU("D", 15);

    static List<Promotion> promotions;

    @BeforeAll
    public static void setup(){
        promotions = new ArrayList<>();
        promotions.add(new ThreeAFor130());
        promotions.add(new TwoBsFor45());
        promotions.add(new CAndDFor30());
    }

    @BeforeEach
    public void beforeEachTest(){

    }

    @Test
    public void cartWith1A1B1C(){
        Cart cart = new Cart(promotions);
        cart.add(new CartItem(a,1));
        cart.add(new CartItem(b,1));
        cart.add(new CartItem(c,1));

        cart.checkout();

        Assertions.assertEquals(100, cart.getTotal());
    }

    @Test
    public void cartWith2B(){
        Cart cart = new Cart(promotions);
        cart.add(new CartItem(b,2));

        cart.checkout();

        Assertions.assertEquals(45, cart.getTotal());
    }

    @Test
    public void cartWith5B(){
        Cart cart = new Cart(promotions);
        cart.add(new CartItem(b,5));

        cart.checkout();

        Assertions.assertEquals(120, cart.getTotal());
    }
}
