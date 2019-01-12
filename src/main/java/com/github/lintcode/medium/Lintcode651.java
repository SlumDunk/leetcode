package com.github.lintcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/11/19 21:37
 * @Description: Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * <p>
 * If two nodes are in the same row and column, the order should be from left to right.
 * <p>
 * Example
 * Given binary tree {3,9,20,#,#,15,7}
 * <p>
 * 3
 * /\
 * /  \
 * 9  20
 * /\
 * /  \
 * 15   7
 * Return its vertical order traversal as:
 * [[9],[3,15],[20],[7]]
 * <p>
 * Given binary tree {3,9,8,4,0,1,7}
 * <p>
 * 3
 * /\
 * /  \
 * 9   8
 * /\  /\
 * /  \/  \
 * 4  01   7
 * Return its vertical order traversal as:
 * [[4],[9],[3,0,1],[8],[7]]
 */
public class Lintcode651 {
    class MapKeyComparator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return Integer.compare(o1, o2);
        }
    }

    class DecorateNode {
        TreeNode node;
        int position;

        public DecorateNode(TreeNode node, int position) {
            this.node = node;
            this.position = position;
        }
    }

    Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

    /**
     * @param root: the root of tree
     * @return: the vertical order traversal
     */
    public List<List<Integer>> verticalOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        } else {
            DecorateNode top = new DecorateNode(root, 0);
            Queue<DecorateNode> queue = new LinkedList<DecorateNode>();
            queue.offer(top);
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    DecorateNode currentNode = queue.poll();
                    List<Integer> values = map.getOrDefault(currentNode.position, new ArrayList<Integer>());
                    values.add(currentNode.node.val);
                    map.put(currentNode.position, values);
                    if (currentNode.node.left != null) {
                        queue.offer(new DecorateNode(currentNode.node.left, currentNode.position - 1));
                    }
                    if (currentNode.node.right != null) {
                        queue.offer(new DecorateNode(currentNode.node.right, currentNode.position + 1));
                    }
                    size--;
                }
            }

            map = sortMapKey(map);
            for (List<Integer> value : map.values()) {
                result.add(value);
            }
            return result;
        }
    }

    private Map<Integer, List<Integer>> sortMapKey(Map<Integer, List<Integer>> map) {
        if (map == null || map.isEmpty()) {
            return null;
        } else {
            Map<Integer, List<Integer>> sortMap = new TreeMap<>(new MapKeyComparator());
            sortMap.putAll(map);
            return sortMap;
        }
    }
}
