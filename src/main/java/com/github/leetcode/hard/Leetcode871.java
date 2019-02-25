package com.github.leetcode.hard;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 10:09
 * @Description: A car travels from a starting position to a destination which is target miles east of the starting position.
 * <p>
 * Along the way, there are gas stations.  Each station[i] represents a gas station that is station[i][0] miles east of the starting position, and has station[i][1] liters of gas.
 * <p>
 * The car starts with an infinite tank of gas, which initially has startFuel liters of fuel in it.  It uses 1 liter of gas per 1 mile that it drives.
 * <p>
 * When the car reaches a gas station, it may stop and refuel, transferring all the gas from the station into the car.
 * <p>
 * What is the least number of refueling stops the car must make in order to reach its destination?  If it cannot reach the destination, return -1.
 * <p>
 * Note that if the car reaches a gas station with 0 fuel left, the car can still refuel there.  If the car reaches the destination with 0 fuel left, it is still considered to have arrived.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: target = 1, startFuel = 1, stations = []
 * Output: 0
 * Explanation: We can reach the target without refueling.
 * Example 2:
 * <p>
 * Input: target = 100, startFuel = 1, stations = [[10,100]]
 * Output: -1
 * Explanation: We can't reach the target (or even the first gas station).
 * Example 3:
 * <p>
 * Input: target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
 * Output: 2
 * Explanation:
 * We start with 10 liters of fuel.
 * We drive to position 10, expending 10 liters of fuel.  We refuel from 0 liters to 60 liters of gas.
 * Then, we drive from position 10 to position 60 (expending 50 liters of fuel),
 * and refuel from 10 liters to 50 liters of gas.  We then drive to and reach the target.
 * We made 2 refueling stops along the way, so we return 2.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= target, startFuel, stations[i][1] <= 10^9
 * 0 <= stations.length <= 500
 * 0 < stations[0][0] < stations[1][0] < ... < stations[stations.length-1][0] < target
 */
public class Leetcode871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //i次停车采集的最大的油量
        int len = stations.length;
        int[] dp = new int[len + 1];
        dp[0] = startFuel;
        for (int i = 1; i <= len; i++) {
            //在中间某个地方停车，加了油能到达i
            for (int j = i; j >= 1; j--) {
                //j-1次停车能到加油站i
                if (dp[j - 1] >= stations[i - 1][0]) {
                    //第j次停车能获取的最大油
                    dp[j] = Math.max(dp[j], dp[j - 1] + stations[i - 1][1]);
                }
            }
        }
        for (int i = 0; i <= len; i++) {
            if (dp[i] >= target) {
                return i;
            }
        }

        return -1;

    }

    /**
     * 贪心+heap
     *
     * @param target
     * @param startFuel
     * @param stations
     * @return
     */
    public int GreedyMinRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> stationsInRange = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;
        int range = startFuel;
        int stops = 0;
        while (range < target) {
            while (i < stations.length && stations[i][0] <= range) {
                stationsInRange.offer(stations[i++][1]);
            }
            if (stationsInRange.isEmpty()) {
                return -1;
            }
            range += stationsInRange.poll();
            stops++;
        }
        return stops;
    }
}
