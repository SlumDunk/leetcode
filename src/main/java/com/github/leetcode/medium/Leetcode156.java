package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 20:08
 * @Description: Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.
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
 * Output: return the root of the binary tree [4,5,2,#,#,3,1]
 * <p>
 * 4
 * / \
 * 5   2
 * / \
 * 3   1
 * Clarification:
 * <p>
 * Confused what [4,5,2,#,#,3,1] means? Read more below on how binary tree is serialized on OJ.
 * <p>
 * The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 * <p>
 * Here's an example:
 * <p>
 * 1
 * / \
 * 2   3
 * /
 * 4
 * \
 * 5
 * The above binary tree is serialized as [1,2,3,#,#,4,#,#,5].
 */
public class Leetcode156 {
    public static void main(String[] args) {
        Leetcode156 leetcode156 = new Leetcode156();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        leetcode156.upsideDownBinaryTree(root);
    }

    /**
     * For example:
     * Given a binary tree {1,2,3,4,5},
     * 1
     * / \
     * 2   3
     * / \
     * 4   5
     * return the root of the binary tree [4,5,2,#,#,3,1].
     * 4
     * / \
     * 5   2
     * / \
     * 3   1
     * 1         1
     * / \       /
     * 2   3     2 - 3
     * / \       /
     * 4   5     4 - 5
     * time : O(n);
     * space : O(n);
     *
     * @param root
     * @return
     */
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        TreeNode newRoot = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;

        root.left = null;
        root.right = null;
        return newRoot;
    }
}
