package calculator.console;

import calculator.global.CustomException;
import calculator.global.ErrorMessage;
import camp.nextstep.edu.missionutils.Console;

public final class ConsoleReader {
    public static String readMessage() {
        return Validator.validate(Console.readLine());
    }

    private static class Validator {
        public static String validate(String message) {
            return validateBlank(message);
        }

        private static String validateBlank(final String message) {
            if (message.isBlank()) {
                throw CustomException.from(ErrorMessage.BLANK_INPUT_ERROR);
            }
            return message;
        }
    }
}
