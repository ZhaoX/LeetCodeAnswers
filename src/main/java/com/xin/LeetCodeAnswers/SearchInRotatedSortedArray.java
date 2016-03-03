package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/search-in-rotated-sorted-array/
// Author : Xin Zhao
// Date   : 2016-03-03

/**********************************************************************************
 *
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 **********************************************************************************/

public class SearchInRotatedSortedArray {

    public int binSearch(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if(nums[mid] == target) {
                return mid;
            }

            if(nums[mid] < nums[0] == target < nums[0]) {
                if(nums[mid] > target) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if(target >= nums[0]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray o = new SearchInRotatedSortedArray();
        System.out.println(o.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
        System.out.println(o.search(new int[]{0, 1, 2, 4, 5, 6, 7}, 7));
        System.out.println(o.search(new int[]{1, 3}, 3));
        System.out.println(o.search(new int[]{5, 1, 3}, 5));
    }

}
