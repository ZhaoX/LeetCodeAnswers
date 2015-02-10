package com.xin.LeetCodeAnswers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInAStringTest {
	
	@Test
	public void testBasis()
	{
		assertEquals("blue is sky the", ReverseWordsInAString.reverseWords("the sky is blue"));
		assertEquals("1", ReverseWordsInAString.reverseWords("1 "));
	}

}
