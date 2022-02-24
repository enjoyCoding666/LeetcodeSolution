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
		//当前节点的值相等，就继续往下递归，不断对比
		if(p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}
}
