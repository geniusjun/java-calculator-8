package calculator.domain;

import static calculator.global.ErrorMessage.INVALID_POSITIVE_NUMBER;

public class Number {

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number from(int num) {
        validatePositive(num);
        return new Number(num);
    }

    private static void validatePositive(int num) {
        if (num <= 0) {
            throw new IllegalArgumentException(INVALID_POSITIVE_NUMBER.getMessage());
        }
    }
}
