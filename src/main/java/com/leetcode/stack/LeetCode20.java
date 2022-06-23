package com.leetcode.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


/**
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 *     左括号必须用相同类型的右括号闭合。
 *     左括号必须以正确的顺序闭合。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 *
 * 示例 3：
 *
 * 输入：s = "(]"
 * 输出：false
 *
 * 示例 4：
 *
 * 输入：s = "([)]"
 * 输出：false
 *
 *
 *
 *
 */
public class LeetCode20 {

    public boolean isValid(String s) {
        int length = s.length();
        if (length % 2 == 1) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                //遇到一个右括号时，我们需要将一个相同类型的左括号闭合。
                //此时，我们可以取出栈顶的左括号并判断它们是否是相同类型的括号。
                //如果不是相同的类型，或者栈中并没有左括号，那么字符串无效，返回 False。
                if (stack.isEmpty() || !stack.peek().equals(map.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        //如果括号都配对，那么最后栈是空的
        return stack.isEmpty();

    }


}
