package com.github.leetcode.medium;

/**
 * There is a room with n bulbs, numbered from 1 to n, arranged in a row from left to right. Initially, all the bulbs are turned off.
 * <p>
 * At moment k (for k from 0 to n - 1), we turn on the light[k] bulb. A bulb change color to blue only if it is on and all the previous bulbs (to the left) are turned on too.
 * <p>
 * Return the number of moments in which all turned on bulbs are blue.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: light = [2,1,3,5,4]
 * Output: 3
 * Explanation: All bulbs turned on, are blue at the moment 1, 2 and 4.
 * Example 2:
 * <p>
 * Input: light = [3,2,4,1,5]
 * Output: 2
 * Explanation: All bulbs turned on, are blue at the moment 3, and 4 (index-0).
 * Example 3:
 * <p>
 * Input: light = [4,1,2,3]
 * Output: 1
 * Explanation: All bulbs turned on, are blue at the moment 3 (index-0).
 * Bulb 4th changes to blue at the moment 3.
 * Example 4:
 * <p>
 * Input: light = [2,1,4,3,6,5]
 * Output: 3
 * Example 5:
 * <p>
 * Input: light = [1,2,3,4,5,6]
 * Output: 6
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == light.length
 * 1 <= n <= 5 * 10^4
 * light is a permutation of  [1, 2, ..., n]
 */
public class Leetcode1375 {
    /**
     * https://www.youtube.com/watch?v=91NwStWqdTo
     *
     * @param light
     * @return
     */
    public int numTimesAllBlue(int[] light) {
        int ans = 0;
        int running = 0;
        for (int i = 0; i < light.length; i++) {
            running = Math.max(running, light[i]);
            if (i + 1 == running) {
                ans++;
            }
        }
        return ans;
    }
}
