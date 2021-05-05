package com.promo.engine;

import java.util.List;

public interface Promotion {
    public Cart apply(List<Promotion> promotions, Cart cart);
}
