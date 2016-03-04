package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/search-for-a-range/
// Author : Xin Zhao
// Date   : 2016-03-04

import utils.Utils;

/**********************************************************************************
 *
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 *
 **********************************************************************************/

public class SearchForARange {

    public int[] searchRange0(int[] nums, int target) {
        int[] pos = new int[]{-1, -1};

        int start = 0, end = nums.length-1;

        while(start <= end) {
            int mid = start + (end-start)/2;

            if(nums[mid] == target) {
                for(int i = mid-1; i >= -1; i--) {
                    if(i == -1 || nums[i] != target) {
                        pos[0] = i+1;
                        break;
                    }
                }
                for(int i = mid+1; i <= nums.length; i++) {
                    if(i == nums.length || nums[i] != target) {
                        pos[1] = i-1;
                        break;
                    }
                }
            }

            if(nums[mid] > target) {
                end = mid -1;
            } else {
                start = mid + 1;
            }
        }

        return pos;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] pos = new int[]{-1, -1};

        int start = 0, end = nums.length-1;

        while(start < end) {
            int mid = start + (end-start)/2;

            if(nums[mid] < target) {
                start = mid + 1;
            } else {
                end = nums[mid]>target?mid-1:mid;
            }
        }

        if(nums[start] != target) {
            return pos;
        }

        pos[0] = start;
        end = nums.length-1;

        while(start < end-1) {
            int mid = start + (end-start)/2;

            if(nums[mid] > target) {
                end = mid -1;
            } else {
                start = mid;
            }
        }

        pos[1] = nums[end]==target?end:start;

        return pos;
    }

    public static void main(String[] args) {
        SearchForARange o = new SearchForARange();
        Utils.printArray(o.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }

}
