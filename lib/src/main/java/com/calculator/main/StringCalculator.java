package com.calculator.main;

public class StringCalculator {
	
	public int calculate(String str) {
		 String[] splitStr = str.split(" ");
		 int result = 0;
		 
		 if (splitStr.length == 1) {
			 return Integer.parseInt(str);
		 }
		 for (int i = 0; i < splitStr.length; i = i + 2) {
			 if(i == 0) {
				 result = Integer.parseInt(splitStr[i]);
				 continue;
			 }
			 
			 result = calculateInt(result, Integer.parseInt(splitStr[i]), splitStr[i - 1]);
		 }

		 return result;
	};
	
	int calculateInt(int a, int b, String type) {
		if (type.equals("+")) {
			return plus(a, b);
		}
		else if (type.equals("-")) {
			return minus(a, b);
		}
		else if (type.equals("*")) {
			return mul(a, b);
		}
		else if (type.equals("/")) {
			return div(a, b);
		}
		
		throw new IllegalArgumentException("유효한 연산자가 아닙니다.");
	}

	int plus(int a, int b) {
		return Math.addExact(a, b);
	}
	
	int minus(int a, int b) {
		return Math.subtractExact(a, b);
	}

	int mul(int a, int b) {
		return Math.multiplyExact(a, b);
	}

	int div(int a, int b) {
		return Math.floorDiv(a, b);
	}

}
