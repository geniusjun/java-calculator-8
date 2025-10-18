package calculator.domain;

import calculator.global.CustomException;
import calculator.global.ErrorMessage;
import java.util.ArrayList;
import java.util.List;

public class PositiveNumbers {
    private final List<Integer> positiveNumbers;

    private PositiveNumbers(List<Integer> positiveNumbers) {
        this.positiveNumbers = List.copyOf(positiveNumbers);
    }

    public static PositiveNumbers from(Tokens tokens) {
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens.getTokens()) {
            numbers.add(Parser.parseStringToInt(token));
        }
        return new PositiveNumbers(numbers);
    }

    private static class Parser {
        public static int parseStringToInt(String token) {
            isNumber(token);
            return Integer.parseInt(token);
        }

        private static void isNumber(String token) {
            if (!token.chars().allMatch(Character::isDigit)) {
                throw CustomException.from(ErrorMessage.INVALID_NUMBER_FORMAT);
            }
        }
    }
}
