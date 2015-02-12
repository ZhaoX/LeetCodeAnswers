package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/sort-list/
// Author : Xin Zhao
// Date   : 2015-02-12

import java.util.List;

/**********************************************************************************
 *
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 **********************************************************************************/

public class SortList {

    public ListNode sortList(ListNode head) {
        int len = 0;
        ListNode p = head;
        while (p!=null) {
            len++;
            p = p.next;
        }

        return mergeSortList(head, len);
    }

    private ListNode mergeSortList(ListNode head, int len) {
        if(len <= 1) {
            return head;
        }
        int leftLen = len/2;
        int rightLen = len - leftLen;

        //find middle pointer
        ListNode middle = head;
        for(int i=0; i<leftLen-1; i++) {
            middle = middle.next;
        }
        ListNode tmp = middle.next;
        middle.next = null;
        middle = tmp;

        //sort two part list
        ListNode leftHead = mergeSortList(head, leftLen);
        ListNode rightHead = mergeSortList(middle, rightLen);

        //merge two sorted lists
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(leftHead!=null && rightHead!=null) {
            if(leftHead.val > rightHead.val) {
                p.next = rightHead;
                rightHead = rightHead.next;
            } else {
                p.next = leftHead;
                leftHead = leftHead.next;
            }
            p = p.next;
        }

        if(leftHead!=null) {
            p.next = leftHead;
        } else {
            p.next = rightHead;
        }

        return dummy.next;
    }

    public static ListNode createList(int[] a) {
        ListNode head=null, p=null;
        for(int i : a) {
            if(head==null){
                head = new ListNode(i);
                p = head;
            } else {
                p.next = new ListNode(i);
                p = p.next;
            }
        }
        return head;
    }

    public static void printList(ListNode head) {
        while(head!=null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val =x;
            next = null;
        }
    }

    public static void main(String[] args) {

        SortList.printList(SortList.createList(new int[]{2,1,3,4,53,3,2}));
        SortList.printList(new SortList().sortList(SortList.createList(new int[]{2,1,3,4,53,3,2})));

        SortList.printList(SortList.createList(new int[]{2}));
        SortList.printList(new SortList().sortList(SortList.createList(new int[]{2})));

    }
}
