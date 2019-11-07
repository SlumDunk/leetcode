package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 22:16
 * @Description: There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 */
public class Leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //以长度小的那个数组为基准 O(log(min(x,y))
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        } else {
            int x = nums1.length;
            int y = nums2.length;
            int low = 0;
            int high = x;
            while (low <= high) {
                int partionx = (low + high) / 2;
                int partiony = (x + y + 1) / 2 - partionx;
                //注意边界条件
                int maxLeftX = partionx == 0 ? Integer.MIN_VALUE : nums1[partionx - 1];
                int minRightX = partionx == x ? Integer.MAX_VALUE : nums1[partionx];

                int maxLeftY = partiony == 0 ? Integer.MIN_VALUE : nums2[partiony - 1];
                int minRighty = partiony == y ? Integer.MAX_VALUE : nums2[partiony];

                if (maxLeftX <= minRighty && maxLeftY <= minRightX) {//满足条件
                    if ((x + y) % 2 == 0) {//数组长度和为偶数
                        return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRighty)) / 2.0;
                    } else {
                        return Math.max(maxLeftX, maxLeftY);
                    }
                } else if (maxLeftX > minRighty) {//高位指针左移
                    high = partionx - 1;
                } else {//低位指针右移
                    low = partionx + 1;
                }

            }
        }
        return -1.0;
    }

    public double findMedian(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, n / 2) + findKth(nums1, 0, nums2, 0, n / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, 0, nums2, 0, n / 2 + 1);
        }
    }

    /**
     * @param nums1  数组1
     * @param start1 数组1开始位置
     * @param nums2  数组2
     * @param start2 数组2开始位置
     * @param k      找第k大的数 每次扔掉k/2
     * @return
     */
    public int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int half1 = (start1 + k / 2 - 1) < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int half2 = (start2 + k / 2 - 1) < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;

        if (half1 < half2) {
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }


    //1 2 3 4
    public double findMedianSortedArrays__(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int k = m + n;
        if (k % 2 != 0) {
            return findKth(nums1, nums2, 0, 0, k / 2 + 1);
        } else {
            return (findKth(nums1, nums2, 0, 0, k / 2) + findKth(nums1, nums2, 0, 0, 1 + k / 2)) / 2.0;
        }
    }

    private int findKth(int[] nums1, int[] nums2, int start1, int start2, int k) {
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int index1 = start1 + k / 2 - 1;
        int index2 = start2 + k / 2 - 1;
        int a = index1 >= nums1.length ? Integer.MAX_VALUE : nums1[index1];
        int b = index2 >= nums2.length ? Integer.MAX_VALUE : nums2[index2];
        if (a <= b) {
            return findKth(nums1, nums2, start1 + k / 2, start2, k - k / 2);
        } else {
            return findKth(nums1, nums2, start1, start2 + k / 2, k - k / 2);
        }
    }
}
