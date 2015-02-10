package com.xin.LeetCodeAnswers;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluateReversePolishNotationTest {
	@Test
	public void testBasis()
	{
		assertEquals(9, EvaluateReversePolishNotation.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
		assertEquals(6, EvaluateReversePolishNotation.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
		assertEquals(0, EvaluateReversePolishNotation.evalRPN(new String[]{"0", "3", "/"}));
	}
}
