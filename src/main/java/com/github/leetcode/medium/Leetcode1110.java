package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 16:25
 * @Description: Given the root of a binary tree, each node in the tree has a distinct value.
 * <p>
 * After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
 * <p>
 * Return the roots of the trees in the remaining forest.  You may return the result in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
 * Output: [[1,2,null,4],[6],[7]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the given tree is at most 1000.
 * Each node has a distinct value between 1 and 1000.
 * to_delete.length <= 1000
 * to_delete contains distinct values between 1 and 1000.
 */
public class Leetcode1110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3);
        root.left = node2;

    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        } else if (to_delete == null || to_delete.length == 0) {
            result.add(root);
            return result;
        } else {
            List<Integer> deleteList = new ArrayList<>();
            for (int val : to_delete
                    ) {
                deleteList.add(val);
            }
            if (!deleteList.contains(root.val)) {
                result.add(root);
            }
            helper(root, deleteList, result, null);
            return result;
        }
    }

    /**
     * @param root
     * @param deleteList
     * @param result
     */
    private void helper(TreeNode root, List<Integer> deleteList, List<TreeNode> result, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (deleteList.contains(root.val)) {
            if (root.left != null && !deleteList.contains(root.left.val)) {
                result.add(root.left);
            }
            if (root.right != null && !deleteList.contains(root.right.val)) {
                result.add(root.right);
            }
            helper(root.left, deleteList, result, root);
            helper(root.right, deleteList, result, root);
            root.left = null;
            root.right = null;
            if (parent != null) {
                if (parent.left != null && parent.left.val == root.val) {
                    parent.left = null;
                }
                if (parent.right != null && parent.right.val == root.val) {
                    parent.right = null;
                }
            }
        } else {
            helper(root.left, deleteList, result, root);
            helper(root.right, deleteList, result, root);
        }
    }
}
