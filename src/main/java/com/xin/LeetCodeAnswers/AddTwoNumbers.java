package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/add-two-numbers/
// Author : Xin Zhao
// Date   : 2015-02-11

/**********************************************************************************
 *
 * You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 *
 **********************************************************************************/

public class AddTwoNumbers {
	
    public static AddTwoNumbers.ListNode addTwoNumbers(AddTwoNumbers.ListNode l1, AddTwoNumbers.ListNode l2) {
    	
    	AddTwoNumbers.ListNode res = null;
    	AddTwoNumbers.ListNode tail = null;
    	int carrayNum = 0;
    	
    	while(l1!=null && l2!=null){
    		AddTwoNumbers.ListNode curNode;
    		int curVal = l1.val + l2.val + carrayNum;
    		if(curVal >= 10){
                curNode = new AddTwoNumbers.ListNode(curVal-10);
                carrayNum = 1;
    		}else{
    			curNode = new AddTwoNumbers.ListNode(curVal);
    			carrayNum =0;
    		}
    		if(res==null){
    			res = curNode;
    			tail = curNode;
    		}else{
    			tail.next = curNode;
    			tail = tail.next;
    		}
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	
    	AddTwoNumbers.ListNode longL = null;
    	if(l1==null){
    		if(l2!=null){
    		    longL = l2;	
    		}
    	}else{
    		longL = l1;
    	}
    	
    	while(carrayNum==1 && longL!=null){
    	    AddTwoNumbers.ListNode curNode;
    	    int curVal = longL.val + carrayNum;
    		if(curVal >= 10){
    		    curNode = new AddTwoNumbers.ListNode(curVal-10);
    		    carrayNum = 1;	
    		}else{
    			curNode = new AddTwoNumbers.ListNode(curVal);
    		    carrayNum = 0;	
    		}
    		tail.next = curNode;
		    tail = tail.next;
		    longL = longL.next;
    	}
    	
    	if(longL!=null){
    	    tail.next = longL;	
    	}else if(carrayNum==1){
    		tail.next = new AddTwoNumbers.ListNode(1);
    	}
		
		return res;
    }

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}

