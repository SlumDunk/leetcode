package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 17:04
 * @Description: In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
 * <p>
 * Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
 * <p>
 * We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
 * <p>
 * Return true if and only if the nodes corresponding to the values x and y are cousins.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4], x = 4, y = 3
 * Output: false
 * Example 2:
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
 * Output: true
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,null,4], x = 2, y = 3
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the tree will be between 2 and 100.
 * Each node has a unique integer value from 1 to 100.
 */
public class Leetcode993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        if (x == y) {
            return false;
        }
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int len = queue.size();
                int sum = 0;
                for (int i = 0; i < len; i++) {
                    TreeNode node = queue.poll();
                    if (node.val == x || node.val == y) {
                        sum++;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }

                    if (node.right != null) {
                        queue.offer(node.right);
                    }

                    if (node.left != null && node.right != null) {
                        if (node.left.val == x && node.right.val == y || node.left.val == y && node.right.val == x) {
                            return false;
                        }
                    }
                }
                if (sum == 2) {
                    return true;
                }

            }
        }
        return false;
    }
}
