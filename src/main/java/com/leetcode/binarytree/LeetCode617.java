package com.leetcode.binarytree;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\4\15 0015 0:02
 * @Description:
 */
public class LeetCode617 {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		//设置终止条件
		if (t1 == null && t2 == null) {
			return null;
		}
		//计算节点的值为两棵树对应位置的节点值的和
		int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
		TreeNode treeNode = new TreeNode(val);
		//向下递归
		treeNode.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
		treeNode.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
		return treeNode;
	}


}
