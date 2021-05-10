package com.promo.engine.promotion;

import com.promo.engine.Cart;
import com.promo.engine.CartItem;
import com.promo.engine.Promotion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CAndDFor30 implements Promotion {
    Logger logger = LoggerFactory.getLogger(CAndDFor30.class);

    private static final String description="CAndDFor30";

    @Override
    public Cart apply(Cart cart) {
        List<CartItem> cartItems = cart.getItems();

        double discount = cart.getDiscount();
        double total = cart.getTotal();

        int totalC = 0;
        int totalD = 0;
        double priceC=0;
        double priceD=0;

        for(CartItem cartItem: cartItems){
            double promotionTotal = 0;

            if(cartItem.getItem().getId().equals("C")) {
                totalC = cartItem.getQty();
                priceC = cartItem.getItem().getPrice();
            }
            if(cartItem.getItem().getId().equals("D")) {
                totalD = cartItem.getQty();
                priceD = cartItem.getItem().getPrice();
            }
            if(totalC>0 && totalD>0){
                break;
            }
        }

        int diff = totalC-totalD;
        double promotionTotal = 0;

        //if diff is <0 means more D
        if(diff>0){
            promotionTotal = ((totalC-diff) * 30) + (diff*priceC);
            discount = (totalC*priceC)+(totalD*priceD)- promotionTotal;
        }
        else{
            promotionTotal = ((totalD-diff) * 30) + (diff*priceD);
            discount = (totalC*priceC)+(totalD*priceD)- promotionTotal;
        }

        logger.debug("CAndDFor30 promotion total : [{}] " , promotionTotal);
        logger.debug("CAndDFor30 promotion discount : [{}]" , discount);

        cart.setDiscount(discount);
        cart.setTotal(total-discount);

        return cart;
    }
}
