package com.github.leetcode.easy;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 12/28/18 16:09
 * @Description: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 */
public class Leetcode155 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin();
        minStack.pop();
        minStack.top();
        minStack.getMin();
    }

    /**
     * 装饰模式
     */
    static class MinStack {
        /**
         * 真正的栈
         */
        Stack<Integer> stack;
        /**
         * 最小值
         */
        int min = Integer.MAX_VALUE;


        public MinStack() {
            stack = new Stack<Integer>();
        }

        public void push(int x) {
            //调整最小值的时候，多存储上一次的最小值，
            // 方便在最小值出栈的时候获取剩下元素的最小值
            //注意是小于等于
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            //若出栈元素等于最小值，那么接着出栈，得到剩下元素的最小值
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}
