package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/regular-expression-matching/
// Author : Xin Zhao
// Date   : 2016-01-25

/**********************************************************************************
 *
 * Implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 *
 * The matching should cover the entire input string (not partial).
 *
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 *
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 *
 **********************************************************************************/

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] ret = new boolean[m+1][n+1];

        ret[0][0] = true;

        for(int i = 1; i <= m; i++) {
            ret[i][0] = false;
        }

        for(int i = 1; i <= n; i++) {
            if(p.charAt(i-1) == '*' && ret[0][i-2]) {
                ret[0][i] = true;
            }else {
                ret[0][i] = false;
            }
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(p.charAt(j-1) != '*') {
                    if(ret[i-1][j-1] && (p.charAt(j-1) == '.' || s.charAt(i-1) == p.charAt(j-1))) {
                        ret[i][j] = true;
                    }else {
                        ret[i][j] = false;
                    }
                }else {
                    if(ret[i][j-2]) {
                        ret[i][j] = true;
                    }else if(ret[i][j-1]) {
                        ret[i][j] = true;
                    }else if(ret[i-1][j] && (p.charAt(j-2) == '.' || s.charAt(i-1) == p.charAt(j-2))) {
                        ret[i][j] = true;
                    }else {
                        ret[i][j] = false;
                    }
                }
            }
        }

        print2DArray(ret);

        return ret[m][n];
    }

    private void print2DArray(boolean[][] array) {
        for(int i = 0; i < array.length; i++) {
            for(int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        RegularExpressionMatching o = new RegularExpressionMatching();

        //System.out.println(o.isMatch("aa", "a") + "  false");
        //System.out.println(o.isMatch("aa", "aa") + "  true");
        //System.out.println(o.isMatch("aaa", "aa") + "  false");
        //System.out.println(o.isMatch("aa", "a*") + "  true");
        //System.out.println(o.isMatch("aa", ".*") + "  true");
        //System.out.println(o.isMatch("ab", ".*") + "  true");
        //System.out.println(o.isMatch("aab", "c*a*b") + "  true");
        System.out.println(o.isMatch("aaa", ".*") + "  true");

    }

}
