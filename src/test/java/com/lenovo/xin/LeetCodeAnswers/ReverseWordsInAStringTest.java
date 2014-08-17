package com.lenovo.xin.LeetCodeAnswers;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseWordsInAStringTest {
	
	@Test
	public void testBasis()
	{
		assertEquals("blue is sky the", new ReverseWordsInAString().reverseWords("the sky is blue"));
		assertEquals("1", new ReverseWordsInAString().reverseWords("1 "));
	}

}
