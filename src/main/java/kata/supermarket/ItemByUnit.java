package kata.supermarket;

import kata.supermarket.discount.Discount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByUnit implements Item {

    private final Product product;
    private final Discount discount;
    private final int units;

    ItemByUnit(final Product product, int units, Discount discount) {
        this.product = product;
        this.units = units;
        this.discount = discount;
    }

    public BigDecimal price() {
        return pricePerUnit()
                .multiply(new BigDecimal(units))
                .setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal pricePerUnit() {
        return product.pricePerUnit();
    }

    public BigDecimal discount() {
        return discount.applyDiscount(this);
    }

    public int units() {
        return units;
    }

}
