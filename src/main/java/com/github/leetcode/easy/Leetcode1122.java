package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 10:03
 * @Description: Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 */
public class Leetcode1122 {

    /**
     * O(n)
     *
     * @param arr1
     * @param arr2
     * @return
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1 == null || arr1.length == 0 || arr2 == null || arr2.length == 0) {
            return null;
        } else {
            Map<Integer, Integer> countMap = new TreeMap<>();
            for (int item :
                    arr1) {
                countMap.put(item, countMap.getOrDefault(item, 0) + 1);
            }

            int[] result = new int[arr1.length];
            int index = 0;
            for (int key :
                    arr2) {
                Integer value = countMap.get(key);
                while (value > 0) {
                    result[index++] = key;
                    value--;
                }
                countMap.remove(key);
            }

            for (Map.Entry<Integer, Integer> entry :
                    countMap.entrySet()) {
                Integer key = entry.getKey();
                Integer value = entry.getValue();
                while (value > 0) {
                    result[index++] = key;
                    value--;
                }
            }

            return result;
        }
    }
}
