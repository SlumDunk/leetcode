package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 12/30/18 17:06
 * @Description: Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 * <p>
 * Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 * <p>
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * <p>
 * <p>
 * Note:
 * <p>
 * All of the nodes' values will be unique.
 * p and q are different and both values will exist in the BST.
 */
public class Leetcode235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //通过p和q的值范围确定在哪个分支
//        if (root.val > p.val && root.val > q.val) {
//            return lowestCommonAncestor(root.left, p, q);
//        } else if (root.val < p.val && root.val < q.val) {
//            return lowestCommonAncestor(root.right, p, q);
//        }
//        return root;
        //通过p和q的值范围确定在哪个分支
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                root = root.right;
            } else {
                return root;
            }
        }
        return null;
    }


    class Result {
        TreeNode parent;
        boolean isExists;

        public Result(TreeNode parent, boolean isExists) {
            this.parent = parent;
            this.isExists = isExists;
        }
    }

    TreeNode lowestCommonAncestor = null;

    public TreeNode lowestCommonAncestor__(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        } else {
            // helper(root,p,q);
            // return lowestCommonAncestor;
            return helper2(root, p, q);
        }
    }

    /**
     * 利用binary search tree特点
     *
     * @param node
     * @param p
     * @param q
     * @return
     */
    public TreeNode helper2(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        } else {
            if (node.val > p.val && node.val > q.val) {
                return helper2(node.left, p, q);
            } else if (node.val < p.val && node.val < q.val) {
                return helper2(node.right, p, q);
            } else {
                return node;
            }
        }
    }

    /**
     * 通用做法
     *
     * @param node
     * @param p
     * @param q
     * @return
     */
    public Result helper(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new Result(null, false);
        } else {
            Result current = null;
            if (node == p) {
                current = new Result(node, true);
            } else if (node == q) {
                current = new Result(node, true);
            }
            Result left = helper(node.left, p, q);
            Result right = helper(node.right, p, q);

            if (left.isExists && right.isExists) {
                if (lowestCommonAncestor == null) {
                    lowestCommonAncestor = node;
                }
            }
            if ((left.isExists || right.isExists) && current != null) {
                if (lowestCommonAncestor == null) {
                    lowestCommonAncestor = node;
                }
            }
            if (left.isExists || right.isExists || current != null) {
                return new Result(node, true);
            } else {
                return new Result(null, false);
            }
        }
    }


    /**
     * helper 简化版
     *
     * @param node
     * @param p
     * @param q
     * @return
     */
    public TreeNode helper3(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return null;
        } else {
            if (node == p || node == q) {
                return node;
            } else {
                TreeNode left = helper3(node.left, p, q);
                TreeNode right = helper3(node.right, p, q);

                if (left != null && right != null) {
                    return node;
                } else {
                    return left != null ? left : right;
                }
            }
        }
    }
}
