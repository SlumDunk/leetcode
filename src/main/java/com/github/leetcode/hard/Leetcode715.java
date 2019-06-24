package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 6/4/19 22:40
 * @Description: A Range Module is a module that tracks ranges of numbers. Your task is to design and implement the following interfaces in an efficient manner.
 * <p>
 * addRange(int left, int right) Adds the half-open interval [left, right), tracking every real number in that interval. Adding an interval that partially overlaps with currently tracked numbers should add any numbers in the interval [left, right) that are not already tracked.
 * queryRange(int left, int right) Returns true if and only if every real number in the interval [left, right) is currently being tracked.
 * removeRange(int left, int right) Stops tracking every real number currently being tracked in the interval [left, right).
 * Example 1:
 * addRange(10, 20): null
 * removeRange(14, 16): null
 * queryRange(10, 14): true (Every number in [10, 14) is being tracked)
 * queryRange(13, 15): false (Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
 * queryRange(16, 17): true (The number 16 in [16, 17) is still being tracked, despite the remove operation)
 * Note:
 * <p>
 * A half open interval [left, right) denotes all real numbers left <= x < right.
 * 0 < left < right < 10^9 in all calls to addRange, queryRange, removeRange.
 * The total number of calls to addRange in a single test case is at most 1000.
 * The total number of calls to queryRange in a single test case is at most 5000.
 * The total number of calls to removeRange in a single test case is at most 1000.
 */
public class Leetcode715 {
    class RangeModule {

        class TreeNode {
            int start, end;
            TreeNode left, right;

            public TreeNode(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }

        TreeNode root;

        public RangeModule() {
        }

        public void addRange(int left, int right) {
            root = addRange(root, left, right);
        }

        public boolean queryRange(int left, int right) {
            return queryRange(root, left, right);
        }

        public void removeRange(int left, int right) {
            root = removeRange(root, left, right); //记得要写成root = 否则把root删了 。。
        }

        /**
         * @param root
         * @param start
         * @param end
         * @return
         */
        private TreeNode removeRange(TreeNode root, int start, int end) {
            if (start >= end) return root;
            if (root == null) return root;
            if (root.end <= start) {//root.start<root.end<=start<end
                root.right = removeRange(root.right, start, end);
            } else if (root.start >= end) {//start<end<=root.start<root.end
                root.left = removeRange(root.left, start, end);
            } else {// root.start<start<end<root.end||start<root.start<root.end<end
                root.left = removeRange(root.left, start, root.start);
                root.right = removeRange(root.right, root.end, end);
                root.left = addRange(root.left, root.start, start);
                root.right = addRange(root.right, end, root.end);
                root = remove(root);
            }
            return root;
        }

        /**
         * 移除节点node
         *
         * @param node
         * @return
         */
        private TreeNode remove(TreeNode node) {
            if (node == null) return null;
            if (node.left == null) return node.right;
            TreeNode leftLargest = getLargest(node.left, node);
            leftLargest.left = node.left;
            leftLargest.right = node.right;
            return leftLargest;
        }

        /**
         * 获取最大的节点，并移除节点的左支
         *
         * @param node
         * @param parent
         * @return
         */
        private TreeNode getLargest(TreeNode node, TreeNode parent) {
            while (node.right != null) {
                parent = node;
                node = node.right;
            }
            if (node == parent.left) parent.left = node.left;
            if (node == parent.right) parent.right = node.left;
            node.left = null;
            return node;
        }

        /**
         * 查询节点范围
         *
         * @param root
         * @param start
         * @param end
         * @return
         */
        private boolean queryRange(TreeNode root, int start, int end) {
            if (start >= end) return true;
            if (root == null) return false;
            if (start >= root.end) return queryRange(root.right, start, end);
            if (end <= root.start) return queryRange(root.left, start, end);
            if (start >= root.start && end <= root.end) return true;
            return queryRange(root.left, start, root.start) && queryRange(root.right, root.end, end);
        }

        /**
         * 添加节点
         *
         * @param root
         * @param start
         * @param end
         * @return
         */
        private TreeNode addRange(TreeNode root, int start, int end) {
            if (start >= end) return root;
            if (root == null) return new TreeNode(start, end);
            if (root.start >= end) {
                root.left = addRange(root.left, start, end);
            } else if (root.end <= start) {
                root.right = addRange(root.right, start, end);
            } else {
                root.left = addRange(root.left, start, root.start);
                root.right = addRange(root.right, root.end, end);
            }
            return root;
        }
    }
}
