package com.github.leetcode.hard;

import com.github.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 15:17
 * @Description: Two elements of a binary search tree (BST) are swapped by mistake.
 * <p>
 * Recover the tree without changing its structure.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,null,null,2]
 * <p>
 * 1
 * /
 * 3
 * \
 * 2
 * <p>
 * Output: [3,1,null,null,2]
 * <p>
 * 3
 * /
 * 1
 * \
 * 2
 * Example 2:
 * <p>
 * Input: [3,1,4,null,null,2]
 * <p>
 * 3
 * / \
 * 1   4
 * /
 * 2
 * <p>
 * Output: [2,1,4,null,null,3]
 * <p>
 * 2
 * / \
 * 1   4
 * /
 * 3
 * Follow up:
 * <p>
 * A solution using O(n) space is pretty straight forward.
 * Could you devise a constant space solution?
 */
public class Leetcode99 {
    public void recoverTree(TreeNode root) {
        //中序遍历是个递增序列
        if (root == null) return;
        //第一个异常的点
        TreeNode first = null;
        //第二个异常的节点
        TreeNode second = null;
        //前置节点
        TreeNode prev = null;

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                if (prev != null && cur.val <= prev.val) {
                    if (first == null) {
                        first = prev;
                    }
                    second = cur;
                }
                prev = cur;
                cur = cur.right;
            }
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }


    /**
     * O(n)
     *
     * @param root
     */
    public void recoverTree_(TreeNode root) {
        //通过中序遍历寻找异常点
        if (root == null) return;

        TreeNode first = null;

        TreeNode second = null;

        TreeNode pre = null;

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            TreeNode cur = stack.pop();
            if (pre != null && cur.val <= pre.val) {
                if (first == null) {
                    first = pre;
                }
                second = cur;
            }

            pre = cur;
            root = cur.right;
        }

        int temp = first.val;
        first.val = second.val;
        second.val = temp;


    }
}
