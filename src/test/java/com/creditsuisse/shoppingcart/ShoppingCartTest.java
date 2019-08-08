package com.creditsuisse.shoppingcart;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCartTest {
    private static final BigDecimal APPLE_PRICE = new BigDecimal(35);
    private static final BigDecimal BANANA_PRICE = new BigDecimal(20);
    private static final BigDecimal MELON_PRICE = new BigDecimal(50);
    private static final BigDecimal LIME_PRICE = new BigDecimal(15);

    private ShoppingCart shoppingCart;

    @Before
    public void setUp() throws Exception {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void getTotalPrice_returnsZeroForEmptyBasket() throws Exception {
        assertThat(shoppingCart.getTotalPrice(), is(BigDecimal.ZERO));
    }

    @Test
    public void getTotalPrice_returnsPriceForOneApple() throws Exception {
        addProduct(new Apple(), 1);

        assertThat(shoppingCart.getTotalPrice(), is(APPLE_PRICE));
    }

    @Test
    public void getTotalPrice_returnsPriceForThreeApples() throws Exception {
        addProduct(new Apple(), 3);

        assertThat(shoppingCart.getTotalPrice(), is(APPLE_PRICE.multiply(new BigDecimal(3))));
    }

    @Test
    public void getTotalPrice_returnsPriceForThreeBananas() throws Exception {
        addProduct(new Banana(), 3);

        assertThat(shoppingCart.getTotalPrice(), is(BANANA_PRICE.multiply(new BigDecimal(3))));
    }

    @Test
    public void getTotalPrice_returnsPriceForOneMelon() throws Exception {
        addProduct(new Melon(), 1);

        assertThat(shoppingCart.getTotalPrice(), is(MELON_PRICE));
    }

    @Test
    public void getTotalPrice_returnsPriceForTwoMelons() throws Exception {
        addProduct(new Melon(), 2);

        assertThat(shoppingCart.getTotalPrice(), is(MELON_PRICE));
    }

    @Test
    public void getTotalPrice_returnsPriceForFiveMelons() throws Exception {
        addProduct(new Melon(), 5);

        assertThat(shoppingCart.getTotalPrice(), is(MELON_PRICE.multiply(new BigDecimal(3))));
    }

    @Test
    public void getTotalPrice_returnsPriceForOneLime() throws Exception {
        addProduct(new Lime(), 1);

        assertThat(shoppingCart.getTotalPrice(), is(LIME_PRICE));
    }

    @Test
    public void getTotalPrice_returnsPriceForTwoLimes() throws Exception {
        addProduct(new Lime(), 2);

        assertThat(shoppingCart.getTotalPrice(), is(LIME_PRICE.multiply(new BigDecimal(2))));
    }

    @Test
    public void getTotalPrice_returnsPriceForThreeLimes() throws Exception {
        addProduct(new Lime(), 3);

        assertThat(shoppingCart.getTotalPrice(), is(LIME_PRICE.multiply(new BigDecimal(2))));
    }

    @Test
    public void getTotalPrice_returnsPriceForFourLimes() throws Exception {
        addProduct(new Lime(), 4);

        assertThat(shoppingCart.getTotalPrice(), is(LIME_PRICE.multiply(new BigDecimal(3))));
    }

    @Test
    public void getTotalPrice_returnsPriceForFiveLimes() throws Exception {
        addProduct(new Lime(), 5);

        assertThat(shoppingCart.getTotalPrice(), is(LIME_PRICE.multiply(new BigDecimal(4))));
    }

    @Test
    public void getTotalPrice_returnsPriceForSixLimes() throws Exception {
        addProduct(new Lime(), 6);

        assertThat(shoppingCart.getTotalPrice(), is(LIME_PRICE.multiply(new BigDecimal(4))));
    }

    @Test
    public void getTotalPrice_returnsPriceForSevenLimes() throws Exception {
        addProduct(new Lime(), 7);

        assertThat(shoppingCart.getTotalPrice(), is(LIME_PRICE.multiply(new BigDecimal(5))));
    }

    @Test
    public void getTotalPrice_returnsPriceForTwoApplesTwoBananasThreeMelonsFourLimes() throws Exception {
        addProduct(new Apple(), 2);
        addProduct(new Banana(), 2);
        addProduct(new Melon(), 3);
        addProduct(new Lime(), 4);

        assertThat(shoppingCart.getTotalPrice(), is(
                APPLE_PRICE.multiply(new BigDecimal(2)).
                add(BANANA_PRICE.multiply(new BigDecimal(2))).
                add(MELON_PRICE.multiply(new BigDecimal(2))).
                add(LIME_PRICE.multiply(new BigDecimal(3)))
        ));
    }

    private void addProduct(Product product, int times) {
        for (int i = 0; i < times; i++) {
            shoppingCart.addProduct(product);
        }
    }
}