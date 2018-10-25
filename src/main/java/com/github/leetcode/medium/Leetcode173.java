package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 10:17
 * @Description: Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling next() will return the next smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class Leetcode173 {
    public class BSTIterator {//将中序遍历的功能嵌查在整个程序中
        TreeNode current;
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            current = root;
            stack = new Stack<TreeNode>();
            while (current != null)//因为只可能是左节点才是最小值，将所有左子树节点入栈，保证空间复杂度是O(h)
            {
                stack.push(current);
                current = current.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            current = stack.pop();
            int res = current.val;//这一步已经得到最小值
            current = current.right;//但要考虑到右子树的遍历
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            return res;
        }
    }


}
