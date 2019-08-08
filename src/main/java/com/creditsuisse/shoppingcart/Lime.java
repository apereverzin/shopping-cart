package com.creditsuisse.shoppingcart;

import java.math.BigDecimal;

public class Lime extends Product {
    private static final BigDecimal UNIT_PRICE = new BigDecimal(15);
    private static final String NAME = "Lime";

    public Lime() {
        super(NAME, amount -> UNIT_PRICE.multiply(
                new BigDecimal(amount / 3 * 2 + amount % 3)
        ));
    }
}
