package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// Author : Xin Zhao
// Date   : 2016-02-23

/**********************************************************************************
 *
 * Given a linked list, remove the nth node from the end of list and return its head.
 *
 * For example,
 *
 *    Given linked list: 1->2->3->4->5, and n = 2.
 *
 *    After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 *
 **********************************************************************************/

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode p = head, q = head;

        while(n-- > 0) {
            q = q.next;
        }

        if(q == null) {
            return p.next;
        }

        while(q.next != null) {
            q = q.next;
            p = p.next;
        }

        p.next = p.next.next;

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}