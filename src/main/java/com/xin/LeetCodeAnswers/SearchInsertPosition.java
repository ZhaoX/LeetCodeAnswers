package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/search-insert-position/
// Author : Xin Zhao
// Date   : 2016-03-04

/**********************************************************************************
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 *
 **********************************************************************************/

public class SearchInsertPosition {

    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > target) {
                end = mid-1;
            } else {
                start = start+1;
            }
        }

        return start;
    }

    public static void main(String[] args) {
        SearchInsertPosition o = new SearchInsertPosition();

        System.out.println("2\t" + o.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println("1\t" + o.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println("4\t" + o.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println("0\t" + o.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println("0\t" + o.searchInsert(new int[]{1, 3, 5, 6, 7}, 0));
        System.out.println("1\t" + o.searchInsert(new int[]{1, 3, 5, 6, 7}, 2));
    }

}
