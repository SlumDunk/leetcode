package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 20:32
 * @Description: Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
 * <p>
 * Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.
 * <p>
 * Example 1:
 * Input: [1,1,2,2,2]
 * Output: true
 * <p>
 * Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
 * Example 2:
 * Input: [3,3,3,3,4]
 * Output: false
 * <p>
 * Explanation: You cannot find a way to form a square with all the matchsticks.
 * Note:
 * The length sum of the given matchsticks is in the range of 0 to 10^9.
 * The length of the given matchstick array will not exceed 15.
 */
public class Leetcode473 {
    /**
     * 顺利构成的边数
     */
    int count;
    /**
     * 已使用的火柴
     */
    boolean[] used;

    public boolean makesquare(int[] nums) {
        //统计总长度
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        //总长度不能被4整除，表示不能构成正方形
        if (sum % 4 != 0) return false;
        //边长
        int side = sum / 4;
        //火柴数目
        int end = nums.length;
        //排序
        Arrays.sort(nums);

        count = 0;
        used = new boolean[end];
        //优先使用长的火柴
        backtrack(new ArrayList<>(), nums, end - 1, 0, side);

        return count == 4;
    }

    /**
     * @param list   记录已使用的火柴
     * @param nums
     * @param start  开始位置
     * @param end    结束位置
     * @param target 目标边长
     */
    private void backtrack(ArrayList<Integer> list, int[] nums, int start, int end, int target) {
        if (target == 0) {
            count++;
            for (int index : list) {
                used[index] = true;
            }
        } else {
            for (int i = start; i >= end; i--) {
                for (int index : list) {
                    if (used[index])
                        return;
                }
                if (!used[i] && nums[i] <= target) {
                    list.add(i);
                    backtrack(new ArrayList<>(list), nums, i - 1, end, target - nums[i]);
                    list.remove(list.size() - 1);
                }
            }
        }
    }
}
