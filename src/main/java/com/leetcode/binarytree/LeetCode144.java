package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 *  给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 *
 *
 */
public class LeetCode144 {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        // 前序遍历(先序遍历)：根节点，左节点，右节点。
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);

        return list;
    }
}
