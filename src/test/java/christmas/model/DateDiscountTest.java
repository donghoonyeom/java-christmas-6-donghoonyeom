import christmas.model.DateDiscount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("DateDiscount 테스트")
class DateDiscountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("할인 대상 날짜인 경우 올바른 할인액을 반환해야 함")
    void ddayDiscount_DiscountDay_ReturnsCorrectDiscountAmount(int date) {
        int expectedDiscount = 1000 + (date - 1) * 100;

        int actualDiscount = DateDiscount.ddayDiscount(date);

        assertEquals(expectedDiscount, actualDiscount);
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 28, 30})
    @DisplayName("할인 대상 날짜가 아닌 경우 할인이 적용되지 않아야 함")
    void ddayDiscount_NonDiscountDay_ReturnsZeroDiscount(int date) {
        int actualDiscount = DateDiscount.ddayDiscount(date);

        assertEquals(0, actualDiscount);
    }
}
