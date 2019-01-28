package com.github.lintcode.easy;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 11:28
 * @Description:
 */
public class Lintcode46 {
    /*
     * @param nums: a list of integers
     * @return: find a  majority number
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        if (nums == null || nums.size() == 0) {
            return -1;
        }
        int currentMajor = 0;
        int count = 0;
        //两个数不同就从集合里扔掉
        for (Integer num : nums) {
            if (count == 0) {
                currentMajor = num;
            }
            if (num == currentMajor) {
                count++;
            } else {
                count--;
            }
        }
        return currentMajor;
    }
}
