package kata.supermarket;

import kata.supermarket.discount.Discount;
import kata.supermarket.discount.NoDiscount;

import java.math.BigDecimal;

public class WeighedProduct {

    private final BigDecimal pricePerKilo;

    public WeighedProduct(final BigDecimal pricePerKilo) {
        this.pricePerKilo = pricePerKilo;
    }

    BigDecimal pricePerKilo() {
        return pricePerKilo;
    }


    public Item weighing(final BigDecimal kilos) {
        return new ItemByWeight(this, kilos, new NoDiscount());
    }

    public Item weighingWithDiscount(final BigDecimal kilos, Discount discount) {
        return new ItemByWeight(this, kilos, discount);
    }
}
