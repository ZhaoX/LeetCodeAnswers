package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/palindrome-number/
// Author : Xin Zhao
// Date   : 2016-01-22

/**********************************************************************************
 *
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 * click to show spoilers.
 *
 * Some hints:
 *
 * Could negative integers be palindromes? (ie, -1)
 *
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 *
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 *
 * There is a more generic way of solving this problem.
 *
 **********************************************************************************/

public class PalindromeNumber {

    public boolean isPalindrome1(int x) {
        if(x < 0) {
            return false;
        }

        int mask = 1;
        int divisor = x/10;

        while(divisor != 0){
            mask *= 10;
            divisor /= 10;

        }

        while(mask >= 10) {
            int h = (x/mask)%10, l = x%10;
            System.out.println("x: " + x + " mask: " + mask + " h: " + h + " l: " + l);
            if(h != l) {
                break;
            }
            x /= 10;
            mask /= 100;
        }

        if(mask < 10) {
            return true;
        }

        return false;
    }

    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }

        if(x != 0 && x%10 == 0) {
            return false;
        }

        int rev = 0, i = x;

        while(i > 0) {
            rev = rev * 10 + i%10;
            i /= 10;
        }

        if(rev == x) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        PalindromeNumber o = new PalindromeNumber();

        System.out.println(o.isPalindrome(323));
        System.out.println(o.isPalindrome(11));
        System.out.println(o.isPalindrome(10));
        System.out.println(o.isPalindrome(1000021));
    }
}
