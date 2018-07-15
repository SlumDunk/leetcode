package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary search tree with non-negative values, find the minimum absolute difference between values of any two nodes.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * \
 * 3
 * /
 * 2
 * <p>
 * Output:
 * 1
 * <p>
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 * Note: There are at least two nodes in this BST.
 */
public class Leetcode530 {
    public static void main(String[] args) {

    }

    public int getMinimumDifference(TreeNode root) {
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
