package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 10:17
 * @Description: Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * <p>
 * Calling children() will return the children smallest number in the BST.
 * <p>
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the idx of the tree.
 * <p>
 * Credits:
 * Special thanks to @ts for adding this problem and creating all test cases.
 */
public class Leetcode173 {
    /**
     * 将中序遍历的功能嵌查在整个程序中
     */
    public class BSTIterator {
        Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<TreeNode>();
            //因为只可能是左节点才是最小值，将所有左子树节点入栈，保证空间复杂度是O(h)
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return 是否还有下一个元素，判断栈是否为空即可
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return 获取下一个最小元素，出栈的同时把当前节点的右子树做中序进栈操作处理
         */
        public int next() {
            TreeNode current = stack.pop();
            //获取当前最小值
            int res = current.val;
            //右子树进行中序进栈操作
            current = current.right;
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            return res;
        }
    }


    class BSTIterator__ {
        Stack<TreeNode> stack = new Stack<TreeNode>();

        public BSTIterator__(TreeNode root) {
            initiate(root);
        }

        private void initiate(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                initiate(cur.right);
                return cur.val;
            } else {
                return -1;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }
}
