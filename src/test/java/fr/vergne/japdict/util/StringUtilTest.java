package fr.vergne.japdict.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testSplitReturnsAllElements() {
		List<Character> split = StringUtil.split("01213");
		Collection<Character> expected = Arrays.<Character> asList('0', '1',
				'2', '1', '3');
		assertTrue(split.containsAll(expected));
		assertTrue(expected.containsAll(split));
	}

	@Test
	public void testSplitOnEmptyReturnsEmpty() {
		List<Character> split = StringUtil.split("");
		assertNotNull(split);
		assertTrue(split.isEmpty());
	}

}
