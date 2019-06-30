package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 21:38
 * @Description: Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
 * <p>
 * Examples 1
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 * <p>
 * 5
 * /  \
 * 2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 */
public class Leetcode508 {
    /**
     * 存储每个和值出现的频率
     */
    Map<Integer, Integer> map;
    /**
     * 存储出现最多的次数
     */
    int cnt = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null)
            return new int[0];
        map = new HashMap<>();
        int curr = helper(root);

        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> met : map.entrySet()) {
            if (met.getValue() == cnt)
                res.add(met.getKey());
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++)
            ans[i] = res.get(i);
        return ans;
    }

    /**
     * @param root
     * @return
     */
    private int helper(TreeNode root) {
        if (root == null)
            return 0;

        int curr = root.val;
        if (root.left != null)
            curr += helper(root.left);
        if (root.right != null)
            curr += helper(root.right);

        int num = map.getOrDefault(curr, 0) + 1;
        cnt = Math.max(cnt, num);
        map.put(curr, num);

        return curr;
    }
}
