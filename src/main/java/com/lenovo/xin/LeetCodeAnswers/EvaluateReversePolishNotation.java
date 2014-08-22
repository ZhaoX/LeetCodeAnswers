package com.lenovo.xin.LeetCodeAnswers;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
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
