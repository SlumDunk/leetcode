package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 09:51
 * @Description: Given a binary tree, determine if it is a complete binary tree.
 * <p>
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [1,2,3,4,5,6]
 * Output: true
 * Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [1,2,3,4,5,null,7]
 * Output: false
 * Explanation: The node with value 7 isn't as far left as possible.
 * <p>
 * Note:
 * <p>
 * The tree will have between 1 and 100 nodes.
 */
public class Leetcode958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        boolean endOfTree = false;
        while (!queue.isEmpty()) {
            TreeNode t = queue.poll();
            if (t == null) {
                endOfTree = true;
            } else {
                if (endOfTree) return false;
                queue.offer(t.left);
                queue.offer(t.right);
            }
        }
        return true;

    }
}
