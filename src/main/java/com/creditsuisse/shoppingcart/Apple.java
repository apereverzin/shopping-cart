package com.creditsuisse.shoppingcart;

import java.math.BigDecimal;

public class Apple extends Product {
    private static final BigDecimal UNIT_PRICE = new BigDecimal(35);
    private static final String NAME = "Apple";

    public Apple() {
        super(NAME, UNIT_PRICE);
    }
}
