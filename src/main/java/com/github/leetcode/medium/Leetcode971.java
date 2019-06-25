package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/24/19 22:07
 * @Description: Given a binary tree with N nodes, each node has a different value from {1, ..., N}.
 * <p>
 * A node in this binary tree can be flipped by swapping the left child and the right child of that node.
 * <p>
 * Consider the sequence of N values reported by a preorder traversal starting from the root.  Call such a sequence of N values the voyage of the tree.
 * <p>
 * (Recall that a preorder traversal of a node means we report the current node's value, then preorder-traverse the left child, then preorder-traverse the right child.)
 * <p>
 * Our goal is to flip the least number of nodes in the tree so that the voyage of the tree matches the voyage we are given.
 * <p>
 * If we can do so, then return a list of the values of all nodes flipped.  You may return the answer in any order.
 * <p>
 * If we cannot do so, then return the list [-1].
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2], voyage = [2,1]
 * Output: [-1]
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3], voyage = [1,3,2]
 * Output: [1]
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3], voyage = [1,2,3]
 * Output: []
 */
public class Leetcode971 {
    /**
     * 记录voyage数组的索引
     */
    int index = -1;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        List<Integer> ans = new ArrayList<>();
        dfs(root, null, voyage, ans);
        if (ans.contains(-1)) {
            ans.clear();
            ans.add(-1);
            return ans;
        } else {
            return ans;
        }
    }

    /**
     *
     * @param cur
     * @param parent
     * @param voyage
     * @param ans
     */
    private void dfs(TreeNode cur, TreeNode parent, int[] voyage, List<Integer> ans) {
        if (cur == null) return;
        index++;
        if (cur.val != voyage[index]) {  // Needs swap
            if (parent == null || parent.right == null || parent.right.val != voyage[index]) { // Failed swap
                ans.add(-1);
                return;
            }
            // 需要交换子节点
            ans.add(parent.val);
            //交换左右子节点
            TreeNode temp = parent.right;
            parent.right = cur;
            parent.left = temp;
            cur = parent.left;
        }
        dfs(cur.left, cur, voyage, ans);
        dfs(cur.right, cur, voyage, ans);
    }
}
