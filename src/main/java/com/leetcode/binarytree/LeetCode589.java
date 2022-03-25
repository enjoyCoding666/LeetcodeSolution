package com.leetcode.binarytree;

import com.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class LeetCode589 {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        //将根节点放入栈里面
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        //只要栈不为空，就一直循环
        while (!stack.isEmpty()) {
            //取出栈里的节点
            Node node = stack.pop();
            //将数值放入list中
            list.add(node.val);

            List<Node> childrenList = node.children;
            if (childrenList == null) {
                continue;
            }
            //将子节点全部放入栈里面，由于栈是后进先出，所以后面的子节点先放入
            for (int i = childrenList.size() - 1; i >= 0; i--) {
                stack.push(childrenList.get(i));
            }

        }
        return list;

    }
}
