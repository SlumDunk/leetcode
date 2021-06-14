package com.github.leetcode.medium;

import java.util.Stack;

/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 * <p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 * <p>
 * Return the final string after all such duplicate removals have been made. It is guaranteed that the answer is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "abcd", k = 2
 * Output: "abcd"
 * Explanation: There's nothing to delete.
 * Example 2:
 * <p>
 * Input: s = "deeedbbcccbdaa", k = 3
 * Output: "aa"
 * Explanation:
 * First delete "eee" and "ccc", get "ddbbbdaa"
 * Then delete "bbb", get "dddaa"
 * Finally delete "ddd", get "aa"
 * Example 3:
 * <p>
 * Input: s = "pbbcggttciiippooaais", k = 2
 * Output: "ps"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 105
 * 2 <= k <= 104
 * s only contains lower case English letters.
 */
public class Leetcode1209 {
    class Pair {
        char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }

    }

    public String removeDuplicates(String s, int k) {
        if (s == null || s.length() < k) {
            return s;
        }
        char[] array = s.toCharArray();
        Stack<Pair> stack = new Stack<Pair>();
        for (char c :
                array) {
            if (stack.isEmpty() || stack.peek().c != c) {
                stack.push(new Pair(c, 1));
            } else {
                int count = stack.pop().count + 1;
                if (count < k) {
                    stack.push(new Pair(c, count));
                }
            }
        }

        if (stack.isEmpty()) {
            return "";
        } else {
            StringBuilder buffer = new StringBuilder();
            while (!stack.isEmpty()) {
                Pair pair = stack.pop();
                for (int i = 0; i < pair.count; i++) {
                    buffer.append(pair.c);
                }
            }
            return buffer.reverse().toString();
        }

    }
}
