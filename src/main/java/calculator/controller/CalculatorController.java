package calculator.controller;

import calculator.domain.PositiveNumbers;
import calculator.domain.Tokens;
import calculator.view.InputView;
import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputView;
    private final InputView inputView;

    public CalculatorController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
        outputView.start();
    }

    public void calculate() {
        PositiveNumbers numbers = PositiveNumbers.from(Tokens.from(inputView.requestLine()));
        outputView.result(numbers.sum());
    }
}
