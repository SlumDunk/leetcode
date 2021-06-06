package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree, return a balanced binary search tree with the same node values.
 * <p>
 * A binary search tree is balanced if and only if the depth of the two subtrees of every node never differ by more than 1.
 * <p>
 * If there is more than one answer, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: root = [1,null,2,null,3,null,4,null,null]
 * Output: [2,1,3,null,null,null,4]
 * Explanation: This is not the only correct answer, [3,1,4,null,2,null,null] is also correct.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is between 1 and 10^4.
 * The tree nodes will have distinct values between 1 and 10^5.
 */
public class Leetcode1382 {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inOrder(root, list);

        return bbst(list, 0, list.size() - 1);
    }

    private TreeNode bbst(List<TreeNode> list, int low, int high) {
        if (low > high) {
            return null;
        } else {
            int mid = low + (high - low) / 2;
            TreeNode root = list.get(mid);
            root.left = bbst(list, low, mid - 1);
            root.right = bbst(list, mid + 1, high);
            return root;
        }
    }

    private void inOrder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
}
