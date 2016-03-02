package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/next-permutation/
// Author : Xin Zhao
// Date   : 2016-03-01

import utils.Utils;

/**********************************************************************************
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 *
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place, do not allocate extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 **********************************************************************************/

// Reference : https://en.wikipedia.org/wiki/Permutation

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if(nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        for(; i >= 0; i--) {
            if(nums[i+1] > nums[i]) {
                break;
            }
        }

        if(i == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }

        for(int j = nums.length-1; j > i; j--) {
            if(nums[j] > nums[i]) {
                swap(nums, i, j);
                break;
            }
        }

        reverse(nums, i+1, nums.length-1);

    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private void reverse(int[] a, int i, int j) {
        while(i < j) {
            swap(a, i, j);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        NextPermutation o = new NextPermutation();

        int [] a = new int[]{1, 2, 3};
        o.nextPermutation(a);
        Utils.printArray(a);

        int [] a1 = new int[]{2, 3, 1};
        o.nextPermutation(a1);
        Utils.printArray(a1);
    }
}
