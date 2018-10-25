package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 09:38
 * @Description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * <p>
 * Find the minimum element.
 * <p>
 * You may assume no duplicate exists in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,4,5,1,2]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */
public class Leetcode153 {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start < end) { //注意这里和普通的二分查找不同，这里是start < end不是 start <= end.
            mid = start + (end - start) / 2;
            if (nums[mid] > nums[end])
                start = mid + 1; //此时可以扔掉mid的值
            else
                end = mid;//此时不能扔掉mid的值
        }
        return nums[end]; //退出循环说明start与end相等，所以只剩一个元素可能，所以return [start]或者return [end]都可以了。
        //注意不能return mid，可以从{2,1}这个输入看出来。
    }
}
