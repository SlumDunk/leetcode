package com.github.lintcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 1/25/19 08:55
 * @Description: Implement a stack with min() function, which will return the smallest number in the stack.
 * <p>
 * It should support push, pop and min operation all in O(1) cost.
 * <p>
 * Example
 * push(1)
 * pop()   // return 1
 * push(2)
 * push(3)
 * min()   // return 2
 * push(1)
 * min()   // return 1
 * Notice
 * min operation will never be called if there is no number in the stack.
 */
public class Lintcode12 {
    class MinStack {
        Stack<Integer> stack = new Stack<Integer>();
        Stack<Integer> minStack = new Stack<Integer>();

        public MinStack() {
            // do intialization if necessary
        }

        /*
         * @param number: An integer
         * @return: nothing
         */
        public void push(int number) {
            // write your code here
            stack.push(number);
            if (minStack.isEmpty() || minStack.peek() >= number) {
                minStack.push(number);
            }
        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            if (!minStack.isEmpty() && minStack.peek().equals(stack.peek())) {
                minStack.pop();
            }
            return stack.pop();
        }

        /*
         * @return: An integer
         */
        public int min() {
            // write your code here
            return minStack.peek();
        }
    }
}
