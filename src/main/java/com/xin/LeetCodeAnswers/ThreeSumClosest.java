package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/3sum-closest/
// Author : Xin Zhao
// Date   : 2015-03-11

import java.util.Arrays;

/**********************************************************************************
 *
 * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
 *
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 *
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 *
 **********************************************************************************/

public class ThreeSumClosest {

    public int threeSumClosest(int[] num, int target) {
        Arrays.sort(num);

        int n = num.length;
        if(n < 3) {
            int sum = 0;
            for(int i : num) {
                sum+=i;
            }
            return sum;
        }

        int closest = 0;
        for(int i=0; i<3; i++){
            closest+=num[i];
        }

        for(int i=0; i<=n-3; i++) {
            int a = num[i];
            int start = i+1;
            int end = n-1;
            while(start < end) {
                int b = num[start];
                int c = num[end];

                if(a+b+c==target) {
                    return target;
                } else if(a+b+c > target) {
                    end--;
                } else {
                    start ++;
                }

                if(Math.abs(a + b + c - target) < Math.abs(closest-target)) {
                    closest = a + b + c;
                }
            }
        }

        return closest;
    }

}
