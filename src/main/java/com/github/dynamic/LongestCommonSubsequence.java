package com.github.dynamic;

/**
 * @Author: zerongliu
 * @Date: 1/5/19 20:49
 * @Description:
 */
public class LongestCommonSubsequence {
    public int lcsDP(String str1, String str2) {
        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();
        int[][] dp = new int[array1.length + 1][array2.length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (array1[i - 1] == array2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[array1.length][array2.length];
    }
}
