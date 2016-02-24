package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/valid-parentheses/
// Author : Xin Zhao
// Date   : 2016-02-24

import java.util.Stack;

/**********************************************************************************
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 **********************************************************************************/

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            switch (curChar) {
                case ')':
                    if(stack.isEmpty() || stack.pop()!='(') {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.isEmpty() || stack.pop()!='[') {
                        return false;
                    }
                    break;
                case '}':
                    if(stack.isEmpty() || stack.pop()!='{') {
                        return false;
                    }
                    break;
                default:
                    stack.push(curChar);
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses o = new ValidParentheses();
        System.out.println(true + "\t" + o.isValid("()[]{}"));
        System.out.println(false + "\t" + o.isValid("([)]"));

    }
}
