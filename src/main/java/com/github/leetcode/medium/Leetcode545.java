package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/8/19 17:41
 * @Description: Given a binary tree, return the values of its boundary in anti-clockwise directs starting from root. Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.  (The values of the nodes may still be duplicates.)
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
 * The right boundary are node 1,2,4. Note the anti-clockwise directs means you should output reversed right boundary.
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

    /**
     * O(n)
     * @param root
     * @return
     */
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
        RBTrav(root.right, list);

        return list;
    }

    /**
     * @param node
     * @param list
     */
    private void LBTrav(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        //非叶子节点
        if (!(node.left == null && node.right == null)) {
            list.add(node.val);
        }
        if (node.left != null) {
            LBTrav(node.left, list);
        } else if (node.right != null) {
            LBTrav(node.right, list);
        }
    }

    /**
     * @param node
     * @param list
     */
    private void LeafTrav(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(node.val);
            return;
        }
        LeafTrav(node.left, list);
        LeafTrav(node.right, list);
    }

    /**
     * @param node
     * @param list
     */
    private void RBTrav(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            return;
        }

        if (node.right != null) {
            RBTrav(node.right, list);
        } else {
            RBTrav(node.left, list);
        }

        list.add(node.val);
    }
}
