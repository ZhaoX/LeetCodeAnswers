package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/generate-parentheses/
// Author : Xin Zhao
// Date   : 2016-02-25

import java.util.LinkedList;
import java.util.List;

/**********************************************************************************
 *
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 *
 * For example, given n = 3, a solution set is:
 *
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 *
 **********************************************************************************/

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        LinkedList<Node> queue = new LinkedList<Node>();

        if(n > 0) {
            queue.add(new Node(n, n, ""));
        }

        for(int i = 0; i < 2*n; i++) {
            int len = queue.size();
            while(len-- > 0) {
                Node head = queue.poll();
                if(head.left >= head.right) {
                    queue.add(new Node(head.left-1, head.right, head.parentheses+"("));
                } else {
                    queue.add(new Node(head.left, head.right-1, head.parentheses+")"));
                    if(head.left > 0) {
                        queue.add(new Node(head.left-1, head.right, head.parentheses+"("));
                    }
                }
            }
        }

        LinkedList<String> ret = new LinkedList<String>();

        for(Node node : queue) {
            ret.add(node.parentheses);
        }

        return ret;
    }


    public List<String> generateParenthesis1(int n) {
        LinkedList<String> list = new LinkedList<String>();
        generateParenthesis(list, "", 0, 0, n);
        return list;
    }

    void generateParenthesis(List<String> list, String parenthesis, int left, int right, int num) {
        if(left + right == 2*num) {
            list.add(parenthesis);
            return;
        }

        if(left <= right) {
            generateParenthesis(list, parenthesis+"(", left+1, right, num);
        } else {
            generateParenthesis(list, parenthesis+")", left, right+1, num);
            if(left < num) {
                generateParenthesis(list, parenthesis+"(", left+1, right, num);
            }
        }
    }

    public static void main(String[] args) {
        GenerateParentheses o = new GenerateParentheses();

        System.out.println(o.generateParenthesis1(3));
        System.out.println(o.generateParenthesis1(0));
        System.out.println(o.generateParenthesis1(1));
    }

}

class Node {
    int left;
    int right;
    String parentheses;
    Node (int left, int right, String parentheses) {
        this.left = left;
        this.right = right;
        this.parentheses = parentheses;
    }
}
