package com.interview.triplebyte;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 9/19/19 10:24
 * @Description: Get all valid permutations of l pairs of (), m pairs of <> and n pairs of {}.
 * Assumptions
 * l, m, n >= 0
 * l + m + n > 0
 * Examples
 * l = 1, m = 1, n = 0, all the valid permutations are ["()<>", "(<>)", "<()>", "<>()"]
 */
public class PermutationOfParenthese2 {
    private static final char[] PS = new char[]{'(', ')', '<', '>', '{', '}'};

    /**
     * @param l number of pairs of "()"
     * @param m number of pairs of "[]"
     * @param n number of pairs of "{}"
     * @return
     */
    public List<String> validParentheses(int l, int m, int n) {
        // L pairs of (), M pairs of <>, N pairs of {}
        // stirng 一般用.length（）
        // 数组[] 一般用 .length
        int[] remain = new int[]{l, l, m, m, n, n};
        int level = 2 * l + 2 * m + 2 * n;
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new LinkedList<>();
        List<String> result = new ArrayList<>();
        helper(sb, stack, remain, level, result);
        return result;

    }

    /**
     * @param sb
     * @param stack
     * @param remain
     * @param level
     * @param result
     */
    private void helper(StringBuilder sb, Deque<Character> stack, int[] remain, int level, List<String> result) {
        if (sb.length() == level) {//no parenthesis remain
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < remain.length; i++) {
            if (i % 2 == 0) {// meet left parenthesis
                if (remain[i] > 0) {
                    sb.append(PS[i]);
                    stack.push(PS[i]);
                    remain[i]--;
                    helper(sb, stack, remain, level, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.pop();
                    remain[i]++;
                }
            } else {// meet with right parenthesis
                if (!stack.isEmpty() && stack.peekFirst() == PS[i - 1]) {
                    sb.append(PS[i]);
                    stack.pop();
                    remain[i]--;
                    helper(sb, stack, remain, level, result);
                    sb.deleteCharAt(sb.length() - 1);
                    stack.push(PS[i - 1]);
                    remain[i]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        PermutationOfParenthese2 sol = new PermutationOfParenthese2();
        List<String> result = sol.validParentheses(1, 3, 0);
        System.out.println(result.size());
        for (String value :
                result) {
            System.out.println(value);
        }

    }

}
