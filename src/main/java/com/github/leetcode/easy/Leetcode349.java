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
        //利用set的唯一性
        Set<Integer> set1 = new HashSet<Integer>();
        List<Integer> resultList = new ArrayList<Integer>();
        Arrays.sort(nums2);
        for (int i = 0; i < nums1.length; i++) {
            //进行二分查找
            if (Arrays.binarySearch(nums2, nums1[i]) >= 0 && !resultList.contains(nums1[i])) {
                resultList.add(nums1[i]);
            }
        }

        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
