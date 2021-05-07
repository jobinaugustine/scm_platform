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

public class CartWith2PromotionTest {
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
    }

    @BeforeEach
    public void beforeEachTest(){

    }

    @Test
    public void cartWith5A5B1C(){
        Cart cart = new Cart(promotions);
        cart.add(new CartItem(a,5));
        cart.add(new CartItem(b,5));
        cart.add(new CartItem(c,1));

        cart.applyPromotion();

        Assertions.assertEquals(370, cart.getTotal());
    }

    @Test
    public void cartWith1A1B1C(){
        Cart cart = new Cart(promotions);
        cart.add(new CartItem(a,3));
        cart.add(new CartItem(b,3));
        cart.add(new CartItem(c,1));

        cart.applyPromotion();

        Assertions.assertEquals(225, cart.getTotal());
    }
}
