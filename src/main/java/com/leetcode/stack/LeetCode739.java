package com.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

public class LeetCode739 {

    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null) {
            return null;
        }
        Deque<Integer> stack = new LinkedList<>();
        int length = temperatures.length;
        int[] answers = new int[length];
        //思路：遍历数组，将下标放进 单调栈，如果比过去几天的温度高，就是结果需要的下标
        for (int i=0; i< length; i++) {
            //stack.peek() 是之前的下标，可以根据这个下标，得到之前的温度
            //判断是否比过去几天的温度高, 由于要比较过去几天的温度，所以用 while
            while (!stack.isEmpty() &&  temperatures[i] > temperatures[stack.peek()] ) {
                int preIndex = stack.pop();
                //比过往的 温度高，那结果数组下标取 preIndex。这里需要计算相差了几天才是高温。
                answers[preIndex] = i- preIndex;
            }
            //将下标放进栈里
            stack.push(i);
        }

        return answers;


    }



}
