package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 09:44
 * @Description: A peak element is an element that is greater than its neighbors.
 * <p>
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 * <p>
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * <p>
 * You may imagine that nums[-1] = nums[n] = -∞.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 * <p>
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 * or index number 5 where the peak element is 6.
 */
public class Leetcode162 {
    public static void main(String[] args) {
        Leetcode162 leetcode162 = new Leetcode162();
        System.out.println(leetcode162.findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 7}));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            //中间元素和左右两边元素比较 几何图形应该是先升后降
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[mid - 1]) {//左边下降，峰值在左
                right = mid;
            } else if (nums[mid] < nums[mid + 1]) {//右边上升，峰值在右
                left = mid;
            } else {//左上升，右下降
                right = mid;
            }
        }
        if (nums[left] < nums[right]) {
            return right;
        } else {
            return left;
        }
    }

    public int findPeakElement__(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        int mid = 0;
        //nums[-1] = nums[n] = -∞
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] < nums[mid - 1]) {//下降边，峰值在左边
                end = mid;
            } else if (nums[mid] < nums[mid + 1]) {//上升边，峰值在右
                start = mid;
            } else {//峰值点
                return mid;
            }
        }

        if (nums[start] < nums[end]) {
            return end;
        } else {
            return start;
        }

    }

}
