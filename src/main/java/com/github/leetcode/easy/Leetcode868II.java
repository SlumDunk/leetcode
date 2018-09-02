package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 10:34
 * @Description: Given a positive integer N, find and return the longest distance between two consecutive 1's in the binary representation of N.
 * <p>
 * If there aren't two consecutive 1's, return 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 22
 * Output: 2
 * Explanation:
 * 22 in binary is 0b10110.
 * In the binary representation of 22, there are three ones, and two consecutive pairs of 1's.
 * The first consecutive pair of 1's have distance 2.
 * The second consecutive pair of 1's have distance 1.
 * The answer is the largest of these two distances, which is 2.
 * Example 2:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation:
 * 5 in binary is 0b101.
 * Example 3:
 * <p>
 * Input: 6
 * Output: 1
 * Explanation:
 * 6 in binary is 0b110.
 * Example 4:
 * <p>
 * Input: 8
 * Output: 0
 * Explanation:
 * 8 in binary is 0b1000.
 * There aren't any consecutive pairs of 1's in the binary representation of 8, so we return 0.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 10^9
 */
public class Leetcode868II {
    public int binaryGap(int N) {
        int curPos = 0;
        int lastOnePos = -1;
        int maxDis = 0;
        while (N > 0) {
            if (N % 2 == 1) {
                if (lastOnePos != -1) {
                    maxDis = Math.max(curPos - lastOnePos, maxDis);
                }
                lastOnePos = curPos;
            }
            N /= 2;
            ++curPos;
        }
        return maxDis;
    }
}
