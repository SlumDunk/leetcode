package com.github.leetcode.easy;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 12/28/18 16:43
 * @Description: Implement the following operations of a queue using stacks.
 * <p>
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 * <p>
 * MyQueue queue = new MyQueue();
 * <p>
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 */
public class Leetcode232 {
    class MyQueue {
        /**
         * 原始的栈
         */
        Stack<Integer> stack;
        /**
         * 原始栈的倒序副本，用于出队
         */
        Stack<Integer> copyStack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
            copyStack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            copyStack();
            return copyStack.pop();
        }

        /**
         * 将原始栈的数据倒序拷贝到副本栈，如果副本栈为空的话
         */
        private void copyStack() {
            if (copyStack.isEmpty()) {
                while (!stack.isEmpty()) {
                    copyStack.push(stack.pop());
                }
            }
        }

        /**
         * Get the front element.
         */
        public int peek() {
            copyStack();
            return copyStack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty() && copyStack.isEmpty();
        }
    }

}
