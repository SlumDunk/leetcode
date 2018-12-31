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
    /**
     * 全局的节点
     */
    private TreeNode target;
    /**
     * 全局计数器
     */
    private int counter;

    public int kthSmallest(TreeNode root, int k) {
        //对树进行中序遍历即可产生有序的数组
        inorder(root, k);
        return target.val;
    }

    public void inorder(TreeNode root, int k) {
        //空节点或者已经找到了，不用再走
        if (root == null || counter == k) {
            return;
        } else {
            //左子树
            inorder(root.left, k);
            //根节点
            if (++counter == k) {
                target = root;
                return;
            }
            //右子树
            inorder(root.right, k);
        }
    }
}
