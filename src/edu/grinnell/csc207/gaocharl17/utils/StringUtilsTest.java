package edu.grinnell.csc207.gaocharl17.utils;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

import edu.grinnell.csc207.gaocharl17.utils.Fraction;

public class StringUtilsTest {

	@Test
	public void testSplitAt() {
		assertArrayEquals(new String[] { "a", "b", "c" },
                StringUtils.splitAt("a:b:c", ':'));
	}

	@Test
	public void testSplitAt2() {
		assertArrayEquals(new String[] { "a", "b", "c" },
                StringUtils.splitAt("a b c", ' '));
	}
	
	@Test
	public void testSplitAt3() {
		assertArrayEquals(new String[] {"a b c"},
                StringUtils.splitAt("a b c", ';'));
	}
	
	@Test
	public void testSplitAt4() {
		assertArrayEquals(new String[] {"a", "b", "c", "/", "p"},
                StringUtils.splitAt("arbrcr/rp", 'r'));
	}
	
	
	@Test
	public void testSplitAt5() {
		assertArrayEquals(new String[] { "a", "b", "c" },
	            StringUtils.splitCSV("a,b,c"));
	}

	@Test
	public void testSplitAt6() {
		assertArrayEquals(new String[] { "a,b", "c" },
	            StringUtils.splitCSV("\"a,b\",c"));
	}
	
	@Test
	public void testSplitAt7() {
		assertArrayEquals(new String[] { "a", "b,b\"", "c" },
	            StringUtils.splitCSV("a,\"b,b\"\"\",c"));
	}
	
	@Test
	public void testSplitAt8() {
		assertArrayEquals(new String[] { "a", "b\"b", "c" }, 
	            StringUtils.splitCSV("a,\"b\"\"b\",c"));
	}
	
	@Test
	public void testCalcAt9() {
		assertEquals(BigInteger.valueOf(0), StringUtils.calculatorEval0("0"));
	}
	
	@Test
	public void testSplitAt10() {
		assertEquals(BigInteger.valueOf(2), StringUtils.calculatorEval0("1 + 1"));
	}
	
	
	@Test
	public void testSplitAt11() {
		assertEquals(BigInteger.valueOf(4), StringUtils.calculatorEval0("1 + 2 + 1"));
	}
	
	@Test
	public void testSplitAt12() {
		assertEquals(BigInteger.valueOf(9), StringUtils.calculatorEval0("1 + 2 * 3"));
	}
	
	@Test
	public void testCalcAt13() {
		assertEquals(new Fraction("1/1").toString(), StringUtils.calculatorEval1("1/2 + 1/2").toString());
	}
	
	@Test
	public void testCalcAt14() {
		assertEquals(new Fraction("4/5").toString(), StringUtils.calculatorEval1("1/1 - 1/5").toString());
	}

	@Test
	public void testCalcAt15() {
		assertEquals(new Fraction("4/5").toString(), StringUtils.calculatorEval1("2/5 * 2/1").toString());
	}
}

