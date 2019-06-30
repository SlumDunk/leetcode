package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 22:47
 * @Description: You need to find the largest value in each row of a binary tree.
 * <p>
 * Example:
 * Input:
 * <p>
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * <p>
 * Output: [1, 3, 9]
 */
public class Leetcode515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) return list;

        queue.offer(root);

        while (!queue.isEmpty()) {

            int n = queue.size();
            int trial = Integer.MIN_VALUE;


            for (int i = 0; i < n; i++) {

                TreeNode t = queue.poll();
                trial = Math.max(trial, t.val);
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);

            }

            list.add(trial);

        }

        return list;
    }
}
