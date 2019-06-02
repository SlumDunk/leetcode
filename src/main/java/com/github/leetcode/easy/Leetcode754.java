package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 21:38
 * @Description: You are standing at position 0 on an infinite number line. There is a goal at position target.
 * <p>
 * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
 * <p>
 * Return the minimum number of steps required to reach the destination.
 * <p>
 * Example 1:
 * Input: target = 3
 * Output: 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 * Example 2:
 * Input: target = 2
 * Output: 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step  from 1 to -1.
 * On the third move we step from -1 to 2.
 * Note:
 * target will be a non-zero integer in the range [-10^9, 10^9].
 */
public class Leetcode754 {
    /**
     * 等差数列求和
     *
     * @param x
     * @return
     */
    int f(int x) {
        return (x * (x + 1) / 2);
    }

    public int reachNumber(int target) {
        target = Math.abs(target);
        if (target == 0) return 0;

        int vmin = (int) Math.sqrt(target);
        while (f(vmin) < target) ++vmin;

        while (f(vmin) % 2 != target % 2) vmin++;

        return vmin;
    }
}
