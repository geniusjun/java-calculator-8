package calculator.controller;

import calculator.view.OutputView;

public class CalculatorController {
    private final OutputView outputView;

    public CalculatorController(OutputView outputView) {
        this.outputView = outputView;
        outputView.start();
    }
}
