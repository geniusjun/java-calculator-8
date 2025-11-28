package calculator.global;

import calculator.domain.Number;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Number> parseStringToNumber(String input) {
        String[] split = input.split(",|:");
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            numbers.add(Number.from(Integer.parseInt(split[i])));
        }
        return numbers;
    }
}
