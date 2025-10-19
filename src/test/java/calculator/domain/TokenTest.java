package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TokenTest {

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
}
