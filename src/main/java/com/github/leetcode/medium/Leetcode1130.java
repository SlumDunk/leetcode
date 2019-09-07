package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 21:35
 * @Description: Given an array arr of positive integers, consider all binary trees such that:
 * <p>
 * Each node has either 0 or 2 children;
 * The values of arr correspond to the values of each leaf in an in-order traversal of the tree.  (Recall that a node is a leaf if and only if it has 0 children.)
 * The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree respectively.
 * Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node.  It is guaranteed this sum fits into a 32-bit integer.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [6,2,4]
 * Output: 32
 * Explanation:
 * There are two possible trees.  The first has non-leaf node sum 36, and the second has non-leaf node sum 32.
 * <p>
 * 24            24
 * /  \          /  \
 * 12   4        6    8
 * /  \               / \
 * 6    2             2   4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 2 <= arr.length <= 40
 * 1 <= arr[i] <= 15
 * It is guaranteed that the answer fits into a 32-bit signed integer (ie. it is less than 2^31).
 */
public class Leetcode1130 {
    public int mctFromLeafValues(int[] arr) {
        int res = 0, n = arr.length;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while (stack.peek() <= a) {
                //小值已经弹出栈 2
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}
