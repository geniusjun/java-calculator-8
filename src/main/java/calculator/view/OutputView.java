package calculator.view;

import calculator.console.ConsoleWriter;

public class OutputView {
    private static final String START_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public void start() {
        ConsoleWriter.printlnMessage(START_MESSAGE);
    }
}
