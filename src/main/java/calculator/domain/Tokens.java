package calculator.domain;

import java.util.List;

public class Tokens {
    private final List<String> tokens;

    private Tokens(List<String> tokens) {
        this.tokens = List.copyOf(tokens);
    }

    public static Tokens from(String input) {
        // TODO: 헤더 파싱(//<char>\n), 구분자 집합 구성, 토큰화, 빈 토큰 검증
        return new Tokens(List.of(input));
    }
}
