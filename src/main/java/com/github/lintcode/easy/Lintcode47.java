package com.github.lintcode.easy;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 11:37
 * @Description: Given an array of integers, the majority number is the number that occurs more than 1/3 of the size of the array.
 * <p>
 * Find it.
 * <p>
 * Example
 * Given [1, 2, 1, 2, 1, 3, 3], return 1.
 * <p>
 * Challenge
 * O(n) time and O(1) extra space.
 * <p>
 * Notice
 * There is only one majority number in the array.
 */
public class Lintcode47 {
    /*
    * @param nums: a list of integers
    * @return: The majority number that occurs more than 1/3
    */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        //三个不一样的抵消
        int candidate1 = 0, candidate2 = 0;
        int count1 = 0, count2 = 0;
        for (Integer num : nums) {
            if (candidate1 == num) {
                count1++;
            } else if (candidate2 == num) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1++;
            } else if (count2 == 0) {
                candidate2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (Integer num : nums) {
            if (num == candidate1) {
                count1++;
            } else if (num == candidate2) {
                count2++;
            }
        }
        return count1 > count2 ? candidate1 : candidate2;
    }
}
