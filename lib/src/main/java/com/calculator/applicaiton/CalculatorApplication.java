package com.calculator.applicaiton;

import com.calculator.main.StringCalculator;
import com.calculator.ui.InputView;
import com.calculator.ui.ResultView;

public class CalculatorApplication {

	public static void main(String[] args) {
		InputView inputView = InputView.INSTANCE;
		ResultView resultView = ResultView.INSTANCE;
		StringCalculator calculator = new StringCalculator();
		
		String input = inputView.getInput();
		try {
			int result = calculator.calculate(input);
			
			resultView.printResult(result);
		} catch (NumberFormatException e) {
			resultView.printError("입력한 숫자가 int 범위(-2,147,483,648 ~ 2,147,483,647)를 벗어났거나 정수가 아닙니다.");
		} catch (ArithmeticException e) {
			if (e.getMessage().contains("by zero")) {
				resultView.printError("0으로 나눌 수 없습니다.");
			} else {
				resultView.printError("연산 중 결과가 표현할 수 있는 범위를 넘어섰습니다!(-2,147,483,648 ~ 2,147,483,647)");
			}
		}

	}

}
