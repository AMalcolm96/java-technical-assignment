package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class DiscountComponent {

    public BigDecimal calculateDiscount(Iterable<Item> basketItems) {
        return BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
    }
}
