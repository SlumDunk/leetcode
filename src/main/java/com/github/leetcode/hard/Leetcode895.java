package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 5/13/19 11:15
 * @Description: Implement FreqStack, a class which simulates the operation of a stack-like data structure.
 * <p>
 * FreqStack has two functions:
 * <p>
 * push(int x), which pushes an integer x onto the stack.
 * pop(), which removes and returns the most frequent element in the stack.
 * If there is a tie for most frequent element, the element closest to the top of the stack is removed and returned.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["FreqStack","push","push","push","push","push","push","pop","pop","pop","pop"],
 * [[],[5],[7],[5],[7],[4],[5],[],[],[],[]]
 * Output: [null,null,null,null,null,null,null,5,7,5,4]
 * Explanation:
 * After making six .push operations, the stack is [5,7,5,7,4,5] from bottom to top.  Then:
 * <p>
 * pop() -> returns 5, as 5 is the most frequent.
 * The stack becomes [5,7,5,7,4].
 * <p>
 * pop() -> returns 7, as 5 and 7 is the most frequent, but 7 is closest to the top.
 * The stack becomes [5,7,5,4].
 * <p>
 * pop() -> returns 5.
 * The stack becomes [5,7,4].
 * <p>
 * pop() -> returns 4.
 * The stack becomes [5,7].
 * <p>
 * <p>
 * Note:
 * <p>
 * Calls to FreqStack.push(int x) will be such that 0 <= x <= 10^9.
 * It is guaranteed that FreqStack.pop() won't be called if the stack has zero elements.
 * The total number of FreqStack.push calls will not exceed 10000 in a single test case.
 * The total number of FreqStack.pop calls will not exceed 10000 in a single test case.
 * The total number of FreqStack.push and FreqStack.pop calls will not exceed 150000 across all test cases.
 */
public class Leetcode895 {
    class FreqStack {
        /**
         * key是整数，value是出现的次数
         */
        HashMap<Integer, Integer> freq = new HashMap<>();
        /**
         * key是出现的次数，value是存储的元素栈
         */
        HashMap<Integer, Stack<Integer>> m = new HashMap<Integer, Stack<Integer>>();
        int maxFreq = 0;

        public FreqStack() {
        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            maxFreq = Math.max(maxFreq, f);
            if (!m.containsKey(f)) {
                m.put(f, new Stack<>());
            }
            m.get(f).add(x);

        }

        public int pop() {
            int x = m.get(maxFreq).pop();
            freq.put(x, maxFreq - 1);
            if (m.get(maxFreq).size() == 0) {
                maxFreq--;
            }

            return x;
        }
    }


    class FreqStack_ {

        /**
         * key是整数，value是出现的次数
         */
        HashMap<Integer, Integer> freq = new HashMap<>();
        /**
         * key是出现的次数，value是存储的元素栈
         */
        HashMap<Integer, Stack<Integer>> m = new HashMap<Integer, Stack<Integer>>();
        int maxFreq = 0;

        public FreqStack_() {

        }

        public void push(int x) {
            int f = freq.getOrDefault(x, 0) + 1;
            freq.put(x, f);
            maxFreq = Math.max(maxFreq, f);
            m.putIfAbsent(f, new Stack<>());
            m.get(f).push(x);
        }

        public int pop() {
            int x = m.get(maxFreq).pop();
            freq.put(x, maxFreq - 1);
            if (m.get(maxFreq).size() == 0) {
                maxFreq--;
            }

            return x;
        }
    }
}
