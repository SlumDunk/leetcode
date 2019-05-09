package com.github.interview.amazon;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 4/9/19 22:11
 * @Description:
 */
public class ClosetTwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[2];
        }
        Arrays.sort(numbers);
        int l = 0;
        int h = numbers.length - 1;
        int d = Integer.MAX_VALUE;
        int[] res = new int[2];
        while (l < h) {
            int cur = numbers[l] + numbers[h];
            int diff = target - cur;
            if (diff < d && diff >= 0) {
                d = diff;
                res[0] = numbers[l];
                res[1] = numbers[h];
            }
            if (cur < target) {
                l++;
            } else {
                h--;
            }
        }
        return res;
    }
}
