package com.github.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 12/28/18 16:35
 * @Description: Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a heap -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, heap may not be supported natively. You may simulate a heap by using a list or deque (double-ended heap), as long as you use only standard operations of a heap.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class Leetcode225 {
    class MyStack {
        Queue<Integer> queue;

        /**
         * 初始化数据结构
         */
        public MyStack() {
            queue = new LinkedList<Integer>();
        }

        /**
         * 将元素推入栈
         *
         * @param x
         */
        public void push(int x) {
            //将前面size个数重新入队
            int size = queue.size();
            int count = 0;
            queue.offer(x);
            while (count < size) {
                queue.offer(queue.poll());
                count++;
            }
        }

        /**
         * 栈顶元素出栈
         *
         * @return
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * 获取栈顶元素
         *
         * @return
         */
        public int top() {
            return queue.peek();
        }

        /**
         * 判断栈是否为空
         *
         * @return
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }
}

