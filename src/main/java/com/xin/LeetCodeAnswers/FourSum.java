package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/4sum/
// Author : Xin Zhao
// Date   : 2015-03-11

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**********************************************************************************
 *
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 *
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 *
 *     For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 *     A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 *
 *
 **********************************************************************************/

public class FourSum {

    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        int n = num.length;

        List<List<Integer>> result = new LinkedList<List<Integer>>();

        if(n < 4) {
            return result;
        }

        for (int j=0; j<=n-4; j++) {
            if(j>0 && num[j]==num[j-1]) {
                continue;
            }
            int d = num[j];

            for(int i=j+1; i<=n-3; i++) {
                if(i>j+1 && num[i]==num[i-1]) {
                    continue;
                }
                int a = num[i];
                int start = i+1;
                int end = n -1;
                while(start < end) {
                    int b = num[start];
                    int c = num[end];
                    if(a + b + c == target - d) {
                        result.add(Arrays.asList(d, a, b, c));
                        while(start < n-1 && num[start] == num[start+1]) {
                            start++;
                        }
                        start ++;
                        while(end >0 && num[end] == num[end-1]) {
                            end--;
                        }
                        end--;
                        System.out.println(d + ", " + a + ", " + b + ", " + c);
                    } else if(a + b +c > target - d) {
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

        }

        return result;
    }


    public static void main(String[] args) {
        new FourSum().fourSum(new int[]{1,0,-1,0,-2,2}, 0);
    }

}
