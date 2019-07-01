package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 12:59
 * @Description: If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.
 * <p>
 * For each integer in this list:
 * <p>
 * The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 * The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
 * The units digit represents the value V of this node, 0 <= V <= 9.
 * <p>
 * <p>
 * Given a list of ascending three-digits integers representing a binary tree with the depth smaller than 5, you need to return the sum of all paths from the root towards the leaves.
 * <p>
 * Example 1:
 * <p>
 * Input: [113, 215, 221]
 * Output: 12
 * Explanation:
 * The tree that the list represents is:
 * 3
 * / \
 * 5   1
 * <p>
 * The path sum is (3 + 5) + (3 + 1) = 12.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: [113, 221]
 * Output: 4
 * Explanation:
 * The tree that the list represents is:
 * 3
 * \
 * 1
 * <p>
 * The path sum is (3 + 1) = 4.
 */
public class Leetcode666 {
    /**
     * 所有路径的和
     */
    private int sum = 0;

    public int pathSum(int[] nums) {
        if (nums.length == 0) return 0;
        // key = level, pos pair, value = value
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int key = num / 10;
            int value = num % 10;
            map.put(key, value);
        }
        //没有根节点
        if (!map.containsKey(11)) return 0;
        dfs(11, map, map.get(11));
        return sum;
    }

    /**
     * DFS
     * @param node 当前节点
     * @param map
     * @param current 当前累计前缀路径的和
     */
    private void dfs(int node, Map<Integer, Integer> map, int current) {
        List<Integer> childs = getChilds(node, map);
        if (childs.isEmpty()) {
            sum += current;
            return;
        }
        for (int key : childs) {
            dfs(key, map, current + map.get(key));
        }
    }

    /**
     * 返回当前节点的子节点
     * @param node
     * @param map
     * @return
     */
    private List<Integer> getChilds(int node, Map<Integer, Integer> map) {
        List<Integer> childs = new LinkedList<>();
        int childLevel = (node / 10) + 1;
        int parentPos = node % 10;
        // 1 -> 1, 2     2 -> 3, 4
        int childPos1 = parentPos * 2 - 1;
        int childPos2 = parentPos * 2;
        int key1 = childLevel * 10 + childPos1;
        int key2 = childLevel * 10 + childPos2;
        if (map.containsKey(key1)) childs.add(key1);
        if (map.containsKey(key2)) childs.add(key2);
        return childs;
    }
}
