package com.github.leetcode.easy;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 12/19/18 08:35
 * @Description: Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class Leetcode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        //利用set元素唯一性的特性
        Set<Integer> resultSet = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] == nums2[j]) {
                resultSet.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] result = new int[resultSet.size()];
        int index = 0;
        Iterator<Integer> iterator = resultSet.iterator();
        while (iterator.hasNext()) {
            result[index] = iterator.next();
            index++;
        }
        return result;
    }
}
