package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 08:47
 * @Description: Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 * <p>
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 * 那么如果某一个数x发生了重复，那么遍历这个数组，一定能找到至少x+1个数小于等于x
 */
public class Leetcode287 {
    public static void main(String[] args) {
        Leetcode287 leetcode287 = new Leetcode287();
        leetcode287.findDuplicate(new int[]{2, 2, 4, 1, 3});
    }

    public int findDuplicate(int[] nums) {
        //取值范围是1-n
        int left = 1, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;//利用mid的位置指针来定位多余的数字的取值范围
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            //重复数字在1-mid之间
            if (count > mid) {
                right = mid;//缩小范围
            } else {//重复数字在mid+1到n之间
                left = mid + 1;
            }
        }
        return left;//left和right同样大
    }
}
