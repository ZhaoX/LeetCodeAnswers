package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
// Author : Xin Zhao
// Date   : 2015-02-13

/**********************************************************************************
 *
 * Given a binary tree
 *
 *     struct TreeLinkNode {
 *       TreeLinkNode *left;
 *       TreeLinkNode *right;
 *       TreeLinkNode *next;
 *     }
 *
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 *
 * For example,
 * Given the following perfect binary tree,
 *
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 *
 * After calling your function, the tree should look like:
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 *
 *
 **********************************************************************************/

public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        if(root==null)
           return;

        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;

        connect(left);
        connect(right);

        while(left != null && right !=null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }

    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) {
            val = x;
            left = right = next = null;
        }
    }

}
