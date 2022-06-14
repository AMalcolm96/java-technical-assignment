package kata.supermarket.discount;

import kata.supermarket.Item;
import kata.supermarket.ItemByUnit;
import kata.supermarket.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyOneGetOneFreeDiscountTest {

    @DisplayName("applies the buy one get one free discount when item quantity is... ")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void applyBuyOneGetOneFreeDiscount(String description, String expectedDiscountTotal, ItemByUnit item) {
        final BuyOneGetOneFreeDiscount buyOneGetOneFreeDiscount = new BuyOneGetOneFreeDiscount();
        assertEquals(new BigDecimal(expectedDiscountTotal), buyOneGetOneFreeDiscount.applyDiscount(item));
    }

    static Stream<Arguments> applyBuyOneGetOneFreeDiscount() {
        return Stream.of(
                Arguments.of("Single Unit of Item", "0.00", buyOneGetOneFree_singleUnit()),
                Arguments.of("Two Units", "0.99", buyOneGetOneFree_twoUnits()),
                Arguments.of("Three Units", "0.99", buyOneGetOneFree_threeUnits()),
                Arguments.of("Four Units", "1.98", buyOneGetOneFree_fourUnits()),
                Arguments.of("Five Units", "1.98", buyOneGetOneFree_fiveUnits())
        );
    }

    private static Item buyOneGetOneFree_singleUnit() {
        return new Product(new BigDecimal("0.99")).createProduct(1, new BuyOneGetOneFreeDiscount());
    }

    private static Item buyOneGetOneFree_twoUnits() {
        return new Product(new BigDecimal("0.99")).createProduct(2, new BuyOneGetOneFreeDiscount());
    }

    private static Item buyOneGetOneFree_threeUnits() {
        return new Product(new BigDecimal("0.99")).createProduct(3, new BuyOneGetOneFreeDiscount());
    }

    private static Item buyOneGetOneFree_fourUnits() {
        return new Product(new BigDecimal("0.99")).createProduct(4, new BuyOneGetOneFreeDiscount());
    }

    private static Item buyOneGetOneFree_fiveUnits() {
        return new Product(new BigDecimal("0.99")).createProduct(5, new BuyOneGetOneFreeDiscount());
    }
}
