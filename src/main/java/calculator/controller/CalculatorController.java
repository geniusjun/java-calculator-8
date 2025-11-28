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
        Numbers numbers = Numbers.from(Parser.parseStringToNumber(inputView.readLine()));
        int sum = numbers.sum();

    }
}
