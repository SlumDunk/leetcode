package com.github.leetcode.hard;

import sun.font.FontRunIterator;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: zerongliu
 * @Date: 5/12/19 20:11
 * @Description: Given an array A of strings, find any smallest string that contains each string in A as a substring.
 * <p>
 * We may assume that no string in A is substring of another string in A.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["alex","loves","leetcode"]
 * Output: "alexlovesleetcode"
 * Explanation: All permutations of "alex","loves","leetcode" would also be accepted.
 * Example 2:
 * <p>
 * Input: ["catg","ctaagt","gcta","ttca","atgcatc"]
 * Output: "gctaagttcatgcatc"
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 12
 * 1 <= A[i].length <= 20
 */
public class Leetcode943 {
    public String shortestSuperstring(String[] A) {
        int n = A.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = calc(A[i], A[j]);
                graph[j][i] = calc(A[j], A[i]);
            }
        }
        int[][] dp = new int[1 << n][n];
        int[][] path = new int[1 << n][n];
        int last = -1, min = Integer.MAX_VALUE;
        //各种状态组合
        for (int i = 1; i < (1 << n); i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
            //以第j个元素结尾
            for (int j = 0; j < n; j++) {
                //01100
                //01000
                if ((i & (1 << j)) > 0) {
                    int prev = i - (1 << j);
                    if (prev == 0) {
                        dp[i][j] = A[j].length();
                    } else {
                        //上一状态的结束单词
                        for (int k = 0; k < n; k++) {
                            if (dp[prev][k] < Integer.MAX_VALUE && dp[prev][k] + graph[k][j] < dp[i][j]) {
                                dp[i][j] = dp[prev][k] + graph[k][j];
                                path[i][j] = k;
                            }
                        }
                    }
                }
                //走完所有状态了
                if (i == (1 << n) - 1 && dp[i][j] < min) {
                    min = dp[i][j];
                    last = j;
                }
            }
        }

        StringBuilder buffer = new StringBuilder();
        int cur = (1 << n) - 1;
        Stack<Integer> stack = new Stack<>();
        while (cur > 0) {
            stack.push(last);
            int temp = cur;
            cur -= (1 << last);
            last = path[temp][last];
        }
        int i = stack.pop();
        buffer.append(A[i]);
        while (!stack.isEmpty()) {
            int j = stack.pop();
            buffer.append(A[j].substring(A[j].length() - graph[i][j]));
            i = j;
        }
        return buffer.toString();
    }

    private int calc(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (b.startsWith(a.substring(i))) {
                return b.length() - a.length() + i;
            }
        }
        return b.length();
    }
}
