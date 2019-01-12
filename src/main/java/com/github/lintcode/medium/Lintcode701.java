package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/12/19 10:41
 * @Description: Given the root of a binary search tree and 2 numbers min and max, trim the tree such that all the numbers in the new tree are between min and max (inclusive). The resulting tree should still be a valid binary search tree. So, if we get this tree as input:
 * http://www.ardendertat.com/wp-content/uploads/2012/01/bst.png
 * and we’re given min value as 5 and max value as 13, then the resulting binary search tree should be:
 * http://www.ardendertat.com/wp-content/uploads/2012/01/bst_trim.png
 * <p>
 * Example
 * Given binary search tree:
 * {8,3,10,1,6,#,14,#,#,4,7,13} and minVal = 5, maxVal = 13.
 * <p>
 * One possible answer: {8, 6, 10, #, 7, #, 13}
 */
public class Lintcode701 {
    /**
     * @param root:    given BST
     * @param minimum: the lower limit
     * @param maximum: the upper limit
     * @return: the root of the new tree
     */
    public TreeNode trimBST(TreeNode root, int minimum, int maximum) {
        // write your code here
        if (root == null) {
            return root;
        } else {
            return trimTree(root, minimum, maximum);
        }
    }

    public TreeNode trimTree(TreeNode root, int minimum, int maximum) {
        if (root.val > maximum) {
            if (root.left != null) {
                return trimTree(root.left, minimum, maximum);
            } else {
                return null;
            }
        }
        if (root.val < minimum) {
            if (root.right != null) {
                return trimTree(root.right, minimum, maximum);
            } else {
                return null;
            }
        }
        if (root.left != null) {
            root.left = trimTree(root.left, minimum, maximum);
        }
        if (root.right != null) {
            root.right = trimTree(root.right, minimum, maximum);
        }
        return root;
    }
}
