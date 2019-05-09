package com.github.leetcode.medium;

import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 11/1/18 20:50
 * @Description: One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's frequency. If it is a null node, we record using a sentinel frequency such as #.
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
 * Each comma separated frequency in the string must be either an integer or a character '#' representing null pointer.
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
        Leetcode331 leetcode331 = new Leetcode331();
        leetcode331.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#");
    }

    public boolean isValidSerialization(String preorder) {
        //数组转化为树
        String[] array = preorder.split(",");
        Stack<String> stack = new Stack<>();
        //数字遇到后面连续两个#表明节点访问完了，出栈，并把原来的数字代替成#，表示其父节点在这边的分支走完了，遍历完数组，最后堆栈应该只剩一个#
        for (String value : array) {
            if (value.equals("#")) {
                //此分支走完了
                while (!stack.isEmpty() && stack.peek().equals("#")) {
                    stack.pop();
                    if (stack.isEmpty() || stack.peek().equals("#")) {
                        return false;
                    }
                    stack.pop();
                }
            }
            stack.push(value);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

}
