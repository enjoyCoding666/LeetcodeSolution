package com.leetcode.binarytree;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\5\11 0011 22:43
 * @Description:

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
 */
class LeetCode226 {
	public TreeNode invertTree(TreeNode root) {
		if(root==null) {
			return null;
		}
		TreeNode temp=root.left;
		root.left=root.right;
		root.right=temp;
		invertTree(root.left);
		invertTree(root.right);
		return root;

	}
}