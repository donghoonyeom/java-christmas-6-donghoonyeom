package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("스타 할인 테스트")
class StarDiscountTest {

    @Test
    @DisplayName("스타 할인이 적용되는지 확인")
    void starDayDiscount() {
        // Given
        int discountDate = 3;
        int nonDiscountDate = 5;

        // When
        int discountResult = StarDiscount.starDayDiscount(discountDate);
        int nonDiscountResult = StarDiscount.starDayDiscount(nonDiscountDate);

        // Then
        assertThat(discountResult).isEqualTo(1000);
        assertThat(nonDiscountResult).isEqualTo(0);
    }
}