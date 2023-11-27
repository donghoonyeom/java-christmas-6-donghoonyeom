package christmas.controller;


import christmas.model.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

@DisplayName("이벤트 계획 테스트")
class EventPlannerTest {

    @Test
    @DisplayName("이벤트 계획 - 총 주문 금액이 이벤트 최소 금액 이상인 경우 이벤트 처리 메서드 호출")
    void planEvent_TotalOrderAmountGreaterThanOrEqualToMinAmount_ShouldInvokeProcessEvent() {
        // Given
        Order order = mock(Order.class);
        when(order.calculateTotalOrderAmount()).thenReturn(15000);
        int date = 1;

        // When
        EventPlanner.planEvent(order, date);

        // Then
        verify(order, times(1)).calculateTotalDiscount(1);
    }

    @Test
    @DisplayName("이벤트 계획 - 총 주문 금액이 이벤트 최소 금액 미만인 경우 NoEventProcessor의 처리 메서드 호출")
    void planEvent_TotalOrderAmountLessThanMinAmount_ShouldInvokeNoEventProcessor() {
        // Given
        Order order = mock(Order.class);
        when(order.calculateTotalOrderAmount()).thenReturn(9000);
        int date = 1;

        // When
        EventPlanner.planEvent(order, date);

        // Then
        verify(order, times(0)).calculateTotalDiscount(1);
    }

}
