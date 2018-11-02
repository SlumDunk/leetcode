package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/1/18 20:50
 * @Description: One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.
 * <p>
 * _9_
 * /   \
 * 3     2
 * / \   / \
 * 4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.
 * <p>
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree. Find an algorithm without reconstructing the tree.
 * <p>
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * <p>
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 * <p>
 * Example 1:
 * <p>
 * Input: "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Output: true
 * Example 2:
 * <p>
 * Input: "1,#"
 * Output: false
 * Example 3:
 * <p>
 * Input: "9,#,#,1"
 * Output: false
 */
public class Leetcode331 {

    public static void main(String[] args) {
        Leetcode331 leetcode331=new Leetcode331();
        leetcode331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }
    public boolean isValidSerialization(String preorder) {
        String[] arrayPreOrder = preorder.split(",");
        if (findTree(arrayPreOrder, 0) == arrayPreOrder.length) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    private int findTree(String[] arrayPreOrder, int start) {
        if (arrayPreOrder.length - start == 0) {
            return -1;
        }
        if (arrayPreOrder[start].equals("#")) {
            return start + 1;
        }
        int left = findTree(arrayPreOrder, start + 1);
        if (left < 0) {
            return -1;
        }
        int right = findTree(arrayPreOrder, left);
        if (right < -1) {
            return -1;
        }
        return right;
    }
}
