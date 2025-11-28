package calculator.domain;

import java.util.List;

public class Numbers {
    private final List<Number> numbers;

    private Numbers(List<Number> numbers) {
        this.numbers = numbers;
    }

    public static Numbers from(List<Number> numbers) {
        return new Numbers(numbers);
    }

    public int sum() {
        int sum = 0;
        for (Number number : numbers) {
            sum += number.getNumber();
        }
        return sum;
    }
}
