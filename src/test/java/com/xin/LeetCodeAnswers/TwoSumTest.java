package com.xin.LeetCodeAnswers;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSumTest {
    @Test
    public void testBasis() {
        assertArrayEquals(new int[]{1,2}, new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9));
    }
}
