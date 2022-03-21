package com.leetcode.binarytree;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\4\15 0015 0:03
 * @Description:
 */
public class TreeNode {

    int val;
    //为方便解答，设置成public，实战不建议
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
}