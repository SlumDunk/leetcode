package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 18:46
 * @Description: Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 * <p>
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 */
public class Leetcode163 {
    public static void main(String[] args) {
        Leetcode163 leetcode163 = new Leetcode163();
        int[] nums = {0, 1, 3, 50, 75};
        System.out.println(leetcode163.findMissingRanges(nums, 0, 99));
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int index = 0;
        long aLower = (long) lower;
        long aUpper = (long) upper;
        while (index < nums.length) {
            if (aLower == nums[index]) {//左边界和当前值一致，继续前进
                aLower++;
                index++;
            } else if (nums[index] - aLower == 1) {//左边界和当前值相差1
                result.add(String.valueOf(aLower));
                aLower = nums[index] + 1;
                index++;
            } else if (nums[index] - aLower > 1) {//左边界和当前值相差大于1，求出右边界
                long right = nums[index] - 1;
                result.add(aLower + "->" + right);
                aLower = (long) nums[index] + 1;
                index++;
            } else {
                index++;
            }
        }
        //判断和上边界
        if (aLower <= aUpper) {
            if (aLower == aUpper) {
                result.add(String.valueOf(aLower));
            } else {
                result.add(aLower + "->" + aUpper);
            }
        }
        return result;
    }
}
