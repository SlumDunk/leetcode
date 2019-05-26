package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 5/25/19 15:44
 * @Description: Return any binary tree that matches the given preorder and postorder traversals.
 * <p>
 * Values in the traversals pre and post are distinct positive integers.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
 * Output: [1,2,3,4,5,6,7]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= pre.length == post.length <= 30
 * pre[] and post[] are both permutations of 1, 2, ..., pre.length.
 * It is guaranteed an answer exists. If there exists multiple answers, you can return any of them.
 */
public class Leetcode889 {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        int len = pre.length, index = 0;
        if (len == 0) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        if (len == 1) {
            return root;
        }

        for (int i = 0; i < len; i++) {
            if (pre[1] == post[i]) {
                index = i + 1;
            }
        }
        //pre第一个节点是根节点
        root.left = constructFromPrePost(Arrays.copyOfRange(pre, 1, index + 1), Arrays.copyOfRange(post, 0, index));
        //post最后一个节点是根节点
        root.right = constructFromPrePost(Arrays.copyOfRange(pre, index + 1, len), Arrays.copyOfRange(post, index, len - 1));
        return root;
    }
}
