package com.creditsuisse.shoppingcart;

import java.math.BigDecimal;

public class Melon extends Product {
    private static final BigDecimal UNIT_PRICE = new BigDecimal(50);
    private static final String NAME = "Melon";

    public Melon() {
        super(NAME, amount -> UNIT_PRICE.multiply(
                new BigDecimal(amount / 2 + (amount % 2 == 0 ? 0 : 1))
        ));
    }
}
