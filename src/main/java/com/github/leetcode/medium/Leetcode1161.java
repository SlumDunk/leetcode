package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 18:56
 * @Description: Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * <p>
 * Return the smallest level X such that the sum of all the values of nodes at level X is maximal.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree is between 1 and 10^4.
 * -10^5 <= node.val <= 10^5
 */
public class Leetcode1161 {
    public int maxLevelSum(TreeNode root) {
        //bfs

        Queue<TreeNode> queue = new LinkedList<>();

        int level = 0;
        int maximalLevel = 1;
        int maximalSum = Integer.MIN_VALUE;

        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            int tempSum = 0;
            level++;
            while (size > 0) {
                TreeNode node = queue.poll();
                tempSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                size--;
            }
            if (tempSum > maximalSum) {
                maximalSum = tempSum;
                maximalLevel = level;
            }
        }
        return maximalLevel;
    }
}
