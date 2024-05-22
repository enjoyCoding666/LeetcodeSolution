package com.leetcode.bfs;

import com.leetcode.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class LeetCode102 {


    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }
        //将树节点放入队列中
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            //树的每一层的节点数量，就是队列的size
            int size = queue.size();
            List<Integer> list = new ArrayList<>();

            while (size-- > 0) {
                TreeNode treeNode = queue.poll();
                if (treeNode == null) {
                    continue;
                }
                list.add(treeNode.val);
                //把下一层的左/右节点加到队列中
                TreeNode left = treeNode.left;
                if (left != null) {
                    queue.offer(left);
                }
                TreeNode right = treeNode.right;
                if (right != null) {
                    queue.offer(right);
                }
            }

            resultList.add(list);

        }
        return resultList;

    }


}
