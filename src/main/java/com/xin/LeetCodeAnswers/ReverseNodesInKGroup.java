package com.xin.LeetCodeAnswers;

// Source : https://leetcode.com/problems/reverse-nodes-in-k-group/
// Author : Xin Zhao
// Date   : 2016-02-25

/**********************************************************************************
 *
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 *
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 **********************************************************************************/

public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || k == 0 || head == null) {
            return head;
        }

        ListNode lastTail = null, ret = head;

        ListNode[] points = new ListNode[k];

        while(true) {
            int leftLen = 0;
            for(; leftLen < k; leftLen++) {
                if(head == null) {
                    break;
                }
                points[leftLen] = head;
                head = head.next;
            }

            if(leftLen < k) {
                break;
            }

            points[0].next = points[k-1].next;
            for(int i = k-1; i > 0; i--) {
                points[i].next = points[i-1];
            }

            if(lastTail == null) {
                ret = points[k-1];
            } else {
                lastTail.next = points[k-1];
            }

            lastTail = points[0];

        }

        return ret;
    }

    public ListNode reverseKGroup1(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
