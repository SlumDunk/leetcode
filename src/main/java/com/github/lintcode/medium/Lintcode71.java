package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 1/12/19 10:11
 * @Description: Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * Example
 * Given binary tree {3,9,20,#,#,15,7},
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * <p>
 * <p>
 * return its zigzag level order traversal as:
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Lintcode71 {
    /**
     * @param root: A Tree
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        } else {
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            int level = 1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelList = new LinkedList();
                while (size > 0) {
                    TreeNode currentNode = queue.poll();
                    if (level % 2 == 1) {
                        levelList.add(currentNode.val);
                    } else {
                        levelList.add(0, currentNode.val);
                    }
                    if (currentNode.left != null) {
                        queue.offer(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.offer(currentNode.right);
                    }
                    size--;
                }
                result.add(levelList);
                level++;
            }
            return result;
        }
    }
}
