package com.github.leetcode.easy;

import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Author: zerongliu
 * @Date: 11/2/20 21:11
 * @Description: Given an array of integers arr, replace each element with its rank.
 * <p>
 * The rank represents how large the element is. The rank has the following rules:
 * <p>
 * Rank is an integer starting from 1.
 * The larger the element, the larger the rank. If two elements are equal, their rank must be the same.
 * Rank should be as small as possible.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [40,10,20,30]
 * Output: [4,1,2,3]
 * Explanation: 40 is the largest element. 10 is the smallest. 20 is the second smallest. 30 is the third smallest.
 * Example 2:
 * <p>
 * Input: arr = [100,100,100]
 * Output: [1,1,1]
 * Explanation: Same elements share the same rank.
 * Example 3:
 * <p>
 * Input: arr = [37,12,28,9,100,56,80,5,12]
 * Output: [5,3,4,2,8,6,7,1,3]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= arr.length <= 105
 * -109 <= arr[i] <= 109
 */
public class Leetcode1331 {
    public int[] arrayRankTransform(int[] arr) {
        if (arr == null) {
            return null;
        }
        Set<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        int rank = 1;
        for (Integer item :
                set) {
            map.put(item, rank++);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }
        return arr;
    }
}
