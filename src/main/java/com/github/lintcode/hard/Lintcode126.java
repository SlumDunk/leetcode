package com.github.lintcode.hard;

import com.github.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 1/25/19 09:45
 * @Description: Given an integer array with no duplicates. A max tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array
 * The left subtree and right subtree are the max trees of the subarray divided by the root number.
 * Construct the max tree by the given array.
 * Example
 * Given [2, 5, 6, 0, 3, 1], the max tree is
 * <p>
 * 6
 * <p>
 * /    \
 * <p>
 * 5       3
 * <p>
 * /        /   \
 * <p>
 * 2        0     1
 */
public class Lintcode126 {
    public static void main(String[] args) {
        Lintcode126 lintcode126 = new Lintcode126();
        int[] A = new int[]{2, 5, 6, 0, 3, 1};
        lintcode126.maxTree(A);
    }

    public TreeNode maxTree(int[] A) {
        if (A == null || A.length == 0) {
            return null;
        }
        int len = A.length;
        //
        Stack<TreeNode> stack = new Stack<TreeNode>();

        //父节点是离自己比较近且比较高的点
        for (int i = 0; i < len; i++) {
            TreeNode temp = new TreeNode(A[i]);
            //出栈动作
            while (!stack.isEmpty() && A[i] > stack.peek().val) {
                temp.left = stack.pop();
            }
            if (!stack.isEmpty()) {
                stack.peek().right = temp;
            }
            //进栈动作
            stack.push(temp);
        }
        TreeNode root = null;
        while (!stack.isEmpty()) {
            root = stack.pop();
        }
        return root;
    }
}
