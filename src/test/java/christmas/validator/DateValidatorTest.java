package christmas.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("날짜 입력 예외 테스트")
class DateValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"15", "1", "31"}) // 유효한 날짜들
    @DisplayName("유효한 날짜가 입력될 때 정상적으로 처리되는지 확인")
    void validateAndGetDate_ValidDate(String input) {
        // When
        int result = DateValidator.validateAndGetDate(input);

        // Then
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "-1", "32", "100"})
    @DisplayName("유효하지 않은 숫자 형식의 날짜가 입력될 때 예외가 발생하는지 확인")
    void validateAndGetDate_InvalidNumberFormat(String input) {
        // When, Then
        assertThrows(IllegalArgumentException.class, () -> DateValidator.validateAndGetDate(input));
    }
}
