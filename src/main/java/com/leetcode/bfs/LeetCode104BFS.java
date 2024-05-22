package com.leetcode.bfs;

import com.leetcode.dfs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\5\6 0006 23:54
 * @Description:
 */
public class LeetCode104BFS {
	public int maxDepth(TreeNode root) {
		if (root == null){
			return 0;
		}
		int depth = 0;
		Queue<TreeNode> nodes = new LinkedList<>();
		//队列使用offer和poll不会抛异常
		nodes.offer(root);
		while (!nodes.isEmpty()) {
			int size = nodes.size();
			//遍历一次，深度就加一
			depth++;
			//遍历队列中的数据
			while (size-- > 0) {
				//取出队列中的树节点
				TreeNode node = nodes.poll();

				if (node!=null && node.left != null){
					nodes.offer(node.left);
				}
				if (node!=null && node.right != null){
					nodes.offer(node.right);
				}
			}
		}
		return depth;
	}
}
