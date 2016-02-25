package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/remove-element/
// Author : Xin Zhao
// Date   : 2016-02-25

/**********************************************************************************
 *
 * Given an array and a value, remove all instances of that value in place and return the new length.
 *
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 **********************************************************************************/

public class RemoveElement {

    public int removeElement(int[] nums, int val) {

        int i = -1, j = nums.length-1 ;
        while(i < j) {
            if(nums[i+1] == val) {
                nums[i+1] = nums[j];
                j--;
            } else {
                i++;
            }
        }

        return i + 1;
    }

}
