package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/reverse-words-in-a-string/
// Author : Xin Zhao
// Date   : 2015-02-11

/**********************************************************************************
 *
 * Given an input string, reverse the string word by word.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * click to show clarification.
 *
 * Clarification:
 *
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 *
 *
 **********************************************************************************/

public class ReverseWordsInAString {
	
    public static String reverseWords(String s) {
    	if (s==null || s.length()==0){
            return "";
        }
        String[] words = s.trim().split("\\s+");	
        int wordCount = words.length; 
        StringBuilder sb = new StringBuilder();
        for(int i=wordCount-1; i>0; i--){
        	sb.append(words[i]+" ");
        }
        if(wordCount > 0){
        	sb.append(words[0]);
        }
        return sb.toString();        
    }
}