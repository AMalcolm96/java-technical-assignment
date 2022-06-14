package kata.supermarket.discount;

import kata.supermarket.Item;

import java.math.BigDecimal;

public interface Discount {
    BigDecimal applyDiscount(Item item);
}
