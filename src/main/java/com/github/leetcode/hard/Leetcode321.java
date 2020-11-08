package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 2/24/19 20:41
 * @Description: Given two arrays of length m and n with digits 0-9 representing two numbers. Create the maximum number of length k <= m + n from digits of the two. The relative order of the digits from the same array must be preserved. Return an array of the k digits.
 * <p>
 * Note: You should try to optimize your time and space complexity.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * Output:
 * [9, 8, 6, 5, 3]
 * Example 2:
 * <p>
 * Input:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * Output:
 * [6, 7, 6, 0, 4]
 * Example 3:
 * <p>
 * Input:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * Output:
 * [9, 8, 9]
 */
public class Leetcode321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[0];
        for (int i = Math.max(0, k - nums2.length); i <= Math.min(k, nums1.length); ++i)
            best = max(best, 0, maxNumber(maxNumber(nums1, i), maxNumber(nums2, k - i)), 0);
        return best;
    }

    /**
     * 数组中取K个数组成最大的数字
     *
     * @param nums
     * @param k
     * @return
     */
    private int[] maxNumber(int[] nums, int k) {
        int[] ans = new int[k];
        int j = 0;
        for (int i = 0; i < nums.length; ++i) {
            while (j > 0 && nums[i] > ans[j - 1] && nums.length - i > k - j)
                --j;
            if (j < k)
                ans[j++] = nums[i];
        }
        return ans;
    }

    /**
     * 返回两个数组数字能组成的最大的数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] maxNumber(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length + nums2.length];
        int s1 = 0;
        int s2 = 0;
        int index = 0;
        while (s1 != nums1.length || s2 != nums2.length)
            ans[index++] = max(nums1, s1, nums2, s2) == nums1 ?
                    nums1[s1++] : nums2[s2++];
        return ans;
    }

    /**
     * 比较两个子数组的大小，返回大的子数组
     *
     * @param nums1
     * @param s1
     * @param nums2
     * @param s2
     * @return
     */
    private int[] max(int[] nums1, int s1, int[] nums2, int s2) {
        for (int i = s1; i < nums1.length; ++i) {
            int j = s2 + i - s1;
            if (j >= nums2.length) return nums1;
            if (nums1[i] < nums2[j]) return nums2;
            if (nums1[i] > nums2[j]) return nums1;
        }
        return nums2;
    }


    /**
     * O(k*(2*(m+n)+k))
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public int[] maxNumber_(int[] nums1, int[] nums2, int k) {
        if (k == 0) {
            return new int[0];
        }

        int m = nums1.length, n = nums2.length;
        if (m + n < k) return null;

        if (m + n == k) {
            int[] results = merge(nums1, nums2, k);
            return results;
        } else {
            int max = m >= k ? k : m;
            int min = n >= k ? 0 : k - n;

            int[] results = new int[k];
            for (int i = 0; i < k; i++) {
                results[i] = Integer.MIN_VALUE;
            }
            for (int i = min; i <= max; i++) {
                int[] temp = merge(getMax(nums1, i), getMax(nums2, k - i), k);
                results = isGreater(results, 0, temp, 0) ? results : temp;
            }

            return results;
        }
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] results = new int[k];
        if (k == 0) return results;
        int i = 0, j = 0;
        for (int l = 0; l < k; l++) {
            results[l] = isGreater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        }
        return results;
    }


    private boolean isGreater(int[] nums1, int i, int[] nums2, int j) {
        for (; i < nums1.length && j < nums2.length; i++, j++) {
            if (nums1[i] > nums2[j]) {
                return true;
            }
            if (nums1[i] < nums2[j]) {
                return false;
            }
        }

        return i != nums1.length;
    }

    private int[] getMax(int[] nums, int k) {
        if (k == 0) {
            return new int[0];
        }

        int[] results = new int[k];
        int i = 0;
        for (int j = 0; j < nums.length; j++) {

            while (nums.length - j + i > k && i > 0 && results[i - 1] < nums[j]) {
                i--;
            }
            if (i < k) {
                results[i++] = nums[j];
            }
        }

        return results;
    }
}
