package christmas.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("주문 입력 예외 테스트")
class OrderValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {
            "양송이수프-2,타파스-3,시저샐러드-1",
            "티본스테이크-2,타파스-3"
    })
    @DisplayName("유효한 주문이 정상적으로 처리되는지 확인")
    void validateAndGetOrder_ValidOrder(String order) {
        // When
        String result = OrderValidator.validateAndGetOrder(order);

        // Then
        assertThat(result).isEqualTo(order);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-2,타파스-3,파스타-1",
            "제로콜라-2,초코케이크-3,볶음밥-1"
    })
    @DisplayName("메뉴판에 없는 메뉴가 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_InvalidMenuInOrder(String order) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "제로콜라-2,초코케이크-3,RedWine-1",
            "바비큐립-2,크리스마스파스타-3,BBQRibs-1"
    })
    @DisplayName("영문자가 포함된 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_OrderWithEnglish(String order) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "제로콜라-2,레드와인-3,샴페인-1",
            "제로콜라-2,샴페인-3"
    })
    @DisplayName("음료만으로 이루어진 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_BeverageOnlyOrder(String order) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "바비큐립-2,크리스마스파스타-3,바비큐립-1",
            "티본스테이크-2,시저샐러드-3,초코케이크-1,티본스테이크-2"
    })
    @DisplayName("주문 메뉴가 중복되는 경우 예외가 발생하는지 확인")
    void validateAndGetOrder_DuplicateMenus(String order) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "아이스크림-2,초코케이크-0,타파스-1",
            "시저샐러드-0,초코케이크-1,티본스테이크-1"
    })
    @DisplayName("주문 메뉴의 수량이 0인 경우 예외가 발생하는지 확인")
    void validateAndGetOrder_InvalidQuantity(String order) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-2,양송이수프-3,시저샐러드-1,바비큐립-5,해산물파스타-6,초코케이크-7,아이스크림-8",
            "티본스테이크-5,시저샐러드-5,초코케이크-5,해산물파스타!-6"
    })
    @DisplayName("총 주문 수량이 최대 허용치를 초과하는 경우 예외가 발생하는지 확인")
    void validateAndGetOrder_ExceedMaxMenuCount(String order) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "티본스테이크-2,시저샐러드-3,초코케이크-1,해산물파스타!-2",  // 특수 문자가 포함된 주문
            "시저샐러드%-2,초코케이크-3,티본스테이크-1,"
    })
    @DisplayName("특수 문자가 포함된 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_OrderWithSpecialCharacters(String order) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "시저샐러드-2,초코케이크-3,티본스테이크-1,",
            "시저샐러드-2,초코케이크-3,티본스테이크--1",
            "시저샐러드-2,,초코케이크-3,티본스테이크-1",
            ",시저샐러드-2,초코케이크-3,티본스테이크-1",
            "시저샐러드-2,초코케이크-3,티본스테이크-1,,,"
    })
    @DisplayName("잘못된 형식의 주문이 입력될 때 예외가 발생하는지 확인")
    void validateAndGetOrder_InvalidOrderCommaFormat(String order) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> OrderValidator.validateAndGetOrder(order));
    }
}
