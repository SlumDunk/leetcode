package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/25/19 07:43
 * @Description:
 * Given a binary tree, return all duplicate subtrees. For each kind of duplicate subtrees, you only need to return the root node of any one of them.

Two trees are duplicate if they have the same structure with same node values.

Example 1:

1
/ \
2   3
/   / \
4   2   4
/
4
The following are two duplicate subtrees:

2
/
4
and

4
Therefore, you need to return above trees' root in the form of a list.
 */
public class Leetcode652 {
    Map<Integer, List<Count>> counts = new HashMap<>();

    private static class Count {
        /**
         * 重复子树的个数
         */
        int count;
        /**
         * 树节点
         */
        TreeNode tree;

        public Count(TreeNode tree, int count){
            this.tree = tree;
            this.count = count;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> result = new ArrayList<>();
        addDuplicates(root, result);
        return result;
    }

    /**
     * 计算树的哈希值并判断是否重复
     * @param root
     * @param result
     * @return
     */
    private int addDuplicates(TreeNode root, List<TreeNode> result){
        if (root == null){
            return 1000;
        }

        int hash = root.val;
        hash = hash * 31 + addDuplicates(root.left, result);
        hash = hash * 31 + addDuplicates(root.right, result);
        addCandidate(hash, root, result);
        return hash;
    }

    /**
     * 将树加入坑中
     * @param hash
     * @param tree
     * @param result
     */
    private void addCandidate(int hash, TreeNode tree, List<TreeNode> result){
        List<Count> bucket = counts.computeIfAbsent(hash, (unused) -> new ArrayList());
        boolean found = false;
        for (Count count : bucket){
            if (deepEqual(tree, count.tree)){
                if (++count.count == 2){
                    result.add(tree);
                }
                found = true;
                break;
            }
        }
        if (!found){
            Count newCount = new Count(tree, 1);
            bucket.add(newCount);
        }
    }

    /**
     * 比较两棵子树是否相等
     * @param tree1
     * @param tree2
     * @return
     */
    private boolean deepEqual(TreeNode tree1, TreeNode tree2){
        if (tree1 == null && tree2 == null){
            return true;
        } else if (tree1 == null || tree2 == null || tree1.val != tree2.val){
            return false;
        }
        boolean equal = deepEqual(tree1.left, tree2.left)
                && deepEqual(tree1.right, tree2.right);
        return equal;
    }
}
