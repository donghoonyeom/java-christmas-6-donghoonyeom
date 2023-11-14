package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

@DisplayName("주중,주말 할인 테스트")
class WeekendWeekdayDiscountTest {

    private Set<OrderItem> createMenus() {
        Set<OrderItem> menus = new HashSet<>();
        menus.add(new OrderItem("티본스테이크", 2));
        menus.add(new OrderItem("초코케이크", 1));
        return menus;
    }

    @Test
    @DisplayName("주말 할인이 올바르게 계산되는지 확인")
    void weekendDayDiscount() {
        // Given
        int date = 1; // 주말
        Set<OrderItem> menus = createMenus();

        // When
        int result = WeekendWeekdayDiscount.weekendDayDiscount(date, menus);

        // Then
        assertThat(result).isEqualTo(4046);
    }

    @Test
    @DisplayName("평일 할인이 올바르게 계산되는지 확인")
    void weekDayDiscount() {
        // Given
        int date = 5; // 평일
        Set<OrderItem> menus = createMenus(); // 적절한 주문 항목 생성

        // When
        int result = WeekendWeekdayDiscount.weekDayDiscount(date, menus);

        // Then
        assertThat(result).isEqualTo(2023);
    }
}
