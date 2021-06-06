package com.github.leetcode.easy;

import java.util.HashMap;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 16:46
 * @Description: Given an array of integers arr, a lucky integer is an integer which has a frequency in the array equal to its value.
 * <p>
 * Return a lucky integer in the array. If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [2,2,3,4]
 * Output: 2
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 * Example 2:
 * <p>
 * Input: arr = [1,2,2,3,3,3]
 * Output: 3
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
 * Example 3:
 * <p>
 * Input: arr = [2,2,2,3,3]
 * Output: -1
 * Explanation: There are no lucky numbers in the array.
 * Example 4:
 * <p>
 * Input: arr = [5]
 * Output: -1
 * Example 5:
 * <p>
 * Input: arr = [7,7,7,7,7,7,7]
 * Output: 7
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 */
public class Leetcode1394 {
    public int findLucky(int[] arr) {
        if (arr.length == 0)
            return 0;
        if (arr.length == 1 && arr[0] == 1)
            return 1;

        HashMap<Integer, Integer> map = new HashMap<>();
        int magicCount = -1;

        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i]) == null) {
                map.put(arr[i], 1);
            } else
                map.put(arr[i], map.get(arr[i]) + 1);
        }//for
        for (int key : map.keySet()) {
            if (map.get(key) == key) {
                magicCount = Math.max(magicCount, key);
            }

        }
        return magicCount;
    }
}
