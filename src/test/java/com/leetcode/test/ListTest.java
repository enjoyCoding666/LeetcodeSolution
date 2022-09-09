package com.leetcode.test;

import com.leetcode.tree.Node;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        List<Node> childrenList = root.children;
        for (Node children: childrenList) {
            preorder(children);
        }
        return list;
    }

}
