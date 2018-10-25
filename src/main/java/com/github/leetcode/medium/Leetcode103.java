package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 17:50
 * @Description: Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Leetcode103 {
    /**
     * 递归方式 <br />
     * 重要的是记录层级, 加上一个标识标识是否集合反向<br />
     *
     * 1ms<br />
     * eats96.02% of java submissions
     *
     * @author jacksen
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        levelRecursion(root, result, 0);

        return result;
    }

    /**
     * 可以直接通过level层级判断是否需要addFirst，不必要再添加额外的标识
     *
     * @param node
     * @param result
     * @param level
     */
    private void levelRecursion(TreeNode node, List<List<Integer>> result,
                                 int level) {
        if (node == null) {
            return;
        }
        if (result.size() < level + 1) {// 说明还需要添加一行
            result.add(new LinkedList<Integer>());
        }
        if (level % 2 != 0) {
            ((LinkedList<Integer>) result.get(level)).addFirst(node.val);
        } else {
            result.get(level).add(node.val);
        }

        levelRecursion(node.left, result, level + 1);
        levelRecursion(node.right, result, level + 1);
    }
}
