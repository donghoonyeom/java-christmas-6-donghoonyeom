package christmas.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("날짜 입력 예외 테스트")
class DateValidatorTest {

    @Test
    @DisplayName("유효한 날짜가 입력될 때 정상적으로 처리되는지 확인")
    void validateAndGetDate_ValidDate() {
        // Given
        String input = "15";

        // When
        int result = DateValidator.validateAndGetDate(input);

        // Then
        assertThat(result).isEqualTo(15);
    }

    @Test
    @DisplayName("유효하지 않은 숫자 형식의 날짜가 입력될 때 예외가 발생하는지 확인")
    void validateAndGetDate_InvalidNumberFormat() {
        // Given
        String input = "abc";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> DateValidator.validateAndGetDate(input));
    }

    @Test
    @DisplayName("유효하지 않은 날짜 범위가 입력될 때 예외가 발생하는지 확인")
    void validateAndGetDate_InvalidDateRange() {
        // Given
        String input = "40";

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> DateValidator.validateAndGetDate(input));
    }
}
