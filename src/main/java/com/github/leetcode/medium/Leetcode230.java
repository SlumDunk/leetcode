package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 15:47
 * @Description: Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 * 2
 * Output: 1
 * Example 2:
 * <p>
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * Output: 3
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?
 */
public class Leetcode230 {
    private TreeNode temp;
    private int counter;

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return temp.val;
    }

    public void inorder(TreeNode node, int k) {
        // perform in order tree traversal
        if (node == null)
            return; // base case
        inorder(node.left, k);
        if (++counter == k) {
            temp = node;
            return;
        }
        inorder(node.right, k);
    }

}
