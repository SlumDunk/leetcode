package com.github.lintcode.easy;

/**
 * @Author: zerongliu
 * @Date: 1/11/19 23:02
 * @Description: You are standing at position 0 on an infinite number line. There is a goal at position target.
 * <p>
 * On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.
 * <p>
 * Return the minimum number of steps required to reach the destination.
 * <p>
 * Example
 * Example 1:
 * <p>
 * Given target = 3
 * Return 2
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second step we step from 1 to 3.
 * Example 2:
 * <p>
 * Given target = 2
 * Return 3
 * Explanation:
 * On the first move we step from 0 to 1.
 * On the second move we step  from 1 to -1.
 * On the third move we step from -1 to 2.
 * Notice
 * target will be a non-zero integer in the range [-10^9, 10^9].
 * https://www.youtube.com/watch?v=Bdw2Y9FrqcU
 */
public class Lintcode797 {
    /**
     * @param target: the destination
     * @return: the minimum number of steps
     */
    public int reachNumber(int target) {
        // Write your code here
        if (target == 0) {
            return 0;
        } else {
            target = Math.abs(target);
            int sum = 0;
            int k = 0;
            while (sum < target) {
                k++;
                sum += k;
            }
            int d = sum - target;
            if (d % 2 == 0) {
                return k;
            } else {
                return (k + 1) + (k % 2);
            }

        }
    }
}
