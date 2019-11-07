package com.github.interview.amazon;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 09:29
 * @Description:
 */
public class MoviesOnFlight {
    public static int[] test(int[] nums, int d) {
        int[] result = new int[2];
        int max = Integer.MIN_VALUE;
        int start = 0;
        int end = nums.length - 1;
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        ArrayList<Integer> a = new ArrayList<Integer>();

        while (start <= end) {
            if ((nums[start] + nums[end]) <= d - 30) {

                if (max < (nums[start] + nums[end])) {
                    max = (nums[start] + nums[end]);
                    i = nums[start];
                    j = nums[end];
                }
                start++;

            } else if ((nums[start] + nums[end]) > d - 30) {
                end--;
            }
        }
        result[0] = i;
        result[1] = j;
        return result;
    }
}
