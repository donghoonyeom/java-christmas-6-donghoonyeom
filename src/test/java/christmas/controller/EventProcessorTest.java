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

@DisplayName("이벤트 프로세서 테스트")
class EventProcessorTest {

    @Test
    @DisplayName("이벤트 처리 테스트")
    void processEvent() {
        // Given
        Order order = mock(Order.class);
        when(order.calculateBadge(10000, 5000)).thenReturn("별");


        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When
        EventProcessor.processEvent(order, 15, 10000);

        // Then
        String printedOutput = outputStream.toString();
        assertThat(printedOutput).contains(
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
        );
    }

    @Test
    @DisplayName("총 할인 계산 테스트")
    void calculateTotalDiscount() {
        // Given
        Order order = mock(Order.class);
        when(order.calculateTotalDiscount(15)).thenReturn(1000);

        // When
        int totalDiscount = EventProcessor.calculateTotalDiscount(order, 15);

        // Then
        assertThat(totalDiscount).isEqualTo(1000);
    }

    @Test
    @DisplayName("할인 금액 출력 테스트")
    void printDiscountAmount() {
        // Given
        Set<OrderItem> menus = new HashSet<>();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When
        EventProcessor.printDiscountAmount(15, menus, 10000);

        // Then
        String printedOutput = outputStream.toString();
        assertThat(printedOutput).contains("-2,400원");
    }

    @Test
    @DisplayName("혜택 출력 테스트")
    void printBenefits() {
        // Given
        int totalBenefits = 10000;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When
        EventProcessor.printBenefits(totalBenefits);

        // Then
        String printedOutput = outputStream.toString();
        assertThat(printedOutput).contains("-10,000원");
    }

    @Test
    @DisplayName("결제 금액 출력 테스트")
    void printPayment() {
        // Given
        int totalPayment = 30000;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When
        EventProcessor.printPayment(totalPayment);

        // Then
        String printedOutput = outputStream.toString();
        assertThat(printedOutput).contains("30,000원");
    }
}
