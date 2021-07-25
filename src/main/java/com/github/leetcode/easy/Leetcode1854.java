package com.github.leetcode.easy;

/**
 * You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
 * <p>
 * The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
 * <p>
 * Return the earliest year with the maximum population.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = [[1993,1999],[2000,2010]]
 * Output: 1993
 * Explanation: The maximum population is 1, and 1993 is the earliest year with this population.
 * Example 2:
 * <p>
 * Input: logs = [[1950,1961],[1960,1971],[1970,1981]]
 * Output: 1960
 * Explanation:
 * The maximum population is 2, and it had happened in years 1960 and 1970.
 * The earlier year between them is 1960.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= logs.length <= 100
 * 1950 <= birthi < deathi <= 2050
 */
public class Leetcode1854 {
    public int maximumPopulation(int[][] logs) {
        int pop[] = new int[2051];
        int res = 0;
        for (int[] log :
                logs) {
            ++pop[log[0]];
            --pop[log[1]];
        }
        for (int i = 1950; i < 2050; i++) {
            pop[i] += pop[i - 1];
            res = pop[i] > pop[res] ? i : res;
        }
        return res;
    }
}
