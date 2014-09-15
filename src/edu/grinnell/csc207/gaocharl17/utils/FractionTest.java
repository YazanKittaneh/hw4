package edu.grinnell.csc207.gaocharl17.utils;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testSubtract() {
		Fraction f = new Fraction(1, 2);
		Fraction l = new Fraction(4, 4);
		assertEquals("1/2", l.subtract(f).toString());
	}
	
	@Test
	public void testDivide() {
		Fraction f = new Fraction(1, 2);
		Fraction l = new Fraction(4, 4);
		assertEquals("2/1", l.divide(f).toString());
	}


	@Test
	public void testFractional() {
		Fraction f = new Fraction(1, 2);
		Fraction l = new Fraction(4, 4);
		assertEquals("1/2", l.fractional(f).toString());
	}

	@Test
	public void testNegate() {
		Fraction f = new Fraction(-1, 2);
		Fraction l = new Fraction(1, 2);
		assertEquals(f.toString(), l.negate().toString());
	}
	
	@Test
	public void testPow() {
		Fraction f = new Fraction(1, 4);
		Fraction l = new Fraction(1, 2);
		assertEquals(f.toString(), l.pow(2).toString());
	}
	
}
