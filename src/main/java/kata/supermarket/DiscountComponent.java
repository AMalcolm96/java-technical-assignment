package kata.supermarket;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.stream.StreamSupport;


public class DiscountComponent {

    public BigDecimal calculateDiscount(Iterable<Item> basketItems) {
        return StreamSupport.stream(basketItems.spliterator(), false)
                .map(Item::discount)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
