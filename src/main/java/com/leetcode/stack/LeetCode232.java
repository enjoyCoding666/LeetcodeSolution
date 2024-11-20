package com.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class LeetCode232 {

    Deque<Integer> inStack;
    Deque<Integer> outStack;

    //将一个栈当作入列的栈，用于压入 push 传入的数据；
    //另一个栈当作出列的栈，用于 pop 和 peek 操作。
    public LeetCode232() {
        outStack = new ArrayDeque<>();
        inStack = new ArrayDeque<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        //出列的栈为空，则需要从入列的栈取到数据
        if (outStack.isEmpty()) {
            //入列的栈非空，就把所有入列的栈转入到出列的栈
            inToOut();
        }
        return outStack.pop();
    }

    /**
     * 把所有入列的栈数据，转入到出列的栈
     */
    public void inToOut() {
        //这里要判断，入列的栈，是否已经为空
        while (!inStack.isEmpty()) {
            outStack.push(inStack.pop());
        }

    }

    /**
     * 查看出列的栈数据
     */
    public int peek() {
        if (outStack.isEmpty()) {
            inToOut();
        }
        if (outStack != null && !outStack.isEmpty()) {
            return outStack.peek();
        }
        return 0;
    }

    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


}
