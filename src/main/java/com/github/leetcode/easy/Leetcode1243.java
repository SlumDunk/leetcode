package com.github.leetcode.easy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author: zerongliu
 * @Date: 12/25/20 20:26
 * @Description: Given an initial array arr, every day you produce a new array using the array of the previous day.
 * <p>
 * On the i-th day, you do the following operations on the array of day i-1 to produce the array of day i:
 * <p>
 * If an element is smaller than both its left neighbor and its right neighbor, then this element is incremented.
 * If an element is bigger than both its left neighbor and its right neighbor, then this element is decremented.
 * The first and last elements never change.
 * After some days, the array does not change. Return that final array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [6,2,3,4]
 * Output: [6,3,3,4]
 * Explanation:
 * On the first day, the array is changed from [6,2,3,4] to [6,3,3,4].
 * No more operations can be done to this array.
 * Example 2:
 * <p>
 * Input: arr = [1,6,3,4,3,5]
 * Output: [1,4,4,4,4,5]
 * Explanation:
 * On the first day, the array is changed from [1,6,3,4,3,5] to [1,5,4,3,4,5].
 * On the second day, the array is changed from [1,5,4,3,4,5] to [1,4,4,4,4,5].
 * No more operations can be done to this array.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 3 <= arr.length <= 100
 * 1 <= arr[i] <= 100
 */
public class Leetcode1243 {
    public List<Integer> transformArray(int[] arr) {
        while (performTransform(arr)) {
        }
        return Arrays.stream(arr).boxed().collect(Collectors.toList());
    }

    private boolean performTransform(int[] arr) {
        boolean isTransformed = false;
        int[] copy = Arrays.copyOf(arr, arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (i == 0 || i == arr.length - 1) continue;
            if (arr[i] < copy[i - 1] && arr[i] < copy[i + 1]) {
                arr[i]++;
                isTransformed = true;
            }
            if (arr[i] > copy[i - 1] && arr[i] > copy[i + 1]) {
                arr[i]--;
                isTransformed = true;
            }
        }
        return isTransformed;
    }
}
