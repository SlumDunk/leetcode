package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class Leetcode167 {
    public static void main(String[] args) {
        Leetcode167 leetcode167 = new Leetcode167();
        int[] numbers = {-1, 0};
        System.out.println(leetcode167.twoSum(numbers, -1));
    }

    public int[] twoSum(int[] numbers, int target) {
        //return findWithList(numbers, target);
        //使用滑动窗口，双指针，逐步缩小范围
        int left = 0, right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            int tmp = numbers[left] + numbers[right];
            if (tmp == target) {
                result[0] = ++left;
                result[1] = ++right;
                return result;
            } else if (tmp > target) {
                while (numbers[right - 1] == numbers[right]) {
                    right--;
                }
                right--;
            } else {
                while (numbers[left + 1] == numbers[left]) {
                    left++;
                }
                left++;
            }
        }
        return result;
    }

    private int[] findWithList(int[] numbers, int target) {
        List<Integer> numberList = new ArrayList<Integer>();
        for (int i = 0; i < numbers.length; i++) {
            numberList.add(numbers[i]);
        }
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int anotherFactor = target - numbers[i];
            int index = numberList.indexOf(anotherFactor);
            if (index != -1 && index != i) {
                result[0] = ++i;
                result[1] = ++index;
                Arrays.sort(result);
                return result;
            }
        }
        return result;
    }
}
