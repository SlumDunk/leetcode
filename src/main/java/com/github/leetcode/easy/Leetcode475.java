package com.github.leetcode.easy;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 8/30/18 21:57
 * @Description: Winter is coming! Your first job during the contest is to design a standard heater with fixed warm radius to warm all the houses.
 * <p>
 * Now, you are given positions of houses and heaters on a horizontal line, find out minimum radius of heaters so that all houses could be covered by those heaters.
 * <p>
 * So, your input will be the positions of houses and heaters seperately, and your expected output will be the minimum radius standard of heaters.
 * <p>
 * Note:
 * Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
 * Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
 * As long as a house is in the heaters' warm radius range, it can be warmed.
 * All the heaters follow your radius standard and the warm radius will the same.
 * Example 1:
 * Input: [1,2,3],[2]
 * Output: 1
 * Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, then all the houses can be warmed.
 * Example 2:
 * Input: [1,2,3,4],[1,4]
 * Output: 1
 * Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, then all the houses can be warmed.
 */
public class Leetcode475 {
    public static void main(String[] args) {

    }

    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int max = 0;
        for (int house : houses) {
            //找到每个房子最近的右侧火炉
            int left = 0, right = heaters.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (house > heaters[mid]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            if (right == 0) {
                max = Math.max(max, Math.abs(house - heaters[right]));
            } else {
                //离左边火炉的距离
                int leftDistance = Math.abs(house - heaters[right - 1]);
                //离右边火炉的距离
                int rightDistance = Math.abs(house - heaters[right]);
                max = Math.max(max, Math.min(leftDistance, rightDistance));
            }
        }
        return max;
    }
}
