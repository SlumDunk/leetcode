package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/25/19 19:27
 * @Description: Given an array nums of integers, you can perform operations on the array.
 * <p>
 * In each operation, you pick any nums[i] and delete it to earn nums[i] points. After, you must delete every element equal to nums[i] - 1 or nums[i] + 1.
 * <p>
 * You start with 0 points. Return the maximum number of points you can earn by applying such operations.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [3, 4, 2]
 * Output: 6
 * Explanation:
 * Delete 4 to earn 4 points, consequently 3 is also deleted.
 * Then, delete 2 to earn 2 points. 6 total points are earned.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [2, 2, 3, 3, 3, 4]
 * Output: 9
 * Explanation:
 * Delete 3 to earn 3 points, deleting both 2's and the 4.
 * Then, delete 3 again to earn 3 points, and 3 again to earn 3 points.
 * 9 total points are earned.
 * <p>
 * <p>
 * Note:
 * <p>
 * The length of nums is at most 20000.
 * Each element nums[i] is an integer in the range [1, 10000].
 */
public class Leetcode740 {
    public int deleteAndEarn(int[] nums) {
        //统计每个数出现的频率
        int[] freq = new int[10005];
        //最大的数
        int max = 1;
        for (int i : nums) {
            max = Math.max(max, i);
            ++freq[i];
        }

        int[] res = new int[10005];
        //从大往小扫
        for (int i=max; i>=1; --i) {
            //取i和不取i
            res[i] = Math.max(res[i+1], ((i*freq[i]) + res[i+2]));
        }


        return res[1];
    }
}
