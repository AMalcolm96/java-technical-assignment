package kata.supermarket;

import kata.supermarket.discount.IDiscount;
import kata.supermarket.discount.NoDiscount;

import java.math.BigDecimal;

public class Product {

    private final BigDecimal pricePerUnit;

    public Product(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf() {
        return new ItemByUnit(this, 1, new NoDiscount());
    }

    public Item createProduct(final int units, final IDiscount iDiscount) {
        return new ItemByUnit(this, units, iDiscount);
    }
}
