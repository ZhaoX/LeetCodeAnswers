package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/letter-combinations-of-a-phone-number/
// Author : Xin Zhao
// Date   : 2016-02-22

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**********************************************************************************
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * 1      2 abc  3 def
 * 4 ghi  5 jkl  6 mno
 * 7 pqrs 8 tuv  9 wxyz
 *
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * Note:
 * Although the above answer is in lexicographical order, your answer could be in any order you want.
 *
 **********************************************************************************/

public class LetterCombinationsOfAPhoneNumber {

    public List<String> letterCombinations(String digits) {
        String[] mapping = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        LinkedList<String> ret = new LinkedList<String>();

        if(!digits.isEmpty()) {
            ret.add("");
        }

        for(int i = 0; i < digits.length(); i++) {
            int size = ret.size();
            while (size > 0) {
                String curHead = ret.poll();
                String curLetters = mapping[Character.digit(digits.charAt(i), 10)];
                for(int j = 0; j < curLetters.length(); j++) {
                    ret.add(curHead + curLetters.charAt(j));
                }
                size--;
            }
        }

        return ret;
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber o = new LetterCombinationsOfAPhoneNumber();
        System.out.println(o.letterCombinations("23"));
    }


}
