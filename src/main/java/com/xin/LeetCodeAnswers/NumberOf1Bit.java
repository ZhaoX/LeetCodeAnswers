package com.xin.LeetCodeAnswers;

public class NumberOf1Bit {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int count = 0;
    	while(n != 0) {
    		count++;
    		n &= n-1;
    	}
    	return count;
    }
    
    public int hammingWeight1(int n) {
    	int count = 0;
    	while(n != 0) {
    		count+=(n&1);
    		n>>>=1;
    	}
    	return count;
    }
    
    public static void main(String[] args) {
    	System.out.println(new NumberOf1Bit().hammingWeight(3));
    	System.out.println(new NumberOf1Bit().hammingWeight(Integer.MIN_VALUE));
    	System.out.println(new NumberOf1Bit().hammingWeight1(Integer.MIN_VALUE));
    }
}
