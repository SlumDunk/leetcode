package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 1/10/19 20:53
 * @Description:
 */
public class Lintcode650 {
    /*
    * @param root: the root of binary tree
    * @return: collect and remove all leaves
    */
    public List<List<Integer>> findLeaves(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

        int depth = dfs(root, map);
        for (int i = 1; i <= depth; i++) {
            result.add(map.get(i));
        }
        return result;
    }

    public int dfs(TreeNode root, Map<Integer, List<Integer>> map) {
        if (root == null) {
            return 0;
        } else {
            int leftHeight = dfs(root.left, map);
            int rightHeight = dfs(root.right, map);
            int height = Math.max(leftHeight, rightHeight) + 1;
            List<Integer> list = map.getOrDefault(height, new ArrayList<Integer>());
            list.add(root.val);
            map.put(height, list);
            return height;
        }
    }
}
