package com.github.lintcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 13:51
 * @Description: Given an array of integers and a number k, the majority number is the number that occurs more than 1/k of the size of the array.
 * <p>
 * Find it.
 * <p>
 * Example
 * Given [3,1,2,3,2,3,3,4,4,4] and k=3, return 3.
 * <p>
 * Challenge
 * O(n) time and O(k) extra space
 * <p>
 * Notice
 * There is only one majority number in the array.
 */
public class Lintcode48 {
    /**
     * @param nums: A list of integers
     * @param k:    An integer
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        //只保存k个键，满k抵消一次，并移除值为0的键
        Map<Integer, Integer> counters = new HashMap<>();
        for (Integer num : nums) {
            if (!counters.containsKey(num)) {
                counters.put(num, 1);
            } else {
                counters.put(num, counters.get(num) + 1);
            }
            if (counters.size() >= k) {
                removeKey(counters);
            }
        }
        if (counters.size() == 0) {
            return Integer.MIN_VALUE;
        }
        for (Integer key : counters.keySet()) {
            counters.put(key, 0);
        }

        for (Integer num : nums) {
            if (counters.containsKey(num)) {
                counters.put(num, counters.get(num) + 1);
            }
        }

        int maxCounter = 0, maxKey = 0;
        for (Integer key : counters.keySet()) {
            if (counters.get(key) > maxCounter) {
                maxCounter = counters.get(key);
                maxKey = key;
            }
        }

        return maxKey;
    }

    private void removeKey(Map<Integer, Integer> counters) {

        List<Integer> removeList = new ArrayList<>();
        for (Integer key : counters.keySet()) {
            counters.put(key, counters.get(key) - 1);
            if (counters.get(key) == 0) {
                removeList.add(key);
            }
        }

        for (Integer key : removeList) {
            counters.remove(key);
        }
    }
}
