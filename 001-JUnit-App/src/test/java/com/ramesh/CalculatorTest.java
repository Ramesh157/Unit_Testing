package com.ramesh;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;


public class CalculatorTest {

	private static Calculator cal = null;

	@BeforeClass
	public static void init() {
		cal = new Calculator();
	}

	@Test
	public void testAdd_01() {

		Integer actualResult = cal.add(20, 30);
		Integer expectedResult = 50;

		assertEquals(expectedResult, actualResult);

	}

	@Test
	public void testAdd_02() {
		Integer actualResult = cal.add(10, 15);
		Integer expectedResult = 25;

		assertEquals(actualResult, expectedResult);
	}

	@Test
	
	public void testAdd_03() {
		Integer actual = cal.add(100, 300);
		Integer expected = 400;

		assertEquals(actual, expected);
	}
	
	@Test
	
	public void testMul_01() {
		Integer actual=cal.multi(5, 4);
		Integer expected=20;
		
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDiv_01() {
		Integer actual=cal.div(4, 2);
		Integer expected=2;
		assertEquals(expected, actual);
	}

	
	@Test(expected = ArithmeticException.class)
	public void testDiv_02() {
		Integer actual=cal.div(4, 0);
		/*
		 * Integer expected=2; assertEquals(expected, actual);
		 */
	}
	@AfterClass
	public static void destroy() {
		cal = null;

	}

}
