package com.leetcode.bfs;

import com.leetcode.binarytree.TreeNode;

import java.util.*;

public class LeetCode199 {


    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> rightValueMap = new HashMap<>();
        int maxDepth = -1;

        //队列是采用 LinkedList 初始化的。
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);

        //每一层的深度
        Queue<Integer> depthQueue = new LinkedList<>();
        depthQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            // remove 返回了 node.
            TreeNode node = nodeQueue.remove();
            int depth = depthQueue.remove();

            if (node != null) {
                //二叉树的最大深度
                maxDepth = Math.max(maxDepth, depth);
                //不断 put， 最后一个 put进去的就是这一层的最右边一个元素
                rightValueMap.put(depth, node.val);
                //添加左右节点
                nodeQueue.add(node.left);
                nodeQueue.add(node.right);
                //添加左右节点的深度
                depthQueue.add(depth + 1);
                depthQueue.add(depth + 1);


            }

        }

        List<Integer> rightView = new ArrayList<>();
        for (int depth = 0; depth <= maxDepth; depth++) {
            //获取每一层的最右边元素
            rightView.add(rightValueMap.get(depth));
        }
        return rightView;

    }


}
