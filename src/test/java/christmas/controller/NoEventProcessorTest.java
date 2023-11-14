package christmas.controller;


import christmas.model.Order;
import christmas.model.OrderItem;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@DisplayName("이벤트 미진행 프로세서 테스트")
class NoEventProcessorTest {

    @Test
    @DisplayName("이벤트 미진행 처리 테스트")
    void processNoEvent() {
        // Given
        Order order = mock(Order.class);
        when(order.getMenus()).thenReturn(someSetOfOrderItems());

        // Redirect System.out to capture printed output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When
        NoEventProcessor.processNoEvent(order, 15, 1000);

        // Then
        // Get the printed output
        String printedOutput = outputStream.toString();


        assertThat(printedOutput).contains("없음");
        assertThat(printedOutput).contains("0원");
        assertThat(printedOutput).contains(
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
        );
    }

    private Set<OrderItem> someSetOfOrderItems() {
        // 적절한 OrderItem들을 생성하여 반환
        Set<OrderItem> orderItems = new HashSet<>();
        // 예를 들어, 필요한 OrderItem들을 생성하여 orderItems에 추가
        return orderItems;
    }
}
