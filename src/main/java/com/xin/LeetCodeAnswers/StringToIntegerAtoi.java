package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/string-to-integer-atoi/
// Author : Xin Zhao
// Date   : 2015-03-09

/**********************************************************************************
 *
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 * Notes:
 * It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.
 *
 * spoilers alert... click to show requirements for atoi.
 *
 * Requirements for atoi:
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 *
 **********************************************************************************/

public class StringToIntegerAtoi {

    public int atoi(String str) {
        String str1 = str.trim();

        if(str1.isEmpty()) {
            return 0;
        }

        int result = 0;
        boolean negative = false;
        int limit = -Integer.MAX_VALUE;

        int i = 0;
        char firstChar =  str1.charAt(0);

        if(firstChar == '-') {
            negative = true;
            i++;
            limit = Integer.MIN_VALUE;
        }

        if(firstChar== '+') {
            i++;
        }

        if(i >= str1.length() || !Character.isDigit(str1.charAt(i))) {
            return 0;
        }

        int multmin = limit/10;
        for(; i<str1.length(); i++) {
            // Accumulating negatively avoids surprises near MAX_VALUE
            int digit = Character.digit(str1.charAt(i), 10);

            if(digit < 0) {
                break;
            }

            if(result < multmin) {
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }

            result*=10;

            if(result < limit + digit) {
                return negative?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }

            result-=digit;

        }

        return negative?result:-result;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("123"));
        System.out.println("#" + new String("    ").trim() + "#");
        System.out.println(new StringToIntegerAtoi().atoi("123"));
        System.out.println(new StringToIntegerAtoi().atoi("-123"));
        System.out.println(new StringToIntegerAtoi().atoi("+123"));
        System.out.println(new StringToIntegerAtoi().atoi("-123x"));
        System.out.println(new StringToIntegerAtoi().atoi("2147483648"));
    }

}
