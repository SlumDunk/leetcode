package com.github.leetcode.easy;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 12/30/18 11:17
 * @Description:
 */
public class Leetcode107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        //广度优先遍历，再reverse
        List<List<Integer>> result = new ArrayList<>();
        levelOrderBottom(root, 0, result);
        //翻转结果集
        Collections.reverse(result);
        return result;
    }

    /**
     * @param root   树节点
     * @param level  层级
     * @param result 结果集
     */
    public void levelOrderBottom(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (result.size() < level + 1) {//每个层级的集合
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        levelOrderBottom(root.left, level + 1, result);
        levelOrderBottom(root.right, level + 1, result);

    }
}
