package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 2/5/19 10:49
 * @Description: Given a square array of integers A, we want the minimum sum of a falling path through A.
 * <p>
 * A falling path starts at any element in the first row, and chooses one element from each row.  The next row's choice must be in a column that is different from the previous row's column by at most one.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: 12
 * Explanation:
 * The possible falling paths are:
 * [1,4,7], [1,4,8], [1,5,7], [1,5,8], [1,5,9]
 * [2,4,7], [2,4,8], [2,5,7], [2,5,8], [2,5,9], [2,6,8], [2,6,9]
 * [3,5,7], [3,5,8], [3,5,9], [3,6,8], [3,6,9]
 * The falling path with the smallest sum is [1,4,7], so the answer is 12.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length == A[0].length <= 100
 * -100 <= A[i][j] <= 100
 */
public class Leetcode931 {
    public int minFallingPathSum(int[][] A) {
        //dp[i][j]=Math.min(dp[i-1][j],dp[i-1][j-1],dp[i-1][j+1])+ A[i][j]
        if (A == null || A.length == 0 || A[0].length == 0) {
            return 0;
        } else {
            int m = A.length;
            int n = A[0].length;
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                dp[i][0] = Integer.MAX_VALUE;
            }
            for (int i = 0; i <= n; i++) {
                dp[0][i] = 0;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
                    if (j != n) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1]);
                    }
                    dp[i][j] += A[i - 1][j - 1];
                }
            }
            int result = Integer.MAX_VALUE;
            for (int j = 1; j <= n; j++) {
                result = Math.min(dp[m][j], result);
            }
            return result;
        }
    }
}
