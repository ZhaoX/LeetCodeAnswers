package com.xin.LeetCodeAnswers;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest{
	
	@Test
	public void testAddTwoNumbers()
	{
		AddTwoNumbers.ListNode index;
		
		AddTwoNumbers.ListNode l1 = new AddTwoNumbers.ListNode(2);
		index = l1;
		index.next = new AddTwoNumbers.ListNode(4);
		index = index.next;
		index.next = new AddTwoNumbers.ListNode(3);
		
		AddTwoNumbers.ListNode l2 = new AddTwoNumbers.ListNode(5);
		index = l2;
		index.next = new AddTwoNumbers.ListNode(6);
		index = index.next;
		index.next = new AddTwoNumbers.ListNode(4);
		
		index = AddTwoNumbers.addTwoNumbers(l1, l2);
		assertEquals(7, index.val);
		assertEquals(0, index.next.val);
		assertEquals(8, index.next.next.val);
	}
}
