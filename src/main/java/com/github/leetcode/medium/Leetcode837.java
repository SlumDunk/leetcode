package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 2/24/19 21:20
 * @Description: Alice plays the following game, loosely based on the card game "21".
 * <p>
 * Alice starts with 0 points, and draws numbers while she has less than K points.  During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.  Each draw is independent and the outcomes have equal probabilities.
 * <p>
 * Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?
 * <p>
 * Example 1:
 * <p>
 * Input: N = 10, K = 1, W = 10
 * Output: 1.00000
 * Explanation:  Alice gets a single card, then stops.
 * Example 2:
 * <p>
 * Input: N = 6, K = 1, W = 10
 * Output: 0.60000
 * Explanation:  Alice gets a single card, then stops.
 * In 6 out of W = 10 possibilities, she is at or below N = 6 points.
 * Example 3:
 * <p>
 * Input: N = 21, K = 17, W = 10
 * Output: 0.73278
 * Note:
 * <p>
 * 0 <= K <= N <= 10000
 * 1 <= W <= 10000
 * Answers will be accepted as correct if they are within 10^-5 of the correct answer.
 * The judging time limit has been reduced for this question.
 */
public class Leetcode837 {
    public double new21Game(int N, int K, int W) {
        if (K == 0 || N >= K + W) {
            return 1;
        } else {
            int max = K + W - 1;
            double[] dp = new double[max + 1];
            dp[0] = 1;
            for (int i = 1; i <= max; i++) {
                dp[i] += dp[i - 1];
                if (i <= W) {//再取一张牌到达i点数
                    dp[i] += dp[i - 1] / W;
                } else {//再取一张牌到达点数
                    dp[i] += (dp[i - 1] - dp[i - W - 1]) / W;
                }
                if (i > K) {//超过K的部分，不再取牌
                    dp[i] -= (dp[i - 1] - dp[K - 1]) / W;
                }
            }
            return dp[N] - dp[K - 1];
        }
    }
}
