package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.*;

/**
 * Given the root of a binary tree, return the lowest common ancestor (LCA) of two given nodes, p and q. If either node p or q does not exist in the tree, return null. All values of the nodes in the tree are unique.
 * <p>
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor of two nodes p and q in a binary tree T is the lowest node that has both p and q as descendants (where we allow a node to be a descendant of itself)". A descendant of a node x is a node y that is on the path from node x to some leaf node.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * Output: 3
 * Explanation: The LCA of nodes 5 and 1 is 3.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * Output: 5
 * Explanation: The LCA of nodes 5 and 4 is 5. A node can be a descendant of itself according to the definition of LCA.
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 10
 * Output: null
 * Explanation: Node 10 does not exist in the tree, so return null.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * <p>
 * <p>
 * Follow up: Can you find the LCA traversing the tree, without checking nodes existence?
 */
public class Leetcode1644 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pPath = new ArrayList<>();
        findPath(pPath, root, p);
        List<TreeNode> qPath = new ArrayList<>();
        findPath(qPath, root, q);

        TreeNode ans = null;
        for (int i = 0; i < pPath.size() && i < qPath.size(); i++) {
            if (pPath.get(i) == qPath.get(i)) {
                ans = pPath.get(i);
            }
        }
        return ans;
    }

    private boolean findPath(List<TreeNode> path, TreeNode node, TreeNode target) {
        if (node == null) {
            return false;
        }
        path.add(node);

        //找到了
        if (node == target || findPath(path, node.left, target) || findPath(path, node.right, target)) {
            return true;
        }

        path.remove(path.size() - 1);
        return false;
    }

}
