package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/8/19 17:41
 * @Description: Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.  (The values of the nodes may still be duplicates.)
 * <p>
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the path from root to the right-most node. If the root doesn't have left subtree or right subtree, then the root itself is left boundary or right boundary. Note this definition only applies to the input binary tree, and not applies to any subtrees.
 * <p>
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 * <p>
 * The right-most node is also defined by the same way with left and right exchanged.
 * <p>
 * Example 1
 * <p>
 * Input:
 * 1
 * \
 * 2
 * / \
 * 3   4
 * <p>
 * Ouput:
 * [1, 3, 4, 2]
 * <p>
 * Explanation:
 * The root doesn't have left subtree, so the root itself is left boundary.
 * The leaves are node 3 and 4.
 * The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
 * So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 * <p>
 * <p>
 * Example 2
 * <p>
 * Input:
 * ____1_____
 * /          \
 * 2            3
 * / \          /
 * 4   5        6
 * / \      / \
 * 7   8    9  10
 * <p>
 * Ouput:
 * [1,2,4,7,8,9,10,6,3]
 * <p>
 * Explanation:
 * The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 * The leaves are node 4,7,8,9,10.
 * The right boundary are node 1,3,6,10. (10 is the right-most node).
 * So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 */
public class Leetcode545 {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            return list;
        }
        LBTrav(root.left, list);
        LeafTrav(root, list);
        RBT(root.right, list);
        return list;

    }

    /**
     * 右边界
     *
     * @param root
     * @param list
     */
    private void RBT(TreeNode root, List<Integer> list) {
        if (root != null && root.right != null) {
            RBT(root.right, list);
        } else if (root != null && root.left != null) {
            RBT(root.left, list);
        }
        if (root != null && !(root.left == null && root.right == null)) {
            list.add(root.val);
        }
    }

    /**
     * 叶子节点
     *
     * @param root
     * @param list
     */
    private void LeafTrav(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        if (root != null && root.left == null && root.right == null) {
            list.add(root.val);
        }
        LeafTrav(root.left, list);
        LeafTrav(root.right, list);
    }

    /**
     * 左边界
     *
     * @param root
     * @param list
     */
    private void LBTrav(TreeNode root, List<Integer> list) {
        if (root != null && !(root.left == null && root.right == null)) {
            list.add(root.val);
        }
        if (root != null && root.left != null) {
            LBTrav(root.left, list);
        } else if (root != null && root.right != null) {
            LBTrav(root.right, list);
        }

    }
}
