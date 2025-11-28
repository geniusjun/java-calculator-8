package calculator.global;

import calculator.domain.Number;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Number> parseStringToNumber(String input) {
        String[] split = input.split(",|:");
        List<Number> numbers = new ArrayList<>();
        for (String string : split) {
            numbers.add(Number.from(Integer.parseInt(string)));
        }
        return numbers;
    }

    public static List<Number> parseStringToNumberCustom(String input, String custom) {
        String[] split = input.split(",|:" + "|" + custom);
        List<Number> numbers = new ArrayList<>();
        for (String string : split) {
            numbers.add(Number.from(Integer.parseInt(string)));
        }
        return numbers;
    }
}
