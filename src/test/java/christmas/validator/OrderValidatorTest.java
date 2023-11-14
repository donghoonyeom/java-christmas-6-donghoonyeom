package christmas.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("주문 입력 예외 테스트")
class OrderValidatorTest {

    @Test
    @DisplayName("유효한 주문이 입력될 때 정상적으로 처리되는지 확인")
    void validateAndGetOrder_ValidOrder() {
        // Given
        String order = "양송이수프-2,타파스-3,시저샐러드-1";

        // When
        String result = OrderValidator.validateAndGetOrder(order);

        // Then
        assertThat(result).isEqualTo(order);
    }

    @Test
    @DisplayName("유효하지 않은 메뉴 포맷이 포함된 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_InvalidMenuFormat() {
        // Given
        String order = "티본스테이크-2,타파스-3,파스타-1";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @Test
    @DisplayName("영문자가 포함된 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_OrderWithEnglish() {
        // Given
        String order = "제로콜라-2,초코케이크-3,RedWine-1";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @Test
    @DisplayName("음료만으로 이루어진 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_BeverageOnlyOrder() {
        // Given
        String order = "제로콜라-2,레드와인-3,샴페인-1";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @Test
    @DisplayName("주문 메뉴가 중복되는 경우 예외가 발생하는지 확인")
    void validateAndGetOrder_DuplicateMenus() {
        // Given
        String order = "바비큐립-2,크리스마스파스타-3,바비큐립-1";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @Test
    @DisplayName("주문 메뉴의 수량이 0인 경우 예외가 발생하는지 확인")
    void validateAndGetOrder_InvalidQuantity() {
        // Given
        String order = "아이스크림-2,초코케이크-0,타파스-1";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @Test
    @DisplayName("총 주문 수량이 최대 허용치를 초과하는 경우 예외가 발생하는지 확인")
    void validateAndGetOrder_ExceedMaxMenuCount() {
        // Given
        String order = "티본스테이크-2,양송이수프-3,시저샐러드-1,바비큐립-5,해산물파스타-6,초코케이크-7,아이스크림-8";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @Test
    @DisplayName("특수 문자가 포함된 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_OrderWithSpecialCharacters() {
        // Given
        String order = "티본스테이크-2,시저샐러드-3,초코케이크-1,해산물파스타!-2";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @Test
    @DisplayName("잘못된 형식의 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_InvalidOrderCommaFormat() {
        // Given
        String order = "시저샐러드-2,초코케이크-3,티본스테이크-1,";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @Test
    @DisplayName("잘못된 형식의 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_InvalidOrderFormat() {
        // Given
        String order = "시저샐러드-2,초코케이크-3,티본스테이크--1";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }
}
