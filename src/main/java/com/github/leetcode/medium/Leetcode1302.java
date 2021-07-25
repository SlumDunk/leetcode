package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a binary tree, return the sum of values of its deepest leaves.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
 * Output: 15
 * Example 2:
 * <p>
 * Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
 * Output: 19
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 104].
 * 1 <= Node.val <= 100
 */
public class Leetcode1302 {
    int maxLevel = 1;
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int deepestLeavesSum(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }
        helper(root, 1);

        for (int i = 0; i < map.get(maxLevel).size(); i++) {
            ans += map.get(maxLevel).get(i);
        }
        return ans;
    }

    private void helper(TreeNode root, int level) {
        if (root == null) {
            return;
        } else {
            List<Integer> valueList = map.getOrDefault(level, new ArrayList<>());
            valueList.add(root.val);
            map.put(level, valueList);
            maxLevel = Math.max(maxLevel, level);
            helper(root.left, level + 1);
            helper(root.right, level + 1);
        }
    }
}
