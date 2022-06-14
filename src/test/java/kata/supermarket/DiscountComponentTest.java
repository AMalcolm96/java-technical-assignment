package kata.supermarket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountComponentTest {

    @DisplayName("")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void calculateBasketDiscounts(String description, String expectedDiscountTotal, Iterable<Item> basketItems) {
        final DiscountComponent discountComponent = new DiscountComponent();
        assertEquals(new BigDecimal(expectedDiscountTotal), discountComponent.calculateDiscount(basketItems));
    }

    static Stream<Arguments> calculateBasketDiscounts() {
        return Stream.of(noItems());
    }

    private static Arguments noItems() {
        return Arguments.of("no items", "0.00", Collections.emptyList());
    }

}
