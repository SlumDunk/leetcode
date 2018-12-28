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
        Leetcode22 leetcode22 = new Leetcode22();
        leetcode22.generateParenthesis(3);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generating(n, n, "", res);
        return res;

    }

    /**
     * 产生括号字符串
     *
     * @param left  可产生的左括号个数
     * @param right 可产生的右括号个数
     * @param str   当前字符串
     * @param res   结果集
     */
    private void generating(int left, int right, String str, List<String> res) {
        //都产生完了
        if (left == 0 && right == 0) {
            res.add(str);
        }
        //先产生一个左括号，再产生left-1个左括号和right个右括号
        if (left > 0) {
            generating(left - 1, right, str + "(", res);
        }
        //先产生一个右括号，再产生left个左括号和right-1个右括号，右括号必须和左括号配对出现，所以产生右括号时right要大于left
        if (right > 0 && left < right) {
            generating(left, right - 1, str + ")", res);
        }
    }
}
