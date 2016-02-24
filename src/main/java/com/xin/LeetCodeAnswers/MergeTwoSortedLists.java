package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/merge-two-sorted-lists/
// Author : Xin Zhao
// Date   : 2016-02-24

/**********************************************************************************
 *
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 *
 **********************************************************************************/

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        ListNode p = head;

        while(l1 != null && l2 != null) {

            if(l1.val < l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }

            p = p.next;
        }

        if(l1 != null) {
            p.next = l1;
        }

        if(l2 != null) {
            p.next = l2;
        }

        return head==null?null:head.next;
    }
}
