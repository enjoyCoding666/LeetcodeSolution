package com.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 *
 *  给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 *  中序遍历：左节点，根节点，右节点。
 *
 *  处理二叉树，除了可以用递归法，还可以用迭代法。
 *
 */
public class LeetCode94Iterator {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        Stack<TreeNode> stk = new Stack<>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                //不断循环，把最左边的所有节点(包括根节点)，都放入栈中
                //比如二叉树[1,2,3,4,5,6,7]，每一层依次为1, 23,4567
                //会依次把最左边的1,2,4放入栈中。
                stk.push(root);
                root = root.left;
            }
            //具体的图解，参考：
            //https://leetcode-cn.com/problems/binary-tree-inorder-traversal/solution/er-cha-shu-de-zhong-xu-bian-li-by-leetcode-solutio/
            //4是树的最底层，最后进入栈，是在栈的最上面的。
            //因此取出4，将4放入list中，由于4没有右子树，继续循环，
            //取出2,将2放入list中，由于2的右子树是5，接着5会进入栈中，依次类推。
            root = stk.pop();
            resultList.add(root.val);
            root = root.right;
        }
        return resultList;
    }

}
