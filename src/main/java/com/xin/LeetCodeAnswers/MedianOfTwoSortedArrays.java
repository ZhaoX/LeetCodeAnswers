package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/median-of-two-sorted-arrays/
// Author : Xin Zhao
// Date   : 2015-10-29

/**********************************************************************************
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * The definition of median:
 * In statistics and probability theory, a median is the number separating the higher half of a data sample, a population, or a probability distribution, from the lower half. The median of a finite list of numbers can be found by arranging all the observations from lowest value to highest value and picking the middle one (e.g., the median of {3, 3, 5, 9, 11} is 5). If there is an even number of observations, then there is no single middle value; the median is then usually defined to be the mean of the two middle values [1] [2] (the median of {3, 5, 7, 9} is (5 + 7) / 2 = 6), which corresponds to interpreting the median as the fully trimmed mid-range.
 **********************************************************************************/

public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] m, int[] n) {
        if(m.length > n.length) {
            return findMedianSortedArrays(n, m);
        }

        return findMedianSortedArrays(m, n, 0, m.length);
    }

    private double findMedianSortedArrays(int[] m, int[] n, int start, int end) {

        //System.out.println("start: " + start + ", end: " + end);

        int i = start + (end-start)/2;
        int j = (m.length + n.length + 1)/2 -i;

        //System.out.println("i: " + i + ", j: " + j);

        int maxLeft, minRight;


        if(i == 0) {
            if(m.length == 0) {
                if(n.length == 0) {
                    return 0;
                }
                if(n.length == 1) {
                    return n[0];
                }
                maxLeft = n[j-1];
                minRight = n[j];
                return makeMedian(m, n, maxLeft, minRight);
            }

            if(n[j-1] <= m[i]) {
                maxLeft  = n[j-1];
                minRight = j==n.length?m[i]:min(m[i], n[j]);
                return makeMedian(m, n, maxLeft, minRight);
            }else {
                return findMedianSortedArrays(m, n, i+1, end);
            }
        }

        if(i == m.length) {
            if(m[i-1] <= n[j]) {
                maxLeft  = j==0?m[i-1]:max(m[i-1], n[j-1]);
                minRight = n[j];
                return makeMedian(m, n, maxLeft, minRight);
            }else {
                return findMedianSortedArrays(m, n, start, i);
            }
        }

        if(m[i-1] <= n[j] && n[j-1] <= m[i]) {
            maxLeft  = max(m[i-1], n[j-1]);
            minRight = min(m[i], n[j]);
            return makeMedian(m, n, maxLeft, minRight);
        }else if(m[i-1] > n[j]) {
            return findMedianSortedArrays(m, n, start, i);
        }else{
            return findMedianSortedArrays(m, n, i+1, end);
        }

    }

    private double makeMedian(int[] m , int[] n, int maxLeft, int minRight) {
        if((m.length + n.length)%2 == 0) {
            return (maxLeft + minRight)/2.0;
        }else {
            return maxLeft;
        }
    }

    private int max(int a, int b) {
        return a>b?a:b;
    }

    private int min(int a, int b) {
        return a<b?a:b;
    }

    public static void main(String[] args) {
        MedianOfTwoSortedArrays m = new MedianOfTwoSortedArrays();

        System.out.println(m.findMedianSortedArrays(new int[]{1, 4, 5, 89}, new int[]{1, 2, 43}));
        System.out.println(m.findMedianSortedArrays(new int[]{1, 4, 5, 89}, new int[]{1, 2, 43, 99}));
        System.out.println(m.findMedianSortedArrays(new int[]{1}, new int[]{1, 2, 43, 99}));
        System.out.println(m.findMedianSortedArrays(new int[]{100}, new int[]{1, 2, 43, 99}));
        System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{1, 2, 43, 99}));
        System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{1}));
        System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{1, 11}));
        System.out.println(m.findMedianSortedArrays(new int[]{}, new int[]{}));
    }
}
