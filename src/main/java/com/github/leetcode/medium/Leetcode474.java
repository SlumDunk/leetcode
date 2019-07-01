package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 19:59
 * @Description: In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
 * <p>
 * For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings consisting of only 0s and 1s.
 * <p>
 * Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can be used at most once.
 * <p>
 * Note:
 * <p>
 * The given numbers of 0s and 1s will both not exceed 100
 * The size of given string array won't exceed 600.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
 * Output: 4
 * <p>
 * Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are “10,”0001”,”1”,”0”
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: Array = {"10", "0", "1"}, m = 1, n = 1
 * Output: 2
 * <p>
 * Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
 */
public class Leetcode474 {
    public int findMaxForm(String[] strs, int m, int n) {
        //key为单词，value为组成单词需要的1和0的个数
        Map<String, int[]> map = new HashMap<>();
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];
        for (String s : strs) {
            int a = 0, b = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '1') {
                    b++;
                }
                if (s.charAt(i) == '0') {
                    a++;
                }
            }
            map.put(s, new int[]{a, b});
        }
        //遍历所有单词
        for (int i = 1; i <= len; i++) {
            for (int a = 0; a <= m; a++) {
                for (int b = 0; b <= n; b++) {
                    if (a >= map.get(strs[i - 1])[0] && b >= map.get(strs[i - 1])[1]) {
                        //包括与不包括去较大的那个
                        dp[i][a][b] = Math.max(dp[i - 1][a - map.get(strs[i - 1])[0]][b - map.get(strs[i - 1])[1]] + 1, dp[i - 1][a][b]);
                    } else {
                        dp[i][a][b] = dp[i - 1][a][b];
                    }
                }
            }
        }
        return dp[len][m][n];
    }
}
