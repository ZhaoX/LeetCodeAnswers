package com.lenovo.xin.LeetCodeAnswers.AddTwoNumbers;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest{
	
	@Test
	public void testAddTwoNumbers()
	{
		ListNode index;
		
		ListNode l1 = new ListNode(2);
		index = l1;
		index.next = new ListNode(4);
		index = index.next;
		index.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		index = l2;
		index.next = new ListNode(6);
		index = index.next;
		index.next = new ListNode(4);
		
		index = new AddTwoNumbers().addTwoNumbers(l1, l2);
		assertEquals(7, index.val);
		assertEquals(0, index.next.val);
		assertEquals(8, index.next.next.val);
	}
}
