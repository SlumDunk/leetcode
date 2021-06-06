package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/12/21 21:52
 * @Description: Given a m x n matrix mat and an integer threshold. Return the maximum side-length of a square with a sum less than or equal to threshold or return 0 if there is no such square.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
 * Output: 2
 * Explanation: The maximum side length of square with sum less than 4 is 2 as shown.
 * Example 2:
 * <p>
 * Input: mat = [[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2],[2,2,2,2,2]], threshold = 1
 * Output: 0
 * Example 3:
 * <p>
 * Input: mat = [[1,1,1,1],[1,0,0,0],[1,0,0,0],[1,0,0,0]], threshold = 6
 * Output: 3
 * Example 4:
 * <p>
 * Input: mat = [[18,70],[61,1],[25,85],[14,40],[11,96],[97,96],[63,45]], threshold = 40184
 * Output: 2
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= m, n <= 300
 * m == mat.length
 * n == mat[i].length
 * 0 <= mat[i][j] <= 10000
 * 0 <= threshold <= 10^5
 */
public class Leetcode1292 {
    class Solution {
        boolean found = false;

        public int maxSideLength(int[][] mat, int threshold) {
            if (mat == null || mat.length < 0) {
                return 0;
            }
            int m = mat.length;
            int n = mat[0].length;

            int maxSideLen = Math.min(m, n);
            int[][] dp = new int[m][n];
            int answer = 0;

            fillDP(dp, mat, threshold);

            if (!found) {
                return 0;
            }
            for (int i = 1; i <= maxSideLen; i++) {
                if (!isSquarePossible(dp, i, threshold, m, n)) {
                    return answer;
                }
                answer++;
            }

            return answer;
        }

        boolean isSquarePossible(int[][] dp, int maxLen, int threshold, int m, int n) {
            int endX = maxLen - 1;
            int endY = maxLen - 1;
            int startX = 0;
            int startY = 0;
            while (endY < n && endX < m) {
                int range = rangeQuery(startX, startY, endX, endY, dp);
                if (range <= threshold) {
                    return true;
                }
                // 走到行的最右边，重启一行
                if (endY == n - 1) {
                    endX++;
                    endY = maxLen - 1;

                    startX++;
                    startY = 0;
                } else { // 当前行一直扫过去
                    startY++;
                    endY++;
                }
            }

            return false;
        }

        int rangeQuery(int startX, int startY, int endX, int endY, int[][] dp) {
            return dp[endX][endY]
                    - (startY - 1 >= 0 ? dp[endX][startY - 1] : 0)
                    - (startX - 1 >= 0 ? dp[startX - 1][endY] : 0)
                    + (startY - 1 >= 0 && startX - 1 >= 0 ? dp[startX - 1][startY - 1] : 0);
        }

        void fillDP(int[][] dp, int[][] mat, int threshold) {
            dp[0][0] = mat[0][0];
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    if (mat[i][j] <= threshold) {
                        found = true;
                    }
                    if (i == 0 && j == 0) {
                        continue;
                    }
                    if (i == 0) {
                        dp[i][j] = dp[i][j - 1] + mat[i][j];

                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + mat[i][j];

                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + mat[i][j];
                    }

                }

            }
        }
    }
}
