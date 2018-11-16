package com.github.leetcode.medium;

import com.github.leetcode.vo.NestedInteger;

/**
 * @Author: zerongliu
 * @Date: 11/15/18 19:58
 * @Description: Given a nested list of integers represented as a string, implement a parser to deserialize it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Note: You may assume that the string is well-formed:
 * <p>
 * String is non-empty.
 * String does not contain white spaces.
 * String contains only digits 0-9, [, - ,, ].
 * Example 1:
 * <p>
 * Given s = "324",
 * <p>
 * You should return a NestedInteger object which contains a single integer 324.
 * Example 2:
 * <p>
 * Given s = "[123,[456,[789]]]",
 * <p>
 * Return a NestedInteger object containing a nested list with 2 elements:
 * <p>
 * 1. An integer containing value 123.
 * 2. A nested list containing two elements:
 * i.  An integer containing value 456.
 * ii. A nested list with one element:
 * a. An integer containing value 789.
 */
public class Leetcode385 {
    int i = 1;

    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[')
            return new NestedInteger(Integer.parseInt(s));

        return dfs(s.toCharArray());
    }

    public NestedInteger dfs(char[] ca) {
        NestedInteger res = new NestedInteger();
        while (i < ca.length) {
            if (ca[i] == ',') {
                i++;
            } else if (ca[i] == '[') {
                i++;
                res.add(dfs(ca));
            } else if (ca[i] == ']') {
                i++;
                break;
            } else {
                int cur = 0;
                boolean pos = true;
                if (ca[i] == '-') {
                    pos = false;
                    i++;
                }

                while (i < ca.length && ca[i] >= '0' && ca[i] <= '9') {
                    cur = 10 * cur + ca[i++] - '0';
                }

                if (!pos)
                    cur = -cur;

                res.add(new NestedInteger(cur));
            }

        }

        return res;
    }
}
