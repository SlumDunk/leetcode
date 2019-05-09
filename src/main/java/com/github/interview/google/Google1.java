package com.github.interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 12/4/18 10:04
 * @Description: 给出一个数组，要求两这个数组分为两个部分，分别对两个部分求和，使两个和的绝对差值最小，输出这个最小差值
 * eg, [1,2,3,4,5]，可以将它分为[1, 2, 4]和[3, 5]两个部分，对应的和分别为7， 8输出1
 */
public class Google1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        List<List<Integer>> resultList = findMinAbsoluteValue(nums);
        System.out.println(resultList);
    }

    private static List<List<Integer>> findMinAbsoluteValue(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int avg = 0;
        int sum = 0;
        for (int num : nums
                ) {
            sum += num;
        }
        avg = sum / nums.length;
        Arrays.sort(nums);
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        int count = 0;
        boolean flag = true;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (count % 2 == 0) {
                if (flag) {
                    list1.add(nums[i]);
                } else {
                    list2.add(nums[i]);
                }
            } else {
                if (flag) {
                    list2.add(nums[i]);
                } else {
                    list1.add(nums[i]);
                }
            }
            if (count % 2 == 1) {
                flag = Boolean.FALSE;
            }
            count++;
        }
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(list1);
        resultList.add(list2);
        return resultList;
    }
}
