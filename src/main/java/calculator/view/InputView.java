package calculator.view;

import calculator.console.ConsoleReader;

public class InputView {
    public String requestLine() {
        return ConsoleReader.readMessage();
    }
}
