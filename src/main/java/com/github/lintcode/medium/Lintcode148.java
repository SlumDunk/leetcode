package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 22:26
 * @Description:
 */
public class Lintcode148 {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        //做两次array partition, 第一次，0划分一边，1，2划分一边，第二次划分1，2
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int len = nums.length;
        int i = 0, j = len - 1;
        int pivot = 0;
        while (i < j) {
            while (i < len && nums[i] == 0) {
                i++;
            }
            while (j >= 0 && nums[j] != 0) {
                j--;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
            } else {
                break;
            }
        }
        for (i = 0; i < len; i++) {
            if (nums[i] != 0) {
                break;
            }
        }
        j = len - 1;
        while (i < j) {
            while (i < len && nums[i] == 1) {
                i++;
            }
            while (j >= i && nums[j] == 2) {
                j--;
            }
            if (i < j) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j--;
            } else {
                break;
            }
        }
    }
}
