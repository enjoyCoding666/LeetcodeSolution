package com.leetcode.dfs;

import java.util.List;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\4\17 0017 23:01
 * @Description:
 */
class Node {
	//为方便解答，设置成public，实战不建议
	public int val;
	public List<Node> children;

	public Node() {}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}