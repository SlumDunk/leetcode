package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 18:33
 * @Description: Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 * <p>
 * Note: If the given node has no in-order successor in the tree, return null.
 */
public class Leetcode285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        //寻找节点p的下一个节点
        //如果p的右子树非空，寻找右子树中序遍历第一个开始的节点
        TreeNode curNode = null;
        if (p.right != null) {
            curNode = p.right;
            while (curNode.left != null) {
                curNode = curNode.left;
            }
            return curNode;
        }
        //如果右子树为空,寻找p的下一个节点，下个节点是最邻近p且值比p大的节点
        //利用二分搜索树节点值的特性
        while (root != null) {
            //向左走
            if (root.val > p.val) {
                curNode = root;
                root = root.left;
            } else if (root.val < p.val) {//向右走
                root = root.right;
            } else {//找到p节点了
                break;
            }
        }
        return curNode;
    }
}
