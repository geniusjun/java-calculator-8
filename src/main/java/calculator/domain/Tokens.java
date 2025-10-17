package calculator.domain;

import calculator.global.CustomException;
import calculator.global.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Tokens {
    private final List<String> tokens;

    private Tokens(List<String> tokens) {
        this.tokens = List.copyOf(tokens);
    }

    public static Tokens from(String input) {
        List<String> split = Parser.split(input);
        return new Tokens(split);
    }

    private static class Parser {
        private static final String BASE_DELIMITER = Pattern.quote(",") + "|" + Pattern.quote(":");
        private static final String CUSTOM_HEADER = "//";
        private static final char LINEFEED = '\n';

        public static List<String> split(String input) {
            if (hasCustom(input)) {
                return splitWithCustom(input);
            }
            return split(input, BASE_DELIMITER);
        }

        private static List<String> splitWithCustom(String input) {
            int lf = lineFeedIndex(input);
            final char custom = getCustomDelimiter(input.substring(2, lf));
            return Arrays.asList(input); // 임시
        }

        private static boolean hasCustom(String input) {
            return input.startsWith(CUSTOM_HEADER);
        }

        private static int lineFeedIndex(String input) {
            int lineFeed = input.indexOf(LINEFEED);
            if (lineFeed < 0) {
                throw CustomException.from(ErrorMessage.INVALID_LINEFEED);
            }
            return LINEFEED;
        }

        private static char getCustomDelimiter(String custom) {
            if (custom.length() != 1) {
                throw CustomException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER);
            }
            return custom.charAt(0);
        }

        private static List<String> split(String body, String delimiter) {
            return Arrays.asList(body.split(delimiter, -1));
        }
    }

}
