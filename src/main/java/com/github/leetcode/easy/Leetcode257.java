package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 12/30/18 20:15
 * @Description: Given a binary tree, return all root-to-leaf paths.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class Leetcode257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        List<Integer> temp = new ArrayList<Integer>();
        findTreePaths(root, temp, result);
        return result;
    }

    /**
     * @param root
     * @param temp   中间缓存结果
     * @param result 结果集
     */
    public void findTreePaths(TreeNode root, List<Integer> temp, List<String> result) {
        if (root == null) {
            return;
        }
        //走到叶子节点
        if (root.left == null && root.right == null) {
            temp.add(root.val);
            result.add(generatePath(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        temp.add(root.val);
        //副本，防止在递归过程中被篡改
        List<Integer> copy = new ArrayList<Integer>(temp);
        //往左走
        findTreePaths(root.left, temp, result);
        //往右走
        findTreePaths(root.right, copy, result);
    }

    /**
     * 产生路径字符串
     *
     * @param temp
     * @return
     */
    public String generatePath(List<Integer> temp) {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < temp.size(); i++) {
            buffer.append(temp.get(i));
            if (i != temp.size() - 1) {
                buffer.append("->");
            }
        }
        return buffer.toString();
    }
}
