package christmas.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("OrderItem 테스트")
class OrderItemTest {

    @Test
    @DisplayName("getMenuName 메뉴 이름 테스트")
    void getMenuName() {
        // Given
        OrderItem orderItem = new OrderItem("메뉴1", 2);

        // When
        String menuName = orderItem.getMenuName();

        // Then
        assertThat(menuName).isEqualTo("메뉴1");
    }

    @Test
    @DisplayName("getQuantity 수량 테스트")
    void getQuantity() {
        // Given
        OrderItem orderItem = new OrderItem("메뉴2", 4);

        // When
        int quantity = orderItem.getQuantity();

        // Then
        assertThat(quantity).isEqualTo(4);
    }

    @Test
    @DisplayName("calculateMenuAmount 가격 계산 테스트")
    void calculateMenuAmount() {
        // Given
        OrderItem orderItem = new OrderItem("타파스", 3);

        // When
        int menuAmount = orderItem.calculateMenuAmount();

        // Then
        assertThat(menuAmount).isEqualTo(3 * Menu.getPriceByMenuName("타파스"));
    }
}