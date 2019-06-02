package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 5/30/19 10:27
 * @Description: Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
 * <p>
 * The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 3     2
 * / \     \
 * 5   3     9
 * <p>
 * Output: 4
 * Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
 * Example 2:
 * <p>
 * Input:
 * <p>
 * 1
 * /
 * 3
 * / \
 * 5   3
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the third level with the length 2 (5,3).
 * Example 3:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /
 * 5
 * <p>
 * Output: 2
 * Explanation: The maximum width existing in the second level with the length 2 (3,2).
 * Example 4:
 * <p>
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * /     \
 * 5       9
 * /         \
 * 6           7
 * Output: 8
 * Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
 * <p>
 * <p>
 * Note: Answer will in the range of 32-bit signed integer.
 */
public class Leetcode662 {
    class TopNode {
        TreeNode node;
        int idx;

        public TopNode(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    /**
     * 存储每个节点的索引 BFS
     *
     * @param root
     * @return
     */
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        Queue<TopNode> queue = new LinkedList<>();
        queue.add(new TopNode(root, 1));
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            int left = queue.peek().idx;
            int right = left;
            for (int i = 0; i < size; i++) {
                TopNode tn = queue.poll();
                right = tn.idx;
                if (tn.node.left != null) {
                    queue.add(new TopNode(tn.node.left, 2 * right - 1));
                }
                if (tn.node.right != null) {
                    queue.add(new TopNode(tn.node.right, 2 * right));
                }
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
