package com.github.lintcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 17:38
 * @Description: Given an array of integers, find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are zero-based.
 * <p>
 * Example
 * numbers=[2, 7, 11, 15], target=9
 * <p>
 * return [0, 1]
 * <p>
 * Challenge
 * Either of the following solutions are acceptable:
 * <p>
 * O(n) Space, O(nlogn) Time
 * O(n) Space, O(n) Time
 * Notice
 * You may assume that each input would have exactly one solution
 */
public class Lintcode56 {
    class Pair {
        Integer value;
        Integer index;

        Pair(Integer value, Integer index) {
            this.value = value;
            this.index = index;
        }

        Integer getValue() {
            return this.value;
        }
    }

    class ValueComparator implements Comparator<Pair> {
        public int compare(Pair o1, Pair o2) {
            return o1.getValue().compareTo(o2.getValue());
        }
    }

    /**
     * @param numbers: An array of Integer
     * @param target:  target = numbers[index1] + numbers[index2]
     * @return: [index1, index2] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        //哈希表
        //双指针
        Pair[] pairs = new Pair[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            pairs[i] = new Pair(numbers[i], i);
        }
        Arrays.sort(pairs, new ValueComparator());
        int left = 0, right = pairs.length - 1;
        while (left < right) {
            if (pairs[left].getValue() + pairs[right].getValue() == target) {
                int index1 = pairs[left].index;
                int index2 = pairs[right].index;
                int[] result = {Math.min(index1, index2), Math.max(index1, index2)};
                return result;
            }
            if (pairs[left].getValue() + pairs[right].getValue() < target) {
                left++;
            } else {
                right--;
            }
        }

        int[] result = {};
        return result;
    }
}
