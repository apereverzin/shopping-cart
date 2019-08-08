package com.creditsuisse.shoppingcart;

import java.math.BigDecimal;
import java.util.function.Function;

public abstract class Product {
    private final String name;
    private final Function<Integer, BigDecimal> price;

    public Product(String name, BigDecimal unitPrice) {
        this(name, amount -> unitPrice.multiply(new BigDecimal(amount)));
    }

    public Product(String name, Function<Integer, BigDecimal> price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice(int amount) {
        return price.apply(amount);
    }
}
