package kata.supermarket;

import kata.supermarket.discount.IDiscount;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ItemByWeight implements Item {

    private final WeighedProduct product;
    private final BigDecimal weightInKilos;
    private final IDiscount iDiscount;

    ItemByWeight(final WeighedProduct product, final BigDecimal weightInKilos, final IDiscount iDiscount) {
        this.product = product;
        this.weightInKilos = weightInKilos;
        this.iDiscount = iDiscount;
    }

    public BigDecimal price() {
        return product.pricePerKilo().multiply(weightInKilos).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal discount() {
        return iDiscount.applyDiscount(this);
    }
}
