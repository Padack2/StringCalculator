package com.calculator.ui;

import java.util.Scanner;

public enum InputView {
	INSTANCE;
	
	private Scanner sc = new Scanner(System.in);
	
	public String getInput() {
		String result = "";
		
		System.out.print("계산할 식을 입력해주세요.(우선순위와 관계 없이 입력 순서대로 계산됩니다.");
		result = sc.nextLine();
		
		return result;
	}
}
