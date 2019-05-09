package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

/**
 * @Author: zerongliu
 * @Date: 3/22/19 20:50
 * @Description: Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * The encoded string should be as compact as possible.
 * <p>
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class Leetcode449 {
    class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) {
                return "#";
            } else {
                return String.valueOf(root.val) + "," + serialize(root.left) + "," + serialize(root.right);
            }
        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] nodes = data.split(",");
            return deserialize(nodes, new int[]{
                    0
            });
        }

        private TreeNode deserialize(String[] nodes, int[] idx) {
            if (nodes[idx[0]].equals("#")) {
                idx[0]++;
                return null;
            }

            TreeNode root = new TreeNode(Integer.parseInt(nodes[idx[0]++]));
            root.left = deserialize(nodes, idx);
            root.right = deserialize(nodes, idx);
            return root;
        }
    }
}
