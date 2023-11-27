package christmas.model;

import org.assertj.core.groups.Tuple;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.groups.Tuple.tuple;

@DisplayName("Order 테스트")
class OrderTest {

    @Test
    @DisplayName("주문 생성이 정상적으로 이루어지는지 확인")
    void createOrder() {
        // Given
        int date = 12;
        String orderInput = "해산물파스타-2,레드와인-1,초코케이크-1";

        // When
        Order order = Order.createOrder(date, orderInput);

        // Then
        assertOrderDetails(order, 3, tuple("해산물파스타", 2), tuple("레드와인", 1), tuple("초코케이크", 1));
    }

    @Test
    @DisplayName("총 주문 금액이 정확하게 계산되는지 확인")
    void calculateTotalOrderAmount() {
        // Given
        int date = 12; // 예시 날짜
        String orderInput = "해산물파스타-2,레드와인-1,초코케이크-1";
        Order order = Order.createOrder(date, orderInput);

        // When
        int totalOrderAmount = order.calculateTotalOrderAmount();

        // Then
        assertThat(totalOrderAmount).isEqualTo(145000);
    }

    @Test
    @DisplayName("총 할인 금액이 정확하게 계산되는지 확인")
    void calculateTotalDiscount() {
        // Given
        int date = 12; // 예시 날짜
        String orderInput = "해산물파스타-2,레드와인-1,초코케이크-1";
        Order order = Order.createOrder(date, orderInput);

        // When
        int totalDiscount = order.calculateTotalDiscount(12);

        // Then
        assertThat(totalDiscount).isEqualTo(4123);
    }

    private void assertOrderDetails(Order order, int expectedSize, Tuple... expectedTuples) {
        Set<OrderItem> menus = order.getMenus();
        assertThat(menus).hasSize(expectedSize);
        assertThat(menus).extracting("menuName", "quantity").containsExactlyInAnyOrder(expectedTuples);
    }
}
