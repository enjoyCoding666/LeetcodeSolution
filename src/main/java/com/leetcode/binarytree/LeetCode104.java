package com.leetcode.binarytree;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\5\6 0006 23:40
 * @Description:
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its depth = 3.
 *
 */

/**
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
class LeetCode104 {

	public int maxDepth(TreeNode root) {
		if(root==null) {
			return 0;
		}
		//返回左/右子树中的最大深度，再加上根节点。
		return Math.max(maxDepth(root.right),maxDepth(root.left))+1;
	}
}
