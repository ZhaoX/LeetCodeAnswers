package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/merge-k-sorted-lists/
// Author : Xin Zhao
// Date   : 2016-02-25

import java.util.Comparator;
import java.util.PriorityQueue;

/**********************************************************************************
 *
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 **********************************************************************************/

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode p = head;

        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(
                lists.length+1,
                new Comparator<ListNode>() {
                    @Override
                    public int compare(ListNode o1, ListNode o2) {
                        return o1.val - o2.val;
                    }
                }
        );

        for(ListNode node : lists) {
            if(node != null) {
                heap.add(node);
            }
        }

        while(heap.size() > 0) {
            ListNode least = heap.poll();

            p.next = least;
            p = p.next;

            if(least.next != null) {
                heap.add(least.next);
            }
        }

        return head.next;
    }

    public static void main(String[] args) {
        MergeKSortedLists o = new MergeKSortedLists();

        System.out.println(o.mergeKLists(new ListNode[]{}));
    }

}
