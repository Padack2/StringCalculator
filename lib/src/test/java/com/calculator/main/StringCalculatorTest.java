package com.calculator.main;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.apache.commons.math3.exception.OutOfRangeException;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
	StringCalculator calculator = new StringCalculator();
	
	@Test
	void calcaulteTest() {
		assertThat(calculator.calculate("5")).isEqualTo(5);
		assertThat(calculator.calculate("5 + 4")).isEqualTo(9);
		assertThat(calculator.calculate("5 - 4")).isEqualTo(1);
		assertThat(calculator.calculate("5 * 4")).isEqualTo(20);
		assertThat(calculator.calculate("5 / 4")).isEqualTo(1);
		assertThat(calculator.calculate("5 + 4 / 3 * 7")).isEqualTo(21);
		assertThat(catchThrowable(() -> {
			calculator.calculate("5123123123123123123123123123123123123");
			})).isInstanceOf(IllegalArgumentException.class);
		assertThat(catchThrowable(() -> {
			calculator.calculate("dfsfsdsdf");
			})).isInstanceOf(IllegalArgumentException.class);
	}
	
	@Test
	void plusTest() {
		assertThat(calculator.plus(2, 3)).isEqualTo(5);
		assertThat(calculator.plus(0, 9)).isEqualTo(9);
		assertThat(calculator.plus(4646, 56456)).isEqualTo(61102);
		assertThat(catchThrowable(() -> {
			calculator.plus(Integer.MAX_VALUE - 1, 10);
			})).isInstanceOf(ArithmeticException.class);
	}
	
	@Test
	void minusTest() {
		assertThat(calculator.minus(2, 2)).isEqualTo(0);
		assertThat(calculator.minus(0, 9)).isEqualTo(-9);
		assertThat(calculator.minus(5500, 500)).isEqualTo(5000);
		assertThat(catchThrowable(() -> {
			calculator.minus(Integer.MIN_VALUE + 1, 10);
			})).isInstanceOf(ArithmeticException.class);
	}
	
	@Test
	void mulTest() {
		assertThat(calculator.mul(2, 2)).isEqualTo(4);
		assertThat(calculator.mul(0, 9)).isEqualTo(0);
		assertThat(calculator.mul(4500, 500)).isEqualTo(2250000);
		assertThat(catchThrowable(() -> {
			calculator.mul(Integer.MAX_VALUE - 1, 10);
			})).isInstanceOf(ArithmeticException.class);
		assertThat(catchThrowable(() -> {
			calculator.mul(Integer.MIN_VALUE + 1, 10);
			})).isInstanceOf(ArithmeticException.class);
	}
	
	@Test
	void divTest() {
		assertThat(calculator.div(4, 2)).isEqualTo(2);
		assertThat(calculator.div(5, 2)).isEqualTo(2);
		assertThat(catchThrowable(() -> {
			calculator.div(10, 0);
			})).isInstanceOf(ArithmeticException.class);
	}
}
