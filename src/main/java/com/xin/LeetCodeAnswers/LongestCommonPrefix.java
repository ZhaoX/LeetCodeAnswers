package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/longest-common-prefix/
// Author : Xin Zhao
// Date   : 2016-02-19

/**********************************************************************************
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 **********************************************************************************/

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        int minLen = strs[0].length();

        for(int i = 0; i < strs.length; i++) {
            if(strs[i].length() < minLen) {
                minLen = strs[i].length();
            }
        }

        int pos = 0;

        for(; pos < minLen; pos++) {
            boolean allEqual = true;
            for(int i= 1; i < strs.length; i++) {
                if(strs[i].charAt(pos) != strs[0].charAt(pos)) {
                    allEqual = false;
                }
            }
            if(!allEqual) {
                break;
            }
        }

        return strs[0].substring(0, pos);
    }

    public static void main(String[] args) {
        LongestCommonPrefix o = new LongestCommonPrefix();
        System.out.println("abc\t" + o.longestCommonPrefix(new String[]{"abcd", "abcadsadfe"}));
        System.out.println("a\t" + o.longestCommonPrefix(new String[]{"aa", "a"}));
    }

}
