package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import calculator.global.CustomException;
import calculator.global.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TokensTest {

    @Test
    @DisplayName("기본 구분자(: ,)로 분리한다.")
    void splitByBaseDelimiter() {
        // given
        String input = "1:2,3";
        // when
        Tokens tokens = Tokens.from(input);
        // then
        assertThat(tokens.getTokens()).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자(//<char>\\n)로 구분한다.")
    void splitByCustomDelimiter() {
        // given
        String input = "//?\\n1?2?3";
        // when
        Tokens tokens = Tokens.from(input);
        // then
        assertThat(tokens.getTokens()).containsExactly("1", "2", "3");
    }

    @Test
    @DisplayName("커스텀 구분자 선언 형식에서 \\n이 없으면 INVALID_LINEFEED 발생")
    void missingLineFeedThrow() {
        // given
        String input = "//?1?2?3";
        // exception
        assertThatThrownBy(() -> Tokens.from(input))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LINEFEED.getMessage());
    }

    @Test
    @DisplayName("커스텀 구분자가 1글자가 아니면 INVALID_CUSTOM_DELIMITER")
    void customDelimiterLengthInvalid() {
        // given
        String input = "//;?\\n1;?2;?3";
        // exception
        assertThatThrownBy(() -> Tokens.from(input))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorMessage.INVALID_CUSTOM_DELIMITER.getMessage());
    }

    @Test
    @DisplayName("연속 구분자(빈 토큰)이면 EMPTY_TOKEN_ERROR")
    void emptyTokenBetweenDelimiter() {
        // given
        String input = "1,,3";
        // exception
        assertThatThrownBy(() -> Tokens.from(input))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_TOKEN_ERROR.getMessage());
    }

    @Test
    @DisplayName("마지막이 구분자로 끝난다면(빈 토큰) EMPTY_TOKEN_ERROR")
    void emptyTokenLastDelimiter() {
        // given
        String input = "1,2,";
        // exception
        assertThatThrownBy(() -> Tokens.from(input))
                .isInstanceOf(CustomException.class)
                .hasMessageContaining(ErrorMessage.EMPTY_TOKEN_ERROR.getMessage());
    }
}
