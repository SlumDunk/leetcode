package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 12/30/18 09:21
 * @Description: Given two binary trees, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical and the nodes have the same value.
 * <p>
 * Example 1:
 * <p>
 * Input:     1         1
 * / \       / \
 * 2   3     2   3
 * <p>
 * [1,2,3],   [1,2,3]
 * <p>
 * Output: true
 * Example 2:
 * <p>
 * Input:     1         1
 * /           \
 * 2             2
 * <p>
 * [1,2],     [1,null,2]
 * <p>
 * Output: false
 * Example 3:
 * <p>
 * Input:     1         1
 * / \       / \
 * 2   1     1   2
 * <p>
 * [1,2,1],   [1,1,2]
 * <p>
 * Output: false
 */
public class Leetcode100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //广度优先遍历
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

        q1.offer(p);
        q2.offer(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode x = q1.poll();
            TreeNode y = q2.poll();

            if (x == null) {
                if (y == null) {
                    continue;
                } else {
                    return false;
                }
            } else {
                if (y == null) {
                    return false;
                } else if (x.val != y.val) {
                    return false;
                }
            }

            q1.offer(x.left);
            q1.offer(x.right);
            q2.offer(y.left);
            q2.offer(y.right);
        }
        return true;
    }
}
