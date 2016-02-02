package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/container-with-most-water/
// Author : Xin Zhao
// Date   : 2016-02-02

/**********************************************************************************
 *
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container.
 *
 **********************************************************************************/

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int i = 0, j = height.length-1;
        int mostWater = 0;
        while(i < j) {
            int curWater = (j-i) * min(height[i], height[j]);
            mostWater = max(mostWater, curWater);
            if(height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return mostWater;
    }

    private int max(int a, int b) {
        return a>b?a:b;
    }

    private int min(int a, int b) {
        return a<b?a:b;
    }

    public static void main(String[] args) {

    }

}
