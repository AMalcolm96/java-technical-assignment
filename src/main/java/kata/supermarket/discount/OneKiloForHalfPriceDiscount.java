package kata.supermarket.discount;

import kata.supermarket.ItemByWeight;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OneKiloForHalfPriceDiscount implements IDiscount {

    public BigDecimal applyDiscount(ItemByWeight itemByWeight) {
        //TODO: This is imperfect depending on the requirements. If we were to have 1.5kg it would fail logically
        return itemByWeight.price()
                .multiply(new BigDecimal("0.5"))
                .setScale(2, RoundingMode.HALF_UP);
    }
}
