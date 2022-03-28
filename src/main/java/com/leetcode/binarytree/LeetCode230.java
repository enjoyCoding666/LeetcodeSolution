package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\6\23 0023 23:37
 * @Description:
 *
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 *
 * 	 给定一个二叉搜索树的根节点 root ，和一个整数 k ，
 * 	 请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 *
 * Example 1:
 *
 * Input: root = [3,1,4,null,2], k = 1
 *    3
 *   / \
 *  1   4
 *   \
 *    2
 * Output: 1
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 *        5
 *       / \
 *      3   6
 *     / \
 *    2   4
 *   /
 *  1
 * Output: 3
 *
 */
public class LeetCode230 {
	private List<Integer> list = new ArrayList<>();

	public int kthSmallest(TreeNode root, int k) {

		//二叉搜索树，左节点<根节点<右节点，
		//中序遍历：左节点，根节点，右节点。
		// 二叉搜索树的中序遍历，得到的是有序数组

		if (k < 1) {
			return 0;
		}
		List<Integer> list = travelTree(root);
		return list.get(k - 1);


	}


	public List<Integer> travelTree(TreeNode root) {
		if (root == null) {
			return list;
		}
		//中序遍历：左节点，根节点，右节点。
		travelTree(root.left);
		list.add(root.val);
		travelTree(root.right);

		return list;
	}

}
