package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import calculator.global.CustomException;
import calculator.global.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PositiveNumbersTest {

    @Test
    @DisplayName("숫자 형식이 아니면 INVALID_NUMBER_FORMAT 발생")
    void invalidNumberFormat_nonDigit() {
        // given
        Tokens tokens = Tokens.from("1,a,3");
        // exception
        assertThatThrownBy(() -> PositiveNumbers.from(tokens))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_FORMAT.getMessage());
    }

    @Test
    @DisplayName("음수가 들어오면 INVALID_NUMBER_POSITIVE 발생")
    void invalidNumberFormat_negative() {
        // given
        Tokens tokens = Tokens.from("1,-2,3");
        // exception
        assertThatThrownBy(() -> PositiveNumbers.from(tokens))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_POSITIVE.getMessage());
    }

    @Test
    @DisplayName("0이 들어오면 INVALID_NUMBER_POSITIVE 발생")
    void invalidNumberFormat_zero() {
        // given
        Tokens tokens = Tokens.from("1,0,3");
        // exception
        assertThatThrownBy(() -> PositiveNumbers.from(tokens))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorMessage.INVALID_NUMBER_POSITIVE.getMessage());
    }

    @Test
    @DisplayName("합산 결과 출력")
    void sumReturnTotal() {
        // given
        Tokens tokens = Tokens.from("1,2,3");
        // when
        PositiveNumbers positiveNumbers = PositiveNumbers.from(tokens);
        // then
        assertThat(positiveNumbers.sum()).isEqualTo(6);
    }
}
