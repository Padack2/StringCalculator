package com.calculator.ui;

public enum ResultView {
	INSTANCE;
	
	public void printResult(int result) {
		System.out.println("계산 결과: " + result);
	}
	
	public void printError(String msg) {
		System.out.println(msg);
	}
}
