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
        TreeNode rootNode = createTree(nums, 0, nums.length - 1);
        return rootNode;
    }

    private TreeNode createTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createTree(nums, left, mid - 1);
        node.right = createTree(nums, mid + 1, right);
        return node;

    }
}
