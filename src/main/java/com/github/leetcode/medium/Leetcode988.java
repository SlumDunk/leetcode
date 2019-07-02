package com.github.leetcode.medium;

import com.github.leetcode.vo.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 19:59
 * @Description: Given the root of a binary tree, each node has a value from 0 to 25 representing the letters 'a' to 'z': a value of 0 represents 'a', a value of 1 represents 'b', and so on.
 * <p>
 * Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.
 * <p>
 * (As a reminder, any shorter prefix of a string is lexicographically smaller: for example, "ab" is lexicographically smaller than "aba".  A leaf of a node is a node that has no children.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: [0,1,2,3,4,3,4]
 * Output: "dba"
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: [25,1,3,1,3,0,2]
 * Output: "adz"
 * Example 3:
 * <p>
 * <p>
 * <p>
 * Input: [2,2,1,null,1,0,null,0]
 * Output: "abc"
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of nodes in the given tree will be between 1 and 8500.
 * Each node in the tree will have a value between 0 and 25.
 */
public class Leetcode988 {
    public String smallestFromLeaf(TreeNode root) {

        if (root == null)
            return new String();


        //存储所有从叶子节点到根节点的路径
        List<String> list = new ArrayList<String>();

        helper(root, "", list);

        String str = list.get(0);

        System.out.println(list);

        for (int i = 1; i < list.size(); i++) {

            if (str.compareTo(list.get(i)) > 0) {
                str = list.get(i);
            }

        }
        return str;
    }

    /**
     * @param root
     * @param str  祖宗节点组成的字符串
     * @param list 结果List
     */
    public void helper(TreeNode root, String str, List<String> list) {

        if (root == null) {
            return;
        }
        //走到叶子节点
        if (root.left == null && root.right == null) {
            char c = (char) (root.val + 97);
            str += Character.toString(c);
            //翻转
            list.add(reverseString(str));
            return;
        }
        char c = (char) (root.val + 97);
        str += Character.toString(c);

        helper(root.left, str, list);
        helper(root.right, str, list);
    }

    /**
     * 翻转字符串
     *
     * @param str
     * @return
     */
    public String reverseString(String str) {

        StringBuilder s = new StringBuilder(str);

        return s.reverse().toString();
    }
}
