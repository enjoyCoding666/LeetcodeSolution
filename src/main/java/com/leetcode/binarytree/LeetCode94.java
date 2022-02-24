package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *   先序遍历：根节点，左节点，右节点。
 *   中序遍历：左节点，根节点，右节点。
 *   后序遍历：左节点，右节点，根节点。
 *
 *   本题是中序遍历。
 *
 */
public class LeetCode94 {
    private List<Integer> list = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return list;
        }
        //中序遍历：左节点，根节点，右节点。
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);

        return list;
    }
}
