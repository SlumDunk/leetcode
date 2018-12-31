package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 13:26
 * @Description: Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
 * <p>
 * <p>
 * <p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 * <p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 * <p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * Both of the given trees will have between 1 and 100 nodes.
 */
public class Leetcode872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        //先左节点，再右节点
        ArrayList<Integer> leafList1 = new ArrayList<Integer>();
        ArrayList<Integer> leafList2 = new ArrayList<Integer>();
        generateLeafList(root1, leafList1);
        generateLeafList(root2, leafList2);

        if (leafList1.size() != leafList2.size()) {
            return Boolean.FALSE;
        } else {
            //比较两个list结果是否完全一致
            for (int i = 0; i < leafList1.size(); i++) {
                if (leafList1.get(i) != leafList2.get(i)) {
                    return Boolean.FALSE;
                }
            }
            return Boolean.TRUE;
        }

    }

    /**
     * @param root     树节点
     * @param leafList 叶子结果集
     */
    private void generateLeafList(TreeNode root, ArrayList<Integer> leafList) {
        if (root.left == null && root.right == null) {
            leafList.add(root.val);
        } else {
            if (root.left != null) {
                generateLeafList(root.left, leafList);
            }
            if (root.right != null) {
                generateLeafList(root.right, leafList);
            }
        }

    }
}
