package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/divide-two-integers/
// Author : Xin Zhao
// Date   : 2016-02-26

/**********************************************************************************
 *
 * Divide two integers without using multiplication, division and mod operator.
 *
 * If it is overflow, return MAX_INT.
 *
 **********************************************************************************/

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {

        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        boolean negative = false;

        if(dividend < 0) {
            negative = !negative;
        } else {
            dividend = -dividend;
        }

        if(divisor < 0) {
            negative = !negative;
        } else {
            divisor = -divisor;
        }

        int ret = 0;

        int bits = -1;
        for(int i = divisor; i > dividend>>1; i <<= 1) {
            bits++;
        }
        if(bits == -1 && dividend <= divisor) {
            bits = 0;
        }

        while(bits >= 0) {
            int subtractor = divisor << bits;
            while(dividend <= subtractor) {
                dividend -= subtractor;
                ret += 1<<bits;
            }
            bits--;
        }

        return negative?-ret:ret;
    }

    public static void main(String[] args) {
        DivideTwoIntegers o = new DivideTwoIntegers();

        //System.out.println(o.divide(2147483647, 1));
        //System.out.println(o.divide(2147483647, 2));
        //System.out.println(o.divide(2147483647, 233));
        //System.out.println(o.divide(Integer.MIN_VALUE, 2));
        //System.out.println(o.divide(Integer.MIN_VALUE, -3));
        System.out.println(o.divide(1, 1));
        //System.out.println(o.divide(18, 2));
    }
}
