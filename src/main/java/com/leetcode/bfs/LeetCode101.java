package com.leetcode.bfs;

import com.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\6\16 0016 22:49
 * @Description: Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * <p>
 * }
 * }
 */
public class LeetCode101 {

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			//运用了BFS，size是每一层的节点数量
			int size = queue.size();
			List<TreeNode> treeNodeList = new ArrayList<>();

			for (int i = 0; i < size; i++) {
				//取出当前这一层的队列中的节点
				root = queue.poll();
				//将下一层的节点，都添加到队列里面
				//添加到List里，方便比较是否对称
				if (root != null && root.left != null) {
					queue.offer(root.left);
					treeNodeList.add(root.left);
				}else{
					treeNodeList.add(null);
				}
				if (root != null && root.right != null) {
					queue.offer(root.right);
					treeNodeList.add(root.right);
				}else{
					treeNodeList.add(null);
				}
			}
			int length = treeNodeList.size();
			for (int i = 0; i < length / 2; i++) {
				TreeNode node1=treeNodeList.get(length - 1 - i);
				TreeNode node2=treeNodeList.get(i);
				if(node1==null && node2==null){
					continue;
				}
				//其中一个为null，则是不对称的
				if(node1==null || node2==null){
					return false;
				}
				//数值不相等，也是不对称的
				if (node1.val != node2.val) {
					return false;
				}
			}
		}
		return true;
	}
}

