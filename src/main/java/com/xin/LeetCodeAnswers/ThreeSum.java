package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/3sum/
// Author : Xin Zhao
// Date   : 2015-03-11

import java.util.*;

/**********************************************************************************
 *
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 * The solution set must not contain duplicate triplets.
 *
 *     For example, given array S = {-1 0 1 2 -1 -4},
 *
 *     A solution set is:
 *     (-1, 0, 1)
 *     (-1, -1, 2)
 *
 *
 **********************************************************************************/

public class ThreeSum {
    /**
     * Quadratic algorithm
     * Reference: http://en.wikipedia.org/wiki/3SUM
     */
    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        int n = num.length;

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if(n < 3) {
            return result;
        }

        for(int i=0; i<=n-3; i++) {
            if(i>0 && num[i]==num[i-1]) {
                continue;
            }
            int a = num[i];
            int start = i+1;
            int end = n -1;
            while(start < end) {
                int b = num[start];
                int c = num[end];
                if(a + b + c == 0) {
                    result.add(Arrays.asList(a, b, c));
                    while(start < n-1 && num[start] == num[start+1]) {
                        start++;
                    }
                    start ++;
                    while(end >0 && num[end] == num[end-1]) {
                        end--;
                    }
                    end--;
                    System.out.println(a + ", " + b + ", " + c);
                } else if(a + b +c > 0) {
                    while(end >0 && num[end] == num[end-1]) {
                        end--;
                    }
                    end--;
                } else {
                    while(start < n-1 && num[start] == num[start+1]) {
                        start++;
                    }
                    start++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        //new ThreeSum().threeSum(new int[]{0, 0, 0});
        //new ThreeSum().threeSum(new int[]{-9,14,-7,-8,9,1,-10,-8,13,12,6,9,3,-3,-15,-15,1,8,-7,-4,-6,8,2,-10,8,11,-15,3,0,-11,-1,-1,10,0,6,5,-14,3,12,-15,-7,-5,9,11,-1,1,3,-15,-5,11,-12,-4,-4,-2,-6,-10,-6,-6,0,2,-9,14,-14,-14,-9,-1,-2,-7,-12,-13,-15,-4,-3,1,14,3,-12,3,3,-10,-9,-1,-7,3,12,-6,0,13,4,-15,0,2,6,1,3,13,8,-13,13,11,11,13,14,-6});
        //new ThreeSum().threeSum(new int[]{7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6});
        new ThreeSum().threeSum(new int[]{});
    }
}
