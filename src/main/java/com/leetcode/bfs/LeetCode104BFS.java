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
		//这里的队列初始化，可以用链表
		Queue<TreeNode> nodes = new LinkedList<>();
		//队列使用offer和poll不会抛异常
		nodes.offer(root);
		while (!nodes.isEmpty()) {
			//此处有坑，一定要先把每一层的数量记录下来，不然队列的长度发生变化，遍历次数不一样
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
