package calculator.controller;

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
        String a = inputView.requestLine(); // 임
        System.out.println(a);
    }
}
