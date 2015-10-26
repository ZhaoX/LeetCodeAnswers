package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/move-zeroes/
// Author : Xin Zhao
// Date   : 2015-10-26

import utils.Utils;

/**********************************************************************************
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * For example, given nums  = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 *
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 **********************************************************************************/

public class MoveZeroes {

    public void moveZeroes(int[] nums) {

        for(int i = 0, j = 0; j < nums.length; j++) {
            if(i == j && nums[j] != 0) {
                i++;
                continue;
            }
            if(nums[j] != 0) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
        }

    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();

        int[] nums = new int[]{0, 1, 0, 3, 12};
        mz.moveZeroes(nums);
        Utils.printArray(nums);

        nums = new int[]{1};
        mz.moveZeroes(nums);
        Utils.printArray(nums);
    }

}
