package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 10/24/18 17:42
 * @Description: Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p>
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its level order traversal as:
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Leetcode102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //返回的最终结果
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        //用来存放每一层的节点
        Queue<TreeNode> queue = new LinkedList<>();

        //处理第一个节点（root）
        if (root == null)
            return result;
        else {
            List<Integer> temp = null;//存放暂时的结果
            TreeNode currentNode = null;
            queue.offer(root);
            while (!queue.isEmpty()) {
                //这一层的节点数量
                int size = queue.size();
                temp = new ArrayList<>();
                while (size > 0) {
                    currentNode = queue.poll();
                    temp.add(currentNode.val);
                    if (currentNode.left != null) {//左子树非空
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {//右子树非空
                        queue.add(currentNode.right);
                    }
                    size--;
                }
                result.add(temp);
            }
        }

        return result;
    }
}
