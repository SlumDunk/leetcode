package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 5/31/19 15:32
 * @Description: Your car starts at position 0 and speed +1 on an infinite number line.  (Your car can go into negative positions.)
 * <p>
 * Your car drives automatically according to a sequence of instructions A (accelerate) and R (reverse).
 * <p>
 * When you get an instruction "A", your car does the following: position += speed, speed *= 2.
 * <p>
 * When you get an instruction "R", your car does the following: if your speed is positive then speed = -1 , otherwise speed = 1.  (Your position stays the same.)
 * <p>
 * For example, after commands "AAR", your car goes to positions 0->1->3->3, and your speed goes to 1->2->4->-1.
 * <p>
 * Now for some target position, say the length of the shortest sequence of instructions to get there.
 * <p>
 * Example 1:
 * Input:
 * target = 3
 * Output: 2
 * Explanation:
 * The shortest instruction sequence is "AA".
 * Your position goes from 0->1->3.
 * Example 2:
 * Input:
 * target = 6
 * Output: 5
 * Explanation:
 * The shortest instruction sequence is "AAARA".
 * Your position goes from 0->1->3->7->7->6.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= target <= 10000.
 */
public class Leetcode818 {
    private static int[][] m;

    public int racecar(int target) {
        if (m == null) {
            final int kMaxT = 10000;
            // right 0, left 1
            m = new int[kMaxT + 1][2];
            for (int t = 1; t <= kMaxT; t++) {
                int n = (int) Math.ceil(Math.log(t + 1) / Math.log(2));
                if (1 << n == t + 1) {
                    m[t][0] = n;
                    m[t][1] = n + 1;
                    continue;
                }
                int l = (1 << n) - 1 - t;
                //走到超过t需要n步，然后掉头
                m[t][0] = n + 1 + Math.min(m[l][1], m[l][0] + 1);
                m[t][1] = n + 1 + Math.min(m[l][0], m[l][1] + 1);
                for (int i = 1; i < t; i++) {
                    for (int d = 0; d <= 1; d++) {
                        m[t][d] = Math.min(m[t][d], Math.min(m[i][0] + 2 + m[t - i][d], m[i][1] + 1 + m[t - i][d]));
                    }
                }
            }
        }
        return Math.min(m[target][0], m[target][1]);
    }
}
