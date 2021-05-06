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
        List<CartItem> cartItems = cart.getItems();

        double discount = cart.getDiscount();
        double total = cart.getTotal();

        for(CartItem cartItem: cartItems){
            double promotionTotal = 0;
            if(cartItem.getItem().getId().equals("B")){
                int qty = cartItem.getQty();
                double price = cartItem.getItem().getPrice();
                int promoQty = qty/2;
                int reminder = qty%2;
                if(promoQty > 0){ //here we can apply promotion
                    promotionTotal = ((promoQty) * 45) + (reminder * price);
                    discount = (qty*price) - promotionTotal;

                    logger.debug("TwoBsFor45 promotion total : [{}]" , promotionTotal);
                    logger.debug("TwoBsFor45 promotion discount : [{}]" , discount);

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
