package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 10/31/20 19:43
 * @Description: Given an array of integers arr, write a function that returns true if and only if the number of occurrences of each value in the array is unique.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 * <p>
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 * <p>
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 1000
 * -1000 <= arr[i] <= 1000
 */
public class Leetcode1207 {
    public boolean uniqueOccurrences(int[] arr) {
        int n=arr.length;
        Map<Integer,Integer> countMap=new HashMap<>();
        Set<Integer> set=new HashSet<>();
        for (int i = 0; i < n; i++) {
            countMap.put(arr[i],countMap.getOrDefault(arr[i],0)+1);
        }

        for (Integer value :
                countMap.values()) {
            if (set.contains(value)) {
                return false;
            } else {
                set.add(value);
            }
        }
        return true;

    }
}
