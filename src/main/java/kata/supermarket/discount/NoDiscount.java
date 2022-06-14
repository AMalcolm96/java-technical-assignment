package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;

public class NoDiscount implements Discount {

    @Override
    public BigDecimal applyDiscount(Item item) {
        return BigDecimal.ZERO;
    }

}
