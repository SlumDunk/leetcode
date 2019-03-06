package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 11:01
 * @Description: Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.
 * <p>
 * Note: The input string may contain letters other than the parentheses ( and ).
 * <p>
 * Example 1:
 * <p>
 * Input: "()())()"
 * Output: ["()()()", "(())()"]
 * Example 2:
 * <p>
 * Input: "(a)())()"
 * Output: ["(a)()()", "(a())()"]
 * Example 3:
 * <p>
 * Input: ")("
 * Output: [""]
 */
public class Leetcode301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int[] result = getLeftRightCount(s);
        dfs(s, 0, result[0], result[1], res);
        return res;
    }

    private void dfs(String s, int startIndex, int leftCount, int rightCount, List<String> res) {
        if (leftCount == 0 && rightCount == 0 && isStringValid(s)) {
            res.add(s);
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            if (i > startIndex && s.charAt(i) == s.charAt(i - 1)) {
                continue;
            }

            if (leftCount > 0 && s.charAt(i) == '(') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount - 1, rightCount, res);
            }

            if (rightCount > 0 && s.charAt(i) == ')') {
                dfs(s.substring(0, i) + s.substring(i + 1), i, leftCount, rightCount - 1, res);
            }
        }
    }

    /**
     * 字符串中的左右括号是否平衡
     *
     * @param s
     * @return
     */
    private boolean isStringValid(String s) {
        int[] result = getLeftRightCount(s);
        return result[0] == 0 && result[1] == 0;
    }

    /**
     * 获取不平衡的左括号数和右括号数
     *
     * @param s
     * @return
     */
    private int[] getLeftRightCount(String s) {
        int[] count = new int[]{0, 0};
        for (char c :
                s.toCharArray()) {
            if (c == '(') {
                count[0]++;
            }
            if (c == ')') {
                if (count[0] > 0) {
                    count[0]--;
                } else {
                    count[1]++;
                }
            }
        }
        return count;
    }


}
