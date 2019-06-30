package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/27/19 08:13
 * @Description: A full binary tree is a binary tree where each node has exactly 0 or 2 children.
 * <p>
 * Return a list of all possible full binary trees with N nodes.  Each element of the answer is the root node of one possible tree.
 * <p>
 * Each node of each tree in the answer must have node.val = 0.
 * <p>
 * You may return the final list of trees in any order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 7
 * Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,null,0,0]]
 * Explanation:
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 20
 */
public class Leetcode894 {
    public static void main(String[] args) {
        Leetcode894 leetcode894=new Leetcode894();
        leetcode894.allPossibleFBT(7);
    }
    /**
     * 搜索+记忆
     */
    private Map<Integer, List<TreeNode>> map = new HashMap<>();

    /**
     * 7
     * @param N
     * @return
     */
    public List<TreeNode> allPossibleFBT(int N) {
        if (!map.containsKey(N)) {
            map.put(N, new ArrayList<>());
            if (N == 1) {//只有一个节点
                map.get(N).add(new TreeNode(0));
            } else if (N % 2 == 1) {//奇数个节点
                for (int i = 0; i < N; ++i) {
                    int j = N - 1 - i;
                    for (TreeNode left : allPossibleFBT(i)) {
                        for (TreeNode right : allPossibleFBT(j)) {
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = right;
                            map.get(N).add(root);
                        }
                    }
                }
            }
        }
        return map.get(N);
    }
}
