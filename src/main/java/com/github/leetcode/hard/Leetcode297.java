package com.github.leetcode.hard;

import apple.laf.JRSUIUtils;
import com.github.leetcode.vo.TreeNode;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 22:03
 * @Description: Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Example:
 * <p>
 * You may serialize the following tree:
 * <p>
 * 1
 * / \
 * 2   3
 * / \
 * 4   5
 * <p>
 * as "[1,2,3,null,null,4,5]"
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class Leetcode297 {
    public static void main(String[] args) {
        Codec codec = new Codec();
        String data = "[5,2,3,null,null,2,4,3,1]";
        codec.deserialize(data);
    }

    static class Codec {

        /**
         * 序列化一棵树
         *
         * @param root
         * @return
         */
        public String serialize(TreeNode root) {
            StringBuilder buffer = new StringBuilder("[");
            //先处理根节点，再处理左树，最后处理右子树
            buildString(root, buffer);
            buffer.deleteCharAt(buffer.length() - 1);
            buffer.append("]");
            return buffer.toString();
        }

        /**
         * 通过树构造出字符串
         *
         * @param root
         * @param buffer
         */
        private void buildString(TreeNode root, StringBuilder buffer) {
            if (root == null) {
                buffer.append("null").append(",");
            } else {
                buffer.append(root.val).append(",");
                buildString(root.left, buffer);
                buildString(root.right, buffer);
            }
        }

        /**
         * 反序列化一棵树
         *
         * @param data
         * @return
         */
        public TreeNode deserialize(String data) {
            if (data == null || data.length() <= 2) {
                return null;
            } else {
                data = data.substring(1, data.length() - 1);
                Deque<String> nodes = new LinkedList<>();
                nodes.addAll(Arrays.asList(data.split(",")));
                return buildTree(nodes);

            }
        }

        /**
         * 通过字符串构造出树
         *
         * @param nodes
         * @return
         */
        private TreeNode buildTree(Deque<String> nodes) {
            //先处理根节点
            String val = nodes.remove();
            if ("null".equals(val)) {
                return null;
            } else {
                TreeNode node = new TreeNode(Integer.valueOf(val));
                node.left = buildTree(nodes);
                node.right = buildTree(nodes);
                return node;
            }
        }

    }
}
