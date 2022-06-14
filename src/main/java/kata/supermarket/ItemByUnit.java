package kata.supermarket;

import kata.supermarket.discount.IDiscount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByUnit implements Item {

    private final Product product;
    private final IDiscount iDiscount;
    private final int units;

    ItemByUnit(final Product product, int units, IDiscount iDiscount) {
        this.product = product;
        this.units = units;
        this.iDiscount = iDiscount;
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
        return iDiscount.applyDiscount(this);
    }

    public int units() {
        return units;
    }

}
