package com.leetcode.binarytree;

/**
 * LeetCode101，其实是LeetCode100的延伸。
 * LeetCode100: 两棵树是否为相同的树，
 * LeetCode101: 一棵树是否为对称二叉树。那么只要左右子树对称就可以了。
 *
 *
 */
public class LeetCode101Easy {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        //左右子树是否对称
        return isSym(root.left, root.right);
    }


    public boolean isSym(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        //注意，如果左子树的节点值val，跟右子树的节点值val不一样，那么就不是对称的。
        if (left == null || right == null || left.val != right.val) {
            return false;
        }
        //如果是对称的，
        //那么左子树下一层的左子树，就会等于右子树下一层的的右子树。
        //并且左子树下一层的右子树，也会等于右子树下一层的左子树。
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }

}
