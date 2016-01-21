package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/longest-palindromic-substring/
// Author : Xin Zhao
// Date   : 2016-01-21

import java.security.acl.LastOwnerException;

/**********************************************************************************
 *
 * Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 *
 **********************************************************************************/

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        if(s.isEmpty()) {
            return null;
        }
        if(s.length() == 1) {
            return s;
        }

        int start = 0, len = 0;

        for(int i = 0; i < s.length();) {
            if((s.length()-i) < len/2) {
                break;
            }
            int p = i, q = i;
            while(q < s.length()-1 && s.charAt(q+1) == s.charAt(i)) {
                q++;
            }
            i = q+1;
            while(p > 0 && q < s.length()-1 && s.charAt(p-1) == s.charAt(q+1)) {
                p--;
                q++;
            }
            int newLen = q - p + 1;
            if(newLen > len) {
                start = p;
                len = newLen;
            }
        }
        return s.substring(start, start + len);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring o = new LongestPalindromicSubstring();

        System.out.println(o.longestPalindrome("121"));
        System.out.println(o.longestPalindrome("1221"));
        System.out.println(o.longestPalindrome(""));
        System.out.println(o.longestPalindrome("11111"));
        System.out.println(o.longestPalindrome("ivilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
