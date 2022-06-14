package kata.supermarket.discount;

import kata.supermarket.ItemByUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BuyOneGetOneFreeDiscount implements Discount {
    @Override
    public BigDecimal applyDiscount(ItemByUnit item) {
        return new BigDecimal(item.units() / 2)
                .multiply(item.pricePerUnit())
                .setScale(2, RoundingMode.HALF_UP);
    }
}
