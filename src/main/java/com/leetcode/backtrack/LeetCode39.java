package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LeetCode39 {

    List<List<Integer>> resultList = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0);
        return resultList;
    }

    public void dfs(int[] candidates, int target, int idx) {
        //如果遍历完了数组，就结束
        if (idx == candidates.length) {
            return;
        }

        //达到了目标值，就添加到结果列表中
        if (target == 0) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        //在决策中，可以选择跳过不用第 idx 个数。也可以选择像后面代码，选择第 idx 个数
        dfs(candidates, target, idx + 1);

        // 如果已经大于我们所需的target 值，说明已经不满足条件了。终止递归。
        if (target - candidates[idx] >= 0) {
            //选择第 idx 个数。添加到列表中
            list.add(candidates[idx]);
            //递归。目标值去掉已经添加的值
            dfs(candidates, target - candidates[idx], idx);
            //回溯
            list.remove(list.size() - 1);

        }

    }

}
