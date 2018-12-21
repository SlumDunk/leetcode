package com.github.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * <p>
 * Given an array nums representing the data status of this set after the error. Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 * <p>
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 */
public class Leetcode645 {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        //因为数组元素的取值范围是1-n, 所以可以利用和差
        int len = nums.length;
        int sum = (len + 1) * len / 2;
        Set<Integer> numSet = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            if (numSet.contains(nums[i])) {
                result[0] = nums[i];
            }
            numSet.add(nums[i]);
        }
        if (sum > 0) {//重复的值是小值
            result[1] = result[0] + sum;
        } else {//重复的数值是大值
            result[1] = result[0] - Math.abs(sum);
        }
        return result;
    }


}
