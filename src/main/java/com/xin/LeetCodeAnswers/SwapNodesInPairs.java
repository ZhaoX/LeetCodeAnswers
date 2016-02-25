package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/swap-nodes-in-pairs/
// Author : Xin Zhao
// Date   : 2016-02-25

/**********************************************************************************
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 **********************************************************************************/

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head == null) {
            return null;
        }

        ListNode p = head, q = head.next;
        ListNode ret = q==null?p:q;

        ListNode t = null;

        while(q != null) {
            p.next = q.next;
            q.next = p;

            if(t!=null) {
                t.next = q;
            }
            t = p;

            p = p.next;
            q = p==null?null:p.next;
        }

        return ret;
    }
}
