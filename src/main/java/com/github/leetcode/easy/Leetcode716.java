package com.github.leetcode.easy;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 3/17/19 22:34
 * @Description: Design a max stack that supports push, pop, top, peekMax and popMax.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Remove the element on top of the stack and return it.
 * top() -- Get the element on the top.
 * peekMax() -- Retrieve the maximum element in the stack.
 * popMax() -- Retrieve the maximum element in the stack, and remove it. If you find more than one maximum elements, only remove the top-most one.
 * Example 1:
 * MaxStack stack = new MaxStack();
 * stack.push(5);
 * stack.push(1);
 * stack.push(5);
 * stack.top(); -> 5
 * stack.popMax(); -> 5
 * stack.top(); -> 1
 * stack.peekMax(); -> 5
 * stack.pop(); -> 1
 * stack.top(); -> 5
 * Note:
 * -1e7 <= x <= 1e7
 * Number of operations won't exceed 10000.
 * The last four operations won't be called when stack is empty.
 */
public class Leetcode716 {
    class MaxStack {
        Stack<Integer> stack;
        int max = Integer.MIN_VALUE;

        /**
         * initialize your data structure here.
         */
        public MaxStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (x >= max) {
                stack.push(max);
                max = x;
            }
            stack.push(x);
        }

        public int pop() {
            int pop = stack.pop();
            if (pop == max) {
                max = stack.pop();
            }
            return pop;
        }

        public int top() {
            return stack.peek();
        }

        public int peekMax() {
            return max;
        }

        public int popMax() {
            if (stack.peek() == max) {
                int pop = stack.pop();
                max = stack.pop();
                return pop;
            } else {
                Stack<Integer> temp = new Stack<>();
                while (stack.peek() != max) {
                    temp.push(stack.pop());
                }
                int pop = stack.pop();
                max = stack.pop();
                while (!temp.isEmpty()) {
                    push(temp.pop());
                }
                return pop;
            }
        }
    }
}
