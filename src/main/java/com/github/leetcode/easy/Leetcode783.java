package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a Binary Search Tree (BST) with the root node root, return the minimum difference between the values of any two different nodes in the tree.
 * <p>
 * Example :
 * <p>
 * Input: root = [4,2,6,1,3,null,null]
 * Output: 1
 * Explanation:
 * Note that root is a TreeNode object, not an array.
 * <p>
 * The given tree [4,2,6,1,3,null,null] is represented by the following diagram:
 * <p>
 * 4
 * /   \
 * 2      6
 * / \
 * 1   3
 * <p>
 * while the minimum difference in this tree is 1, it occurs between node 1 and node 2, also between node 3 and node 2.
 * Note:
 * <p>
 * The size of the BST will be between 2 and 100.
 * The BST is always valid, each node's value is an integer, and each node's value is different.
 */
public class Leetcode783 {
    public static void main(String[] args) {

    }

    public int minDiffInBST(TreeNode root) {
        if (root == null) {
            return -1;
        } else {
            List<Integer> dataList = new ArrayList<Integer>();
            getDataList(root, dataList);
            Collections.sort(dataList);
            if (dataList.size() <= 1) {
                return -1;
            } else {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < dataList.size() - 1; i++) {
                    min = Math.min(min, dataList.get(i + 1) - dataList.get(i));
                }
                return min;
            }
        }
    }

    private void getDataList(TreeNode root, List<Integer> dataList) {
        if (root != null) {
            dataList.add(root.val);
            getDataList(root.left, dataList);
            getDataList(root.right, dataList);
        }


    }
}
