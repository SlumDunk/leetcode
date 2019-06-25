package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 6/25/19 08:30
 * @Description: Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * <p>
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * <p>
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 * <p>
 * 6
 * /   \
 * 3     5
 * \    /
 * 2  0
 * \
 * 1
 * Note:
 * The size of the given array will be in the range [1,1000].
 */
public class Leetcode654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    /**
     *
     * @param nums 数组
     * @param start 开始位置
     * @param end 结束位置
     * @return
     */
    public TreeNode construct(int[] nums, int start, int end) {
        if (end < 0) return null;
        if (start >= nums.length) return null;
        if (nums.length == 0) return null;
        //找出当前范围内最大的数字和索引
        int ind = -1;
        int max = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                ind = i;
            }
        }
        //越界，直接返回空节点
        if (ind == -1) return null;

        TreeNode t = new TreeNode(max);
        t.left = construct(nums, start, ind - 1);
        t.right = construct(nums, ind + 1, end);

        return t;
    }
}
