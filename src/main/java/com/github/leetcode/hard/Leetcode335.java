package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 20:03
 * @Description: You are given an array x of n positive numbers. You start at point (0,0) and moves x[0] metres to the north, then x[1] metres to the west, x[2] metres to the south, x[3] metres to the east and so on. In other words, after each move your direction changes counter-clockwise.
 * <p>
 * Write a one-pass algorithm with O(1) extra space to determine, if your path crosses itself, or not.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * ┌───┐
 * │   │
 * └───┼──>
 * │
 * <p>
 * Input: [2,1,1,2]
 * Output: true
 * Example 2:
 * <p>
 * ┌──────┐
 * │      │
 * │
 * │
 * └────────────>
 * <p>
 * Input: [1,2,3,4]
 * Output: false
 * Example 3:
 * <p>
 * ┌───┐
 * │   │
 * └───┼>
 * <p>
 * Input: [1,1,1,1]
 * Output: true
 * <p>
 *              i-2
 * case 1 : i-1┌─┐
 *             └─┼─>i
 *              i-3
 *
 *              i-2
 * case 2 : i-1 ┌────┐
 *              └─══>┘i-3
 *              i  i-4      (i overlapped i-4)
 *
 * case 3 :    i-4
 *              ┌──┐
 *              │i<┼─┐
 *           i-3│ i-5│i-1
 *              └────┘
 *                i-2
 */

public class Leetcode335 {
    public boolean isSelfCrossing(int[] x) {
        //北，西，南，东
        for (int i = 3; i < x.length; i++) {
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) {
                return true;
            } else if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                return true;
            } else if (i >= 5 && x[i - 2] >= x[i - 4] && x[i] + x[i - 4] >= x[i - 2] && x[i - 1] <= x[i - 3] && x[i - 1] + x[i - 5] >= x[i - 3]) {
                return true;
            }
        }
        return false;
    }
}
