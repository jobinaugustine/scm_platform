package com.promo.engine.promotion;

import com.promo.engine.Cart;
import com.promo.engine.CartItem;
import com.promo.engine.Promotion;
import com.promo.engine.SKU;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ThreeAFor130 implements Promotion {
    Logger logger = LoggerFactory.getLogger(ThreeAFor130.class);

    private static final String description="3AFor130";

    @Override
    public Cart apply(Cart cart) {

        List<CartItem> cartItems = cart.getItems();

        double discount = cart.getDiscount();
        double total = cart.getTotal();

        for(CartItem cartItem: cartItems){
            double promotionTotal = 0;
            if(cartItem.getItem().getId().equals("A")){
                int qty = cartItem.getQty();
                double price = cartItem.getItem().getPrice();
                int promoQty = qty/3;
                int reminder = qty%3;
                if(qty/3 > 0){ //here we can apply promotion
                    promotionTotal = ((promoQty) * 130) + (reminder * price);
                    discount = (qty*price) - promotionTotal;

                    logger.debug("promotion total : " + promotionTotal);
                    logger.debug("promotion discount : " + discount);

                    cart.setDiscount(discount);
                    cart.setTotal(total-discount);
                }
                //assuming same item's quantity will get summed into one single item
                break;
            }
        }
        return cart;
    }
}
