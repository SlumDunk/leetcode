package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 15:22
 * @Description: In a list of songs, the i-th song has a duration of time[i] seconds.
 * <p>
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.  Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 * Example 2:
 * <p>
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 */
public class Leetcode1010 {

    /**
     * O(n)
     * 余数和加起来能被60整除
     *
     * @param time
     * @return
     */
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        int[] hash = new int[60];
        for (int t :
                time) {
            hash[t % 60]++;
        }
        //余数为0
        ans += hash[0] * (hash[0] - 1) / 2;
        //余数为30
        ans += hash[30] * (hash[30] - 1) / 2;
        //余数和为60
        for (int i = 1; i < 30; i++) {
            ans += hash[i] * hash[60 - i];
        }
        return ans;
    }
}
