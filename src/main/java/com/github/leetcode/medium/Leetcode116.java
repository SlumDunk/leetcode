package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeLinkNode;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 18:58
 * @Description: Given a binary tree
 * <p>
 * struct TreeLinkNode {
 * TreeLinkNode *left;
 * TreeLinkNode *right;
 * TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 * <p>
 * Note:
 * <p>
 * You may only use constant extra space.
 * Recursive approach is fine, implicit stack space does not count as extra space for this problem.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
 * Example:
 * <p>
 * Given the following perfect binary tree,
 * <p>
 * 1
 * /  \
 * 2    3
 * / \  / \
 * 4  5  6  7
 * After calling your function, the tree should look like:
 * <p>
 * 1 -> NULL
 * /  \
 * 2 -> 3 -> NULL
 * / \  / \
 * 4->5->6->7 -> NULL
 */
public class Leetcode116 {
    public void connect(TreeLinkNode root) {
        TreeLinkNode level_start = root;
        //没有走完所有的层级
        while (level_start != null) {
            TreeLinkNode current = level_start;
            //这一层还没走完
            while (current != null) {
                //左节点的next指针指向自己的右子节点
                if (current.left != null) {
                    current.left.next = current.right;
                }
                //右子节点next指针指向自己右兄弟节点的左节点
                if (current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }
                current = current.next;
            }
            //因为是一颗满二叉树
            level_start = level_start.left;
        }

    }
}
