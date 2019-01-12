package com.github.lintcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 1/11/19 20:54
 * @Description: If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.
 * <p>
 * For each integer in this list:
 * <p>
 * The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 * The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
 * The units digit represents the value V of this node, 0 <= V <= 9.
 * Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.
 * Example
 * Given nums = [113, 215, 221], return 12.
 * <p>
 * Explanation:
 * The tree that the list represents is:
 * 3
 * / \
 * 5   1
 * <p>
 * The path sum is (3 + 5) + (3 + 1) = 12.
 * Given nums = [113, 221], return 4.
 * <p>
 * Explanation:
 * The tree that the list represents is:
 * 3
 * \
 * 1
 * <p>
 * The path sum is (3 + 1) = 4.
 */
public class Lintcode863 {
    int sum = 0;
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    /**
     * @param nums: a list of integers
     * @return: return an integer
     */
    public int pathSum(int[] nums) {
        // write your code here
        for (int num : nums) {
            map.put(num / 10, num % 10);
        }
        dfs(11, 0);
        return sum;

    }

    public void dfs(int root, int temp) {
        if (map.get(root) == null) {
            return;
        } else {
            int depth = root / 10;
            int pos = root % 10;

            int leftKey = (depth + 1) * 10 + pos * 2 - 1;
            int rightKey = leftKey + 1;

            if (map.get(leftKey) == null && map.get(rightKey) == null) {
                sum += temp + map.get(root);
            } else {
                temp += map.get(root);
                if (map.get(leftKey) != null) {
                    dfs(leftKey, temp);
                }
                if (map.get(rightKey) != null) {
                    dfs(rightKey, temp);
                }
            }
        }
    }
}
