package calculator.domain;

import calculator.global.CustomException;
import calculator.global.ErrorMessage;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Tokens {
    private final List<String> tokens;

    private Tokens(List<String> tokens) {
        this.tokens = List.copyOf(tokens);
    }

    public static Tokens from(String input) {
        List<String> split = Validator.validateEmpty(Parser.split(input));
        return new Tokens(split);
    }

    public Stream<String> stream() {
        return tokens.stream();
    }

    private static class Parser {
        private static final String BASE_DELIMITER = Pattern.quote(",") + "|" + Pattern.quote(":");
        private static final String CUSTOM_HEADER = "//";
        private static final String LINEFEED = "\\n";

        public static List<String> split(String input) {
            if (hasCustom(input)) {
                return splitWithCustom(input);
            }
            return split(input, BASE_DELIMITER);
        }

        private static List<String> splitWithCustom(String input) {
            int lineFeedIndex = lineFeedIndex(input);
            final char custom = getCustomDelimiter(input.substring(CUSTOM_HEADER.length(), lineFeedIndex));
            return split(input.substring(lineFeedIndex + LINEFEED.length()), makeDelimiter(custom));
        }

        private static boolean hasCustom(String input) {
            return input.startsWith(CUSTOM_HEADER);
        }

        private static int lineFeedIndex(String input) {
            int index = input.indexOf(LINEFEED);
            if (index < 0) {
                throw CustomException.from(ErrorMessage.INVALID_LINEFEED);
            }
            return index;
        }

        private static char getCustomDelimiter(String custom) {
            if (custom.length() != 1) {
                throw CustomException.from(ErrorMessage.INVALID_CUSTOM_DELIMITER);
            }
            return custom.charAt(0);
        }

        private static String makeDelimiter(char input) {
            return BASE_DELIMITER + "|" + Pattern.quote(String.valueOf(input));
        }

        private static List<String> split(String body, String delimiter) {
            return Arrays.asList(body.split(delimiter, -1));
        }
    }

    private static class Validator {
        public static List<String> validateEmpty(List<String> tokens) {
            if (tokens.stream().anyMatch(String::isEmpty)) {
                throw CustomException.from(ErrorMessage.EMPTY_TOKEN_ERROR);
            }
            return tokens;
        }
    }

}
