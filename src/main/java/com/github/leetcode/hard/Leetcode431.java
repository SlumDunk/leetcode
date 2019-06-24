package com.github.leetcode.hard;

import com.github.leetcode.vo.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/8/19 09:14
 * @Description: Design an algorithm to encode an N-ary tree into a binary tree and decode the binary tree to get the original N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. Similarly, a binary tree is a rooted tree in which each node has no more than 2 children. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that an N-ary tree can be encoded to a binary tree and this binary tree can be decoded to the original N-nary tree structure.
 * <p>
 * For example, you may encode the following 3-ary tree to a binary tree in this way:
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Note that the above is just an example which might or might not work. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * N is in the range of [1, 1000]
 * Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.
 */
public class Leetcode431 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    class Codec {

        /**
         * Encodes an n-ary tree to a binary tree.

         *         1
         *          \
         *          3
         *        /   \
         *       2    5
         *      /    /
         *     4    6
         *     第一个子节点作为右节点，其它兄弟节点作为做节点
         *
         * @param root
         * @return
         */
        public TreeNode encode(Node root) {
            if (root == null)
                return null;
            TreeNode res = new TreeNode(root.val);
            if (root.children.size() == 0)
                return res;
            res.right = encode(root.children.get(0));
            TreeNode cur = res.right;
            for (int i = 1; i < root.children.size(); i++) {
                cur.left = encode(root.children.get(i));
                cur = cur.left;
            }
            return res;
        }


        /**
         * Decodes your binary tree to an n-ary tree.
         *
         *          1
         *          \
         *          3
         *        /   \
         *       2    5
         *      /    /
         *     4    6
         *
         * @param root
         * @return
         */
        public Node decode(TreeNode root) {
            if (root == null)
                return null;
            Node res = new Node(root.val, new LinkedList<>());
            if (root.right == null)
                return res;
            res.children.add(decode(root.right));
            while (root.right.left != null) {
                res.children.add(decode(root.right.left));
                root.right = root.right.left;
            }
            return res;
        }
    }
}
