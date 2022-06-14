package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.ItemByWeight;
import kata.supermarket.WeighedProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OneKiloForHalfPriceDiscountTest {


    @DisplayName("applies the one kilo for half price discount when item weight is...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void applyBuyOneKiloForHalfPriceDiscount(String description, String expectedDiscountTotal, ItemByWeight item) {
        final OneKiloForHalfPriceDiscount oneKiloForHalfPriceDiscount = new OneKiloForHalfPriceDiscount();
        assertEquals(new BigDecimal(expectedDiscountTotal), oneKiloForHalfPriceDiscount.applyDiscount(item));
    }

    static Stream<Arguments> applyBuyOneKiloForHalfPriceDiscount() {
        return Stream.of(
                Arguments.of("Three Kilograms", "4.49", oneKiloForHalfPrice_threeKilos()),
                Arguments.of("Zero Kilograms", "0.00", oneKiloForHalfPrice_zeroGrams()),
                Arguments.of("750g", "1.05", oneKiloForHalfPrice_700_grams())
        );
    }

    private static WeighedProduct aKiloOfPickAndMix() {
        return new WeighedProduct(new BigDecimal("2.99"));
    }

    private static Item oneKiloForHalfPrice_threeKilos() {
        return aKiloOfPickAndMix().weighingWithDiscount(new BigDecimal("3"), new OneKiloForHalfPriceDiscount());
    }

    private static Item oneKiloForHalfPrice_zeroGrams() {
        return aKiloOfPickAndMix().weighingWithDiscount(new BigDecimal("0"), new OneKiloForHalfPriceDiscount());
    }

    private static Item oneKiloForHalfPrice_700_grams() {
        return aKiloOfPickAndMix().weighingWithDiscount(new BigDecimal(".700"), new OneKiloForHalfPriceDiscount());
    }
}
