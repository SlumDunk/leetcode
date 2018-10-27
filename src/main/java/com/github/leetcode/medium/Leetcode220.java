package com.github.leetcode.medium;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Author: zerongliu
 * @Date: 10/26/18 12:52
 * @Description: Given an array of integers, find out whether there are two distinct indices i and j in the array such that the absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1], k = 3, t = 0
 * Output: true
 * Example 2:
 * <p>
 * Input: nums = [1,0,1,1], k = 1, t = 2
 * Output: true
 * Example 3:
 * <p>
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3
 * Output: false
 */
public class Leetcode220 {
    public static void main(String[] args) {
        Leetcode220 leetcode220 = new Leetcode220();
        leetcode220.containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0);
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;
        SortedSet<Long> binTree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> son = binTree.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            if (!son.isEmpty())
                return true;
            if (i >= k)
                binTree.remove((long) nums[i - k]);
            binTree.add((long) nums[i]);
        }
        return false;
    }
}
