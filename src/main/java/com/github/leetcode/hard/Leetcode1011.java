package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 09:40
 * @Description: A conveyor belt has packages that must be shipped from one port to another within D days.
 * <p>
 * The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.
 * <p>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation:
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * <p>
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed.
 * Example 2:
 * <p>
 * Input: weights = [3,2,2,4,1,4], D = 3
 * Output: 6
 * Explanation:
 * A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * Example 3:
 * <p>
 * Input: weights = [1,2,3,1,1], D = 4
 * Output: 3
 * Explanation:
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 */
public class Leetcode1011 {
    /**
     * 二分法
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int maxWeight = 0, sumWeight = 0;
        for (int w :
                weights) {
            sumWeight += w;
            if (w > maxWeight) {
                maxWeight = w;
            }
        }
        int left = Math.max(maxWeight, sumWeight / D), right = sumWeight;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canShip(weights, D, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * @param weights  所有货物重量数组
     * @param D        天数
     * @param capacity 容量
     * @return
     */
    private boolean canShip(int[] weights, int D, int capacity) {
        int shippedIndex = -1;
        for (int d = 1; d <= D; d++) {
            int capacityRemaining = capacity;
            while (capacityRemaining > 0 && shippedIndex < weights.length - 1) {
                if (weights[shippedIndex + 1] <= capacityRemaining) {
                    shippedIndex++;
                    capacityRemaining -= weights[shippedIndex];
                } else {
                    break;
                }
            }
            if (shippedIndex == weights.length - 1) {
                return true;
            }
        }
        return false;
    }
}
