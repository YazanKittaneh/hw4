package edu.grinnell.csc207.gaocharl17.utils;

import static org.junit.Assert.*;

import org.junit.Test;

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
}
