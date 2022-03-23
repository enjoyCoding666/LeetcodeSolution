package com.leetcode.binarytree;


/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，
 * 请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 *
 * 二叉搜索树是一个有序树。
 *
 * 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
 * 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
 * 它的左、右子树也分别为二叉排序树
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 *
 */
public class LeetCode108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null) {
            return null;
        }
        return buildTree(nums, 0, nums.length - 1);
    }


    public TreeNode buildTree(int[] nums , int left, int right) {
        if (nums == null) {
            return null;
        }
        //找出有序数组中间的值
        int middle = left + (right - left) / 2;
        //开始构建树
        //设置根节点的值
        TreeNode treeNode = new TreeNode(nums[middle]);
        //设置左节点
        treeNode.left = buildTree(nums, left, middle - 1);
        //设置右节点
        treeNode.right = buildTree(nums, middle + 1, right);

        return treeNode;
    }

}
