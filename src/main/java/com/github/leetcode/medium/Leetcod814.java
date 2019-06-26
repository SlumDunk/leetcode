package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 6/25/19 18:42
 * @Description: We are given the head node root of a binary tree, where additionally every node's value is either a 0 or a 1.
 * <p>
 * Return the same tree where every subtree (of the given tree) not containing a 1 has been removed.
 * <p>
 * (Recall that the subtree of a node X is X, plus every node that is a descendant of X.)
 * <p>
 * Example 1:
 * Input: [1,null,0,0,1]
 * Output: [1,null,0,null,1]
 * <p>
 * Explanation:
 * Only the red nodes satisfy the property "every subtree not containing a 1".
 * The diagram on the right represents the answer.
 * <p>
 * <p>
 * Example 2:
 * Input: [1,0,1,0,0,0,1]
 * Output: [1,null,1,null,1]
 * <p>
 * <p>
 * <p>
 * Example 3:
 * Input: [1,1,0,1,1,0,1,0]
 * Output: [1,1,0,1,1,null,1]
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * The binary tree will have at most 100 nodes.
 * The value of each node will only be 0 or 1.
 */
public class Leetcod814 {
    public TreeNode pruneTree(TreeNode root) {
        dfs(root);
        return root;
    }

    /**
     * @param root
     * @return
     */
    private boolean dfs(TreeNode root) {
        if (root == null) return true;
        boolean left = dfs(root.left);
        boolean right = dfs(root.right);
        if (left) root.left = null;
        if (right) root.right = null;
        //子树每个节点为0
        return root.val == 0 && left && right;
    }
}
