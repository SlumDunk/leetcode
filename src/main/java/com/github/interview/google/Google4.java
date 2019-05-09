package com.github.interview.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 12/4/18 21:27
 * @Description: Given array，partition into multiple strictly decreasing subarrays preserving original order. Find the smallest number of subarrays.
 * <p>
 * 例子：[5,2,3,1,6] -> [[5,2],[3,1],[6]] 输出3
 * [3,98,2] -> [[3,2],[98]] 输出2
 * 相同的不可以放在一个subarray里，必须strictly decreasing.
 * 只需要输出最小number。
 */
public class Google4 {
    public static void main(String[] args) {
        int[] nums = {3,2,2,2};
        int result = findMinSubarrays(nums);
        System.out.println(result);
    }

    private static int findMinSubarrays(int[] nums) {
        Map<Integer, Integer> middleMap = new HashMap<Integer, Integer>();
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int j = 0;
            while (j < nums.length && middleMap.getOrDefault(j, Integer.MIN_VALUE) <= nums[i]) {
                if (Integer.MIN_VALUE == middleMap.getOrDefault(j, Integer.MIN_VALUE)) {
                    resultList.add(new ArrayList<>());
                    middleMap.put(j, nums[i]);
                    break;
                } else {
                    //go ahead
                }
                j++;
            }
            if (j < nums.length && middleMap.get(j) > nums[i]) {
                middleMap.put(j, nums[i]);
            }
        }
        return resultList.size();
    }
}
