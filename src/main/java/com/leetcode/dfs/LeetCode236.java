package com.leetcode.dfs;


/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 *
 */
public class LeetCode236 {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root==null || root==p || root == q) {
            return root;
        }
        //dfs，从根节点的左右子树，分别向下递归。
        //往左子树递归
        TreeNode left= lowestCommonAncestor(root.left, p, q);
        //往右子树递归
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左子树没有值，就返回右子树
        if (left == null) {
            return right;
        }
        //右子树没有值，就返回左子树
        if (right == null) {
            return left;
        }
        //如果左右子树都能找到 p和q，那说明p和q分别在左右子树上。最近公共祖先为此节点
        return root;
    }


}
