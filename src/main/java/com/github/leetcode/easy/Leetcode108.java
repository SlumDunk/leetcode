package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * <p>
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * Example:
 * <p>
 * Given the sorted array: [-10,-3,0,5,9],
 * <p>
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Leetcode108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        //二分法，每次取中间节点做为根节点
        return generateBST(nums, 0, nums.length - 1);
    }

    /**
     * @param nums  数组
     * @param left  左边界
     * @param right 右边界
     * @return
     */
    public TreeNode generateBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        } else {
            int middle = left + (right - left) / 2;
            TreeNode root = new TreeNode(nums[middle]);
            root.left = generateBST(nums, left, middle - 1);
            root.right = generateBST(nums, middle + 1, right);
            return root;
        }
    }

    public TreeNode sortedArrayToBST__(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        } else {
            int start = 0;
            int end = nums.length - 1;
            return helper(nums, start, end);
        }
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        } else if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;

    }
}
