package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 15:43
 * @Description: Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [1,null,3,2],
 * [3,2,null,1],
 * [3,1,null,null,2],
 * [2,1,3],
 * [1,null,2,null,3]
 * ]
 * Explanation:
 * The above output corresponds to the 5 unique BST's shown below:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */
public class Leetcode95 {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return new ArrayList<TreeNode>();
        return generateSubTree(1, n);
    }

    /**
     * @param start 左闭区间
     * @param end   右闭区间
     * @return
     */
    public ArrayList<TreeNode> generateSubTree(int start, int end) {
        //结果集
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        //start > end 表明越界了，无法产生新的子节点，添加空节点
        if (start > end) {
            result.add(null);
            return result;
        }
        for (int val = start; val <= end; val++)
            //start...rootVal-1构成左子树
            for (TreeNode left : generateSubTree(start, val - 1))
                //rootVal+1...end构成右子树
                for (TreeNode right : generateSubTree(val + 1, end)) {
                    TreeNode root = new TreeNode(val);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
        return result;
    }
}
