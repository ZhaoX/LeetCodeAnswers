package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/reverse-integer/
// Author : Xin Zhao
// Date   : 2016-01-22

/**********************************************************************************
 *
 * Reverse digits of an integer.
 *
 * Example1: x =  123, return  321
 * Example2: x = -123, return -321
 *
 * Have you thought about this?
 *
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 *
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 *
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 *
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * Update (2014-11-10):
 * Test cases had been added to test the overflow behavior.
 *
 **********************************************************************************/

public class ReverseInteger {

    public int reverse(int x) {
        boolean negative = true;
        int limit = Integer.MIN_VALUE;
        if(x > 0) {
            negative = false;
            x = -x;
            limit = -Integer.MAX_VALUE;
        }

        int ret = 0;

        while(x != 0 && x%10 == 0) {
            x/=10;
        }

        while(x != 0) {
            int curVal = x % 10;

            if(ret < limit/10) {
                return 0;
            }

            if(ret*10 < limit-curVal) {
                return 0;
            }

            ret = ret*10 + curVal;

            x/=10;
        }

        return negative?ret:-ret;
    }

    public static void main(String[] args) {
        ReverseInteger o = new ReverseInteger();
        System.out.println(o.reverse(1230));
        System.out.println(o.reverse(-1230));
        System.out.println(o.reverse(-123));
        System.out.println(o.reverse(0));
    }

}
