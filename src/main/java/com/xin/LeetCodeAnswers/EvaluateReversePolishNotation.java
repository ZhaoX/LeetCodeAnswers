package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/evaluate-reverse-polish-notation/
// Author : Xin Zhao
// Date   : 2015-02-11

/**********************************************************************************
 *
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Some examples:
 *
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 *
 **********************************************************************************/

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static int evalRPN(String[] tokens) {
    	if(tokens==null||tokens.length==0){
    		return 0;
    	}
    	Stack<Integer> stack = new Stack<Integer>();
    	for(String token : tokens){
    	  if(token.equals("+")){
    		  stack.push(stack.pop() + stack.pop());
    	  }else if(token.equals("-")){
    		  int rOperand = stack.pop();
    		  stack.push(stack.pop() - rOperand);
    	  }else if(token.equals("*")){
    		  stack.push(stack.pop() * stack.pop());
    	  }else if(token.equals("/")){
    		  int rOperand = stack.pop();
    		  stack.push(stack.pop() / rOperand);
    	  }else{
    		  stack.push(Integer.parseInt(token));
    	  }
    	}
    	return stack.pop();
    }
}
