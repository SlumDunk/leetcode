package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/11/18 20:08
 * @Description: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * For example, given n = 3, a solution set is:
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */
public class Leetcode22 {
    public static void main(String[] args) {
        Leetcode22 leetcode22=new Leetcode22();
        leetcode22.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generating(n, n, "", res);
        return res;

    }

    private void generating(int left, int right, String str, List<String> res) {

        if (left == 0 && right == 0) {
            res.add(str);
        }
        if (left > 0) {
            generating(left - 1, right, str + "(", res);
        }
        if (right > 0 && left < right) {
            generating(left, right - 1, str + ")", res);
        }
    }
}
