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
 *
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
	private List<Integer> list=new ArrayList<>();

	public int kthSmallest(TreeNode root, int k) {
		if(k<0){
			return 0;
		}
		inOrder(root);
		int[] arr=list.stream().mapToInt(Integer::valueOf).toArray();
		return arr[k-1];

	}


	/**
	 * 中序遍历。
	 * BST 的中序遍历是升序序列
	 *
	 * @param node
	 */
	public void inOrder(TreeNode node){
		if(node==null) {
			return;
		}
		inOrder(node.left);
		list.add(node.val);
		inOrder(node.right);
	}

	/**
	 *  不使用list的成员变量，直接作为参数，在递归中增加元素。
	 *
	 * @param root
	 * @param arr
	 * @return
	 */
	public ArrayList<Integer> inOrderByListParam(TreeNode root, ArrayList<Integer> arr) {
		if (root == null) return arr;
		inOrderByListParam(root.left, arr);
		arr.add(root.val);
		inOrderByListParam(root.right, arr);
		return arr;
	}

}
