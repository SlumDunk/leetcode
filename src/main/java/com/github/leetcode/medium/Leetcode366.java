package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/6/19 09:16
 * @Description: Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,4,5]
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * Output: [[4,5,3],[2],[1]]
 * <p>
 * <p>
 * Explanation:
 * <p>
 * 1. Removing the leaves [4,5,3] would result in this tree:
 * <p>
 * 1
 * /
 * 2
 * <p>
 * <p>
 * 2. Now removing the leaf [2] would result in this tree:
 * <p>
 * 1
 * <p>
 * <p>
 * 3. Now removing the leaf [1] would result in the empty tree:
 * <p>
 * []
 */
public class Leetcode366 {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, root);
        return res;
    }

    /**
     * 后根递归
     * 返回所在的层级
     *
     * @param res
     * @param root
     * @return
     */
    private int helper(List<List<Integer>> res, TreeNode root) {
        if (root == null) return -1;
        int left = helper(res, root.left);
        int right = helper(res, root.right);
        int level = Math.max(left, right) + 1;
        if (res.size() == level) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }
}
