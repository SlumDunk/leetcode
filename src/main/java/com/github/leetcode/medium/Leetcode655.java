package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/25/19 14:45
 * @Description: Print a binary tree in an m*n 2D string array following these rules:
 * <p>
 * The row number m should be equal to the idx of the given binary tree.
 * The column number n should always be an odd number.
 * The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them.
 * Each unused space should contain an empty string "".
 * Print the subtrees following the same rules.
 * Example 1:
 * Input:
 * 1
 * /
 * 2
 * Output:
 * [["", "1", ""],
 * ["2", "", ""]]
 * Example 2:
 * Input:
 * 1
 * / \
 * 2   3
 * \
 * 4
 * Output:
 * [["", "", "", "1", "", "", ""],
 * ["", "2", "", "", "", "3", ""],
 * ["", "", "4", "", "", "", ""]]
 * Example 3:
 * Input:
 * 1
 * / \
 * 2   5
 * /
 * 3
 * /
 * 4
 * Output:
 * <p>
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 * ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 * ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 * ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 * Note: The idx of binary tree is in the range of [1, 10].
 */
public class Leetcode655 {
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> result = new ArrayList<>();
        int height = getHeight(root);
        int width = (int) Math.pow(2, height) - 1;
        for (int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < width; j++) {
                list.add("");
            }
            result.add(list);
        }
        helper(result, root, 0, 0, width);
        return result;
    }

    /**
     * 递归
     *
     * @param result
     * @param node
     * @param level  层级
     * @param left   数组中的左位置
     * @param right  数组中的右位置
     */
    private void helper(List<List<String>> result, TreeNode node, int level, int left, int right) {
        if (node == null) return;
        int index = -1;
        index = left + (right - left) / 2;
        result.get(level).set(index, String.valueOf(node.val));
        helper(result, node.left, level + 1, left, index - 1);
        helper(result, node.right, level + 1, index + 1, right);

    }

    /**
     * 获取树的高度
     *
     * @param node
     * @return
     */
    private int getHeight(TreeNode node) {
        if (node == null) return 0;
        int left = 1 + getHeight(node.left);
        int right = 1 + getHeight(node.right);
        return Math.max(left, right);
    }
}
