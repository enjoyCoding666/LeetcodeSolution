package com.leetcode.tree;

import java.util.List;

/**
 * @Author: EnjoyCoding
 * @Date: 2020\4\17 0017 23:01
 * @Description:
 */
class Node {
	public int val;
	//为方便解题
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