package com.leetcode.backtrack;

import java.util.ArrayList;
import java.util.List;


/**
 * 22. 括号生成
 *
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例 1：
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 示例 2：
 *
 * 输入：n = 1
 * 输出：["()"]
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 8
 *
 *
 */
public class LeetCode22 {

    /**
     * 生成 n 个括号()
     * @param n 括号的数量
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        if (n == 0) {
            return resultList;
        }
        //深度优先遍历
        dfs("", n, n, resultList);
        return resultList;

    }

    /**
     *
     * 深度优先遍历，每往下遍历一次，减少一个左括号，或者右括号
     *
     * @param s 当前递归得到的结果
     * @param left 剩余的左括号数量
     * @param right 剩余的右括号数量
     * @param resultList 结果集
     */
    private void dfs(String s, int left, int right, List<String> resultList) {
        //左右括号都用完了，就说明满足条件，可以加入到结果集中
        if (left == 0 && right == 0) {
            resultList.add(s);
        }
        //回溯算法=dfs+剪枝.
        //剪枝，就是去掉不符合条件的分支。
        //如果剩余的左括号数量大于剩余的右括号数量，说明是不符合条件的。比如 )))(
        if (left > right) {
            return;
        }
        //使用左括号，左括号的数量减一
        if (left > 0) {
            dfs(s+"(", left-1, right, resultList);
        }
        //使用右括号，右括号的数量减一
        if (right > 0) {
            dfs(s+")", left, right-1, resultList);
        }

    }
}
