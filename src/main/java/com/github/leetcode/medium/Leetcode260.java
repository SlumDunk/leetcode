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
        //先对数组进行排序
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
            } else {//出现不一致情况
                if (counter == count) {//只出现一次，添加到结果集
                    resultList.add(tmp);
                }
                //当前数字
                tmp = nums[i];
                //计数器置位为1
                counter = 1;
            }
        }
        //避免遗漏最后一个数字不一致的情况
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
