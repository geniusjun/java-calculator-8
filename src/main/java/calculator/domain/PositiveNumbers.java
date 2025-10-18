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
            int value = Parser.parseStringToInt(token);
            Validator.isPositive(value);
            numbers.add(value);
        }
        return new PositiveNumbers(numbers);
    }

    public int sum() {
        return positiveNumbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
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

    private static final class Validator {
        public static void isPositive(int v) {
            if (v <= 0) {
                throw CustomException.from(ErrorMessage.INVALID_NUMBER_POSITIVE);
            }
        }
    }
}
