package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 15:37
 * @Description: Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Note: The algorithm should run in linear time and in O(1) space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */
public class Leetcode229 {
    public static void main(String[] args) {
        Leetcode229 leetcode229 = new Leetcode229();
        leetcode229.majorityElement(new int[]{3, 2, 3});
    }

    public List<Integer> majorityElement(int[] nums) {
        //先对数组排序
        Arrays.sort(nums);
        int count = nums.length / 3;
        List<Integer> resultList = new ArrayList<>();
        if (nums.length == 0) {
            return resultList;
        }
        //用于缓存当前的数字
        int tmp = nums[0];
        int counter = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == tmp) {
                counter++;
            } else {
                if (counter > count) {
                    resultList.add(tmp);
                }
                tmp = nums[i];
                counter = 1;
            }
        }
        //防止漏掉最后一个
        if (counter > count) {
            resultList.add(tmp);
        }
        return resultList;
    }
}
