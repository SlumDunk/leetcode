package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 22:59
 * @Description: You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)
 * <p>
 * Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.
 * <p>
 * Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 4
 * Output: false
 * Example 2:
 * <p>
 * Input: trips = [[2,1,5],[3,3,7]], capacity = 5
 * Output: true
 * Example 3:
 * <p>
 * Input: trips = [[2,1,5],[3,5,7]], capacity = 3
 * Output: true
 * Example 4:
 * <p>
 * Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
 * Output: true
 * <p>
 * <p>
 * <p>
 * Constraints:
 * <p>
 * trips.length <= 1000
 * trips[i].length == 3
 * 1 <= trips[i][0] <= 100
 * 0 <= trips[i][1] < trips[i][2] <= 1000
 * 1 <= capacity <= 100000
 */
public class Leetcode1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        if (trips.length == 0) return false;
        //开始地点上，结束地点下，求出每个地点的净值
        int max = 1001;
        int[] m = new int[max + 1];
        for (int i = 0; i < trips.length; i++) {
            m[trips[i][1]] += trips[i][0];
            m[trips[i][2]] -= trips[i][0];
        }
        int sum = 0;
        for (int i = 0; i <= max; i++) {
            sum += m[i];
            if (sum > capacity) return false;
        }
        return sum <= capacity;
    }
}
