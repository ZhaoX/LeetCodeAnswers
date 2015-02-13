package com.xin.LeetCodeAnswers;

// Source : https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
// Author : Xin Zhao
// Date   : 2015-02-13

/**********************************************************************************
 *
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 *
 * Note:
 * You may only use constant extra space.
 *
 * For example,
 * Given the following binary tree,
 *
 *          1
 *        /  \
 *       2    3
 *      / \    \
 *     4   5    7
 *
 * After calling your function, the tree should look like:
 *
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \    \
 *     4-> 5 -> 7 -> NULL
 *
 *
 **********************************************************************************/

public class PopulatingNextRightPointersInEachNode2 {

    public void connect(TreeLinkNode root) {
        if(root==null) {
            return;
        }

        if(root.left != null && root.right !=null) {
            root.left.next = root.right;
        }

        if(root.next!=null) {
            TreeLinkNode left, right=null;
            left = root.right==null?root.left:root.right;
            for(TreeLinkNode p=root.next; p!=null; p=p.next) {
                if(p.left!=null) {
                    right = p.left;
                    break;
                }
                if(p.right!=null) {
                    right = p.right;
                    break;
                }
            }
            if(left!=null) {
                left.next = right;
            }
        }

        connect(root.right);
        connect(root.left);
    }

    //test case ：{1,2,3,4,5,#,7}
    //test case ：{3,9,20,#,#,15,7}
    //test case ：{1,2,3,4,5,#,6,7,#,#,#,#,8}
    public static TreeLinkNode createTree(){
        //TreeLinkNode root = new TreeLinkNode(1);
        //root.left = new TreeLinkNode(2);
        //root.right = new TreeLinkNode(3);
        //root.left.left = new TreeLinkNode(4);
        //root.left.right = new TreeLinkNode(5);
        //root.right.right = new TreeLinkNode(7);

        TreeLinkNode root = new TreeLinkNode(3);
        root.left = new TreeLinkNode(9);
        root.right = new TreeLinkNode(20);
        root.right.left = new TreeLinkNode(15);
        root.right.right = new TreeLinkNode(7);

        return root;
    }

    // -1 means no val
    public static TreeLinkNode createTree(int[] a){
        if(a.length<1 || a[0]==-1) {
            return null;
        }

        TreeLinkNode[] treeLinkNodes = new TreeLinkNode[a.length+1];

        for(int i=0; i<a.length; i++) {
            if(a[i]!=-1) {
                treeLinkNodes[i+1] = new TreeLinkNode(a[i]);
            }else{
                treeLinkNodes[i+1] = null;
            }
        }

        int middle = a.length/2;
        for(int i=0; i<=middle; i++) {
            if(treeLinkNodes[i]!=null) {
                treeLinkNodes[i].left = treeLinkNodes[2*i];
                if(2*i+1 <= a.length) {
                    treeLinkNodes[i].right = treeLinkNodes[2*i+1];
                }
            }
        }

        return treeLinkNodes[1];
    }

    public static void printTree(TreeLinkNode root) {

        if(root==null) {
            return;
        }

        int leftVal =  root.left==null?-1:root.left.val;
        int rightVal = root.right==null?-1:root.right.val;
        int nextVal = root.next==null?-1:root.next.val;

        System.out.println("val: " + root.val + "-----left: " + leftVal + "-----right: " + rightVal + "-----next: " + nextVal);

        printTree(root.left);
        printTree(root.right);

    }


    public static void main(String[] args) {
        TreeLinkNode root = PopulatingNextRightPointersInEachNode2.createTree(new int[]{1,2,3,4,5,-1,7});
        PopulatingNextRightPointersInEachNode2.printTree(root);

        System.out.println("************************************");

        new PopulatingNextRightPointersInEachNode2().connect(root);
        PopulatingNextRightPointersInEachNode2.printTree(root);
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
