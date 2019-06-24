package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/8/19 11:10
 * @Description: We have a sorted set of digits D, a non-empty subset of {'1','2','3','4','5','6','7','8','9'}.  (Note that '0' is not included.)
 * <p>
 * Now, we write numbers using these digits, using each digit as many times as we want.  For example, if D = {'1','3','5'}, we may write numbers such as '13', '551', '1351315'.
 * <p>
 * Return the number of positive integers that can be written (using the digits of D) that are less than or equal to N.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: D = ["1","3","5","7"], N = 100
 * Output: 20
 * Explanation:
 * The 20 numbers that can be written are:
 * 1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
 * Example 2:
 * <p>
 * Input: D = ["1","4","9"], N = 1000000000
 * Output: 29523
 * Explanation:
 * We can write 3 one digit numbers, 9 two digit numbers, 27 three digit numbers,
 * 81 four digit numbers, 243 five digit numbers, 729 six digit numbers,
 * 2187 seven digit numbers, 6561 eight digit numbers, and 19683 nine digit numbers.
 * In total, this is 29523 integers that can be written using the digits of D.
 * <p>
 * <p>
 * Note:
 * <p>
 * D is a subset of digits '1'-'9' in sorted order.
 * 1 <= N <= 10^9
 */
public class Leetcode902 {
    public int atMostNGivenDigitSet(String[] D, int N) {
        String T = String.valueOf(N + 1);
        int[] dp = new int[T.length() + 1];
        //从低位扫到高位
        for (int i = T.length() - 1; i >= 0; i--) {
            int t = T.charAt(i) - '0';
            //从小扫到大
            for (int j = 0; j < D.length; j++) {
                int v = D[j].charAt(0) - '0';
                if (v > t) break;
                if (v < t) {
                    dp[i] += (int) Math.pow(D.length, T.length() - 1 - i);
                } else if (v == t) {
                    dp[i] += dp[i + 1];
                    break;
                }
            }
        }
        // 1位的种类，2位的组合种类，...... T-1位的组合种类
        for (int i = 1; i < T.length(); i++) dp[0] += Math.pow(D.length, i);
        return dp[0];
    }
}
