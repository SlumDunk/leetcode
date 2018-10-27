package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 20:32
 * @Description: Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,1,3,2,5]
 * Output: [3,5]
 * Note:
 * <p>
 * The order of the result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class Leetcode260 {
    public int[] singleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        List<Integer> resultList = new ArrayList<>();
        if (nums.length == 0) {
            return null;
        }
        int tmp = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tmp) {
                counter++;
            } else {
                if (counter == count) {
                    resultList.add(tmp);
                }
                tmp = nums[i];
                counter = 1;
            }
        }
        if (counter == count) {
            resultList.add(tmp);
        }
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
