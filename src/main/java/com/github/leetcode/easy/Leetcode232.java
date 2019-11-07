package com.github.leetcode.easy;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 12/28/18 16:43
 * @Description: Implement the following operations of a heap using stacks.
 * <p>
 * push(x) -- Push element x to the back of heap.
 * pop() -- Removes the element from in front of heap.
 * peek() -- Get the front element.
 * empty() -- Return whether the heap is empty.
 * Example:
 * <p>
 * MyQueue heap = new MyQueue();
 * <p>
 * heap.push(1);
 * heap.push(2);
 * heap.peek();  // returns 1
 * heap.pop();   // returns 1
 * heap.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended heap), as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty heap).
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
         * 初始化数据结构
         */
        public MyQueue() {
            stack = new Stack<>();
            copyStack = new Stack<>();
        }

        /**
         * 元素x入栈
         *
         * @param x
         */
        public void push(int x) {
            stack.push(x);
        }

        /**
         * 元素出栈
         *
         * @return
         */
        public int pop() {
            copyStack();
            return copyStack.pop();
        }

        /**
         * 将原始栈的数据倒序拷贝到副本栈，如果副本栈为空的话
         */
        private void copyStack() {
            //副本栈中的元素为空
            if (copyStack.isEmpty()) {
                while (!stack.isEmpty()) {
                    copyStack.push(stack.pop());
                }
            }
        }

        /**
         * 获取栈顶元素
         *
         * @return
         */
        public int peek() {
            copyStack();
            return copyStack.peek();
        }

        /**
         * 判断栈是否为空
         *
         * @return
         */
        public boolean empty() {
            return stack.isEmpty() && copyStack.isEmpty();
        }
    }


    class MyQueue_ {
        Stack<Integer> s1 = new Stack<Integer>();

        Stack<Integer> s2 = new Stack<Integer>();

        /**
         * Initialize your data structure here.
         */
        public MyQueue_() {

        }

        /**
         * O(1)
         * Push element x to the back of queue.
         */
        public void push(int x) {
            s1.push(x);
        }

        /**
         * O(1)每个元素只操作2次
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            if (!s2.isEmpty()) {
                return s2.pop();
            } else {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                if (!s2.isEmpty()) {
                    return s2.pop();
                } else {
                    return -1;
                }
            }
        }

        /**
         * O(1)
         * Get the front element.
         */
        public int peek() {
            if (!s2.isEmpty()) {
                return s2.peek();
            } else {
                while (!s1.isEmpty()) {
                    s2.push(s1.pop());
                }
                if (!s2.isEmpty()) {
                    return s2.peek();
                } else {
                    return -1;
                }
            }
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

}
