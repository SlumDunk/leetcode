package com.github.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the children greater numbers for nums1's elements in the corresponding places of nums2.
 * <p>
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 * <p>
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the children greater number for it in the second array, so output -1.
 * For number 1 in the first array, the children greater number for it in the second array is 3.
 * For number 2 in the first array, there is no children greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the children greater number for it in the second array is 3.
 * For number 4 in the first array, there is no children greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 *
 * @author liuzhongda
 */
public class Leetcode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        //存储数组1中各数字和位置索引的关系
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        //栈顶存储右边比他大的元素，保证栈顶存储的是最近比他大的元素
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        for (int i = nums2.length - 1; i >= 0; i--) {
            //若栈顶的元素比当前值小，出栈
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                stack.pop();
            }
            if (map.containsKey(nums2[i])) {
                if (!stack.isEmpty()) {//栈非空
                    res[map.get(nums2[i])] = stack.peek();
                } else {//栈为空，那么右边没有元素大于当前元素
                    res[map.get(nums2[i])] = -1;
                }
            }
            stack.push(nums2[i]);
        }
        return res;
    }

    public static int[] nextGreaterElementII(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (i == nums2.length - 1) {
                numMap.put(nums2[i], -1);
            } else {
                for (int k = i + 1; k < nums2.length - 1; k++) {
                    if (nums2[k] > nums2[i]) {
                        numMap.put(nums2[i], nums2[k]);
                        break;
                    }
                }
                if (numMap.get(nums2[i]) == null) {
                    numMap.put(nums2[i], -1);
                }
            }
        }
        int[] nums = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            nums[i] = numMap.get(nums1[i]);
        }
        return nums;
    }

}
