package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 3/20/19 20:34
 * @Description: We are given an array asteroids of integers representing asteroids in a row.
 * <p>
 * For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 * <p>
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
 * <p>
 * Example 1:
 * Input:
 * asteroids = [5, 10, -5]
 * Output: [5, 10]
 * Explanation:
 * The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.
 * Example 2:
 * Input:
 * asteroids = [8, -8]
 * Output: []
 * Explanation:
 * The 8 and -8 collide exploding each other.
 * Example 3:
 * Input:
 * asteroids = [10, 2, -5]
 * Output: [10]
 * Explanation:
 * The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.
 * Example 4:
 * Input:
 * asteroids = [-2, -1, 1, 2]
 * Output: [-2, -1, 1, 2]
 * Explanation:
 * The -2 and -1 are moving left, while the 1 and 2 are moving right.
 * Asteroids moving the same direction never meet, so no asteroids will meet each other.
 * Note:
 * <p>
 * The length of asteroids will be at most 10000.
 * Each asteroid will be a non-zero integer in the range [-1000, 1000]..
 */
public class Leetcode735 {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < asteroids.length; i++) {
            merge(stack, asteroids[i]);
        }

        return stackToArray(stack);
    }

    private int[] stackToArray(Stack<Integer> stack) {
        int[] result = new int[stack.size()];
        while (stack.size() > 0) {
            int size = stack.size();
            result[size - 1] = stack.pop();
        }
        return result;
    }

    private void merge(Stack<Integer> stack, int asteroid) {
        //栈为空; 栈顶元素向左，新进来的向右; 栈顶元素向左，新进来元素向左; 栈顶元素向右，新进来的元素向右
        if (stack.size() == 0 || (stack.peek() < 0 && asteroid > 0) || stack.peek() * asteroid > 0) {
            stack.push(asteroid);
            return;
        } else {//栈顶元素向右，新进来的元素向左
            int pre = stack.pop();
            if (Math.abs(pre) < Math.abs(asteroid)) merge(stack, asteroid);
            if (Math.abs(pre) > Math.abs(asteroid)) merge(stack, pre);
            return;
        }
    }

}
