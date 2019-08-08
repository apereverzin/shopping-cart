package com.creditsuisse.shoppingcart;

import java.math.BigDecimal;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ShoppingCart {
    private final ConcurrentHashMap<Product, AtomicInteger>products = new ConcurrentHashMap<>();

    public void addProduct(Product product) {
        if (products.putIfAbsent(product, new AtomicInteger(1)) != null) {
            products.get(product).incrementAndGet();
        };
    }

    public BigDecimal getTotalPrice() {
        return products.entrySet().stream().
                map(e -> e.getKey().getPrice(e.getValue().get())).
                reduce(BigDecimal.ZERO, (total, subtotal) -> total.add(subtotal));
    }
}
