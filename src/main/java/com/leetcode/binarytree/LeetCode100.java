package com.leetcode.binarytree;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\5\12 0012 23:50
 * @Description:
 */
public class LeetCode100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if( p==null && q==null ){
			return true;
		}
		if( p==null || q==null ) {
			return false;
		}
		//两棵二叉树的节点值相等，并且左子树相等，右子树也同时相同，这两个节点就视为相等。
		//继续往下递归，不断对比
		if(p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}
}
