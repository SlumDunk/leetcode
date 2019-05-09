package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 5/7/19 14:37
 * @Description: Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * <p>
 * For example, you may serialize the following 3-ary tree
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * as [1 [3[5 6] 2 4]]. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * N is in the range of [1, 1000]
 * Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class Leetcode428 {
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

        // Encodes a tree to a single string.
        //1#3,2,4#5,6#null#null#null#null
        public String serialize(Node root) {
            if (root == null) return null;
            StringBuilder sb = new StringBuilder();
            Queue<Node> queue = new LinkedList<>();
            sb.append(root.val);
            sb.append("#");
            queue.offer(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    Node curr = queue.poll();
                    if (curr != null) {
                        List<Node> children = curr.children;
                        if (children == null || children.size() == 0) {
                            sb.append("null");
                        } else {
                            for (Node child :
                                    children) {
                                sb.append(child.val);
                                sb.append(",");
                                queue.offer(child);
                            }
                        }
                        sb.append("#");
                    }
                    size--;
                }
            }
            return sb.toString().substring(0, sb.length() - 1);
        }

        // Decodes your encoded data to tree.
        //1#3,2,4#5,6#null#null#null#null
        public Node deserialize(String data) {
            if (data == null) {
                return null;
            }
            Queue<Node> parents = new LinkedList<>();
            String[] elements = data.split("#");
            Node root = new Node(Integer.valueOf(elements[0]), null);
            parents.offer(root);
            for (int i = 1; i < elements.length; i++) {
                Node parent = parents.poll();
                String[] kids = elements[i].split(",");
                List<Node> children = new ArrayList<>();
                for (String kid :
                        kids) {
                    if (kid.length() == 0) continue;
                    if (kid.equals("null")) continue;
                    Node child = new Node(Integer.valueOf(kid), null);
                    children.add(child);
                    parents.offer(child);
                }
                parent.children = children;
            }
            return root;
        }
    }
}
