package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 16:14
 * @Description: Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * <p>
 * You may assume each number in the sequence is unique.
 * <p>
 * Consider the following binary search tree:
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * Example 1:
 * <p>
 * Input: [5,2,6,1,3]
 * Output: false
 * Example 2:
 * <p>
 * Input: [5,2,1,3,6]
 * Output: true
 * Follow up:
 * Could you do it using only constant space complexity?
 */
public class Leetcode255 {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        //存储局部最小值
        int min = Integer.MIN_VALUE;
        for (int num :
                preorder) {
            if (num < min) {
                return false;
            }
            while (!stack.isEmpty() && num > stack.peek()) {
                min = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
}
