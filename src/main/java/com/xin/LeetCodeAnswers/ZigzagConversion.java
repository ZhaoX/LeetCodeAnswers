package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/zigzag-conversion/
// Author : Xin Zhao
// Date   : 2016-01-22

/**********************************************************************************
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string text, int nRows);
 *
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 *
 **********************************************************************************/

public class ZigzagConversion {

    public String convert(String s, int numRows) {
        if(s.isEmpty()) {
            return "";
        }
        if(s.length() <= numRows) {
            return s;
        }
        if(numRows == 1) {
            return s;
        }

        StringBuilder sb = new StringBuilder(s.length());

        for(int i = 0; i < numRows; i++) {
            int j = i;
            while (j < s.length()) {
                sb.append(s.charAt(j));
                int nextJ = j + numRows + (numRows - 2);
                int mid = nextJ - (i + 1) - (i - 1);
                if(mid < s.length() && mid > j && mid < nextJ) {
                    sb.append(s.charAt(mid));
                }
                j = nextJ;
            }
        }

        return sb.toString();
    }


    /**
     * First solution is wrong because I misunderstanding what zigzag string is.
     */
    public String convert1(String s, int numRows) {
        if(s.isEmpty()) {
            return "";
        }
        if(s.length() <= numRows) {
            return s;
        }

        StringBuilder sb = new StringBuilder(s.length());

        for(int i = 0; i < numRows; i++) {
            if(i%2 == 0) {
                int j = i;
                while(j < s.length()) {
                    sb.append(s.charAt(j));
                    j += (numRows + numRows/2);
                }
            }else {
                int j = i;
                while(j < s.length()) {
                    sb.append(s.charAt(j));

                    int next = j + (numRows - (i + 1)) + numRows/2;
                    if(next < s.length()) {
                        sb.append(s.charAt(next));
                    }

                    j += (numRows + numRows/2);
                }

            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        ZigzagConversion o = new ZigzagConversion();

        //System.out.println(o.convert("PAYPALISHIRING", 3));
        //System.out.println(o.convert("ABC", 2));
        System.out.println(o.convert("AB", 1));

    }
}
