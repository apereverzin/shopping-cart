package com.creditsuisse.shoppingcart;

import java.math.BigDecimal;

public class Banana extends Product {
    private static final BigDecimal UNIT_PRICE = new BigDecimal(20);
    private static final String NAME = "Banana";

    public Banana() {
        super(NAME, UNIT_PRICE);
    }
}
