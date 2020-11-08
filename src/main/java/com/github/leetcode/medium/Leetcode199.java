package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 14:03
 * @Description: Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example:
 * <p>
 * Input: [1,2,3,null,5,null,4]
 * Output: [1, 3, 4]
 * Explanation:
 * <p>
 * 1            <---
 * /   \
 * 2     3         <---
 * \     \
 * 5     4       <---
 */
public class Leetcode199 {
    /**
     * O(n)
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        //广度优先遍历，记住每一层的最后一个元素
        List<Integer> result = new LinkedList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if (root == null) {
            return result;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            //这一层的节点个数
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
                //最右的节点，加入结果集
                if (size == 0) {
                    result.add(node.val);
                }
            }
        }
        return result;
    }
}
