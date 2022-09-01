package com.leetcode.interview;

import com.leetcode.binarytree.TreeNode;

public class Test {

    public static void main(String[] args) {

    }



    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) +1;
    }


}