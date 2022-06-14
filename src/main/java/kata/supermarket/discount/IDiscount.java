package kata.supermarket.discount;

import kata.supermarket.ItemByUnit;
import kata.supermarket.ItemByWeight;

import java.math.BigDecimal;

public interface IDiscount {
    //TODO: Can this be made generic to avoid method overloading?
    default BigDecimal applyDiscount(final ItemByUnit itemByUnit) {
        return BigDecimal.ZERO;
    }

    default BigDecimal applyDiscount(final ItemByWeight itemByWeight) {
        return BigDecimal.ZERO;
    }
}
