package com.github.interview.amazon;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 10:25
 * @Description:
 */
public class TwoSumUniquePairs {
    public static int uniquePairs(int[] nums, int target) {
        //待匹配的数字
        Set<Integer> set = new HashSet<Integer>();
        Set<Integer> seen = new HashSet<Integer>();
        int count = 0;
        for (int num : nums) {
            if (set.contains(target - num) && !seen.contains(num)) {
                count++;
                seen.add(target - num);
                seen.add(num);
            } else if (!set.contains(num)) {
                set.add(num);
            }

        }

        return count;
    }
}
