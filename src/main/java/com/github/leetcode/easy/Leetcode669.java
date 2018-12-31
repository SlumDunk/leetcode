package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R, trim the tree so that all its elements lies in [L, R]
 * (R >= L). You might need to change the root of the tree, so the result should return the new root of the trimmed binary search
 * tree.
 * <p>
 * Example 1:
 * Input:
 * 1
 * / \
 * 0   2
 * <p>
 * L = 1
 * R = 2
 * <p>
 * Output:
 * 1
 * \
 * 2
 * Example 2:
 * Input:
 * 3
 * / \
 * 0   4
 * \
 * 2
 * /
 * 1
 * <p>
 * L = 1
 * R = 3
 * <p>
 * Output:
 * 3
 * /
 * 2
 * /
 * 1
 *
 * @author liuzhongda
 */
public class Leetcode669 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);
        Leetcode669 leetcode669 = new Leetcode669();
        TreeNode resultNode = leetcode669.trimBST(root, 1, 2);
        System.out.println(resultNode);

    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        } else if (root.val < L) {//节点值小于左边界
            return trimBST(root.right, L, R);
        } else if (root.val > R) {//节点值大于右边界
            return trimBST(root.left, L, R);
        } else {//节点值在两者之间，保留节点，对左右子节点递归裁剪
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }

}
