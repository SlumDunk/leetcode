package com.github.leetcode.medium;

/**
 * There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
 * <p>
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 * <p>
 * Your score is the sum of the points of the cards you have taken.
 * <p>
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cardPoints = [1,2,3,4,5,6,1], k = 3
 * Output: 12
 * Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
 * Example 2:
 * <p>
 * Input: cardPoints = [2,2,2], k = 2
 * Output: 4
 * Explanation: Regardless of which two cards you take, your score will always be 4.
 * Example 3:
 * <p>
 * Input: cardPoints = [9,7,7,9,7,7,9], k = 7
 * Output: 55
 * Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 * Example 4:
 * <p>
 * Input: cardPoints = [1,1000,1], k = 1
 * Output: 1
 * Explanation: You cannot take the card in the middle. Your best score is 1.
 * Example 5:
 * <p>
 * Input: cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * Output: 202
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= cardPoints.length <= 105
 * 1 <= cardPoints[i] <= 104
 * 1 <= k <= cardPoints.length
 */
public class Leetcode1423 {
    int[] cardPoints;

    /**
     * @param cardPoints
     * @param k
     * @return
     */
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        this.cardPoints = cardPoints;
        int[][][] dp = new int[n][n][k + 1];
        helper(dp, 0, n - 1, k);
        return dp[0][n - 1][k];
    }

    private int helper(int[][][] dp, int start, int end, int k) {
        if (k == 0) {
            return 0;
        } else {
            if (dp[start][end][k] != 0) {
                return dp[start][end][k];
            }
            int left = helper(dp, start + 1, end, k - 1) + cardPoints[start];
            int right = helper(dp, start, end - 1, k - 1) + cardPoints[end];
            dp[start][end][k] = Math.max(left, right);
            return dp[start][end][k];
        }
    }

    /**
     * 滑动窗口
     * https://www.youtube.com/watch?v=VaIJ4aha5qk
     *
     * @param carPoints
     * @param k
     * @return
     */
    public int maxScore2(int[] carPoints, int k) {
        int n = carPoints.length;
        int maxSum = 0;
        // 初始状态， 取左边 k 个， 右边 0 个
        for (int i = 0; i < Math.min(n, k); i++) {
            maxSum += carPoints[i];
        }

        if (k >= n) return maxSum;

        int fromEnd = 0, fromStart = k - 1;
        int rollingSum = maxSum;
        for (int i = 0; i < k; i++) {
            rollingSum += carPoints[n - 1 - fromEnd] - carPoints[fromStart];
            maxSum = Math.max(rollingSum, maxSum);
            fromEnd++;
            fromStart--;
        }
        return maxSum;
    }
}
