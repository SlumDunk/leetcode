package com.github.lintcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 1/25/19 09:01
 * @Description: As the title described, you should only use two stacks to implement a queue's actions.
 * <p>
 * The queue should support push(element), pop() and top() where pop is pop the first(a.k.a front) element in the queue.
 * <p>
 * Both pop and top methods should return the value of first element.
 * <p>
 * Example
 * push(1)
 * pop()     // return 1
 * push(2)
 * push(3)
 * top()     // return 2
 * pop()     // return 2
 * Challenge
 * implement it by two stacks, do not use any other data structure and push, pop and top should be O(1) by AVERAGE.
 */
public class Lintcode40 {
    class MyQueue {
        Stack<Integer> inputStack = new Stack<Integer>();
        Stack<Integer> outputStack = new Stack<Integer>();

        public MyQueue() {
            // do intialization if necessary
        }

        /*
         * @param element: An integer
         * @return: nothing
         */
        public void push(int element) {
            // write your code here
            inputStack.push(element);
        }

        /*
         * @return: An integer
         */
        public int pop() {
            // write your code here
            if (outputStack.isEmpty()) {
                popInputStack();
            }
            return outputStack.pop();
        }

        /*
         * @return: An integer
         */
        public int top() {
            // write your code here
            if (outputStack.isEmpty()) {
                popInputStack();
            }
            return outputStack.peek();
        }

        private void popInputStack() {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
    }
}
