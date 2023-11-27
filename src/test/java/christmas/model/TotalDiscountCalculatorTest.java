package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

@DisplayName("통합 할인 계산 테스트")
class TotalDiscountCalculatorTest {

    @Test
    @DisplayName("날짜 할인이 올바르게 계산되는지 확인")
    void calculateDateDiscount() {
        // Given
        int date = 3;
        Set<OrderItem> menus = new HashSet<>();

        // When
        int result = TotalDiscountCalculator.calculateDateDiscount(date, menus);

        // Then
        assertThat(result).isEqualTo(1200);
    }

    @Test
    @DisplayName("스타 할인이 올바르게 계산되는지 확인")
    void calculateStarDiscount() {
        // Given
        int date = 10;

        // When
        int result = TotalDiscountCalculator.calculateStarDiscount(date);

        // Then
        assertThat(result).isEqualTo(1000);
    }

    @Test
    @DisplayName("기프트 메뉴가 올바르게 계산되는지 확인")
    void calculateGiftMenu() {
        // Given
        int totalOrderAmount = 130000;
        int totalDiscount = 5000;

        // When
        int result = TotalDiscountCalculator.calculateGiftMenu(totalOrderAmount, totalDiscount);

        // Then
        assertThat(result).isEqualTo(totalDiscount + Menu.getChampagnePrice());
    }

    @Test
    @DisplayName("선물 메뉴의 가격이 정상적으로 출력되는지 확인")
    void printGiftMenuPrice() {
        // Given
        int totalOrderAmount = 130000;

        // When
        int result = TotalDiscountCalculator.printGiftMenuPrice(totalOrderAmount);

        // Then
        assertThat(result).isEqualTo(Menu.getChampagnePrice());
    }
}
