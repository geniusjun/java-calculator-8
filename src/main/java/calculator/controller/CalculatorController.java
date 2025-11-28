package calculator.controller;

import calculator.domain.Numbers;
import calculator.global.Parser;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {

    private final InputView inputView;
    private final OutputView outputView;

    public CalculatorController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        outputView.printStartMessage();
        Numbers numbers = parseInput(inputView.readLine());
        int sum = numbers.sum();
        outputView.printSum(sum);
    }

    private Numbers parseInput(String input) {
        if (input.startsWith("/")) {
            String custom = input.substring(2, 3);
            String customInput = input.substring(5);
            return Numbers.from(Parser.parseStringToNumberCustom(customInput, custom));
        }
        return Numbers.from(Parser.parseStringToNumber(input));
    }
}
