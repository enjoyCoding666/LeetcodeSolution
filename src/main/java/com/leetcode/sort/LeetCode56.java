package com.leetcode.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出：[[1,6],[8,10],[15,18]]
 * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2：
 *
 * 输入：intervals = [[1,4],[4,5]]
 * 输出：[[1,5]]
 * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 *
 */
public class LeetCode56 {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        //排序.根据数组的第一个元素进行排序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));

        List<int[]> resultList = new ArrayList<>();
        for (int[] interval : intervals) {
            //数组的两个数
            int left = interval[0];
            int right = interval[1];

            //如果 left 大于 list 最后一个数组的 right ，就说明没有相交区间
            if (resultList.isEmpty() || resultList.get(resultList.size() - 1)[1] < left) {
                resultList.add(new int[]{left, right});
            } else {
                //有相交区间，那 最后一个数组的 right ，需要设置为相交区间里面较大的值
                resultList.get(resultList.size() - 1)[1]
                        = Math.max(resultList.get(resultList.size() - 1)[1], right);
            }

        }
        //转化为数组
        return resultList.toArray(new int[resultList.size()][]);


    }


}
