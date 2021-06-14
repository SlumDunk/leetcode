package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given two binary search trees root1 and root2.
 * <p>
 * Return a list containing all the integers from both trees sorted in ascending order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: root1 = [2,1,4], root2 = [1,0,3]
 * Output: [0,1,1,2,3,4]
 * Example 2:
 * <p>
 * Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
 * Output: [-10,0,0,1,2,5,7,10]
 * Example 3:
 * <p>
 * Input: root1 = [], root2 = [5,1,7,0,2]
 * Output: [0,1,2,5,7]
 * Example 4:
 * <p>
 * Input: root1 = [0,-10,10], root2 = []
 * Output: [-10,0,10]
 * Example 5:
 * <p>
 * <p>
 * Input: root1 = [1,null,8], root2 = [8,1]
 * Output: [1,1,8,8]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Each tree has at most 5000 nodes.
 * Each node's value is between [-10^5, 10^5].
 */
public class Leetcode1305 {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> ans = new ArrayList<>();
        helper(ans, root1);
        helper(ans, root2);
        Collections.sort(ans);
        return ans;
    }

    private void helper(List<Integer> ans, TreeNode node) {
        if (node == null) {
            return;
        } else {
            helper(ans, node.left);
            ans.add(node.val);
            helper(ans, node.right);
        }
    }
}
