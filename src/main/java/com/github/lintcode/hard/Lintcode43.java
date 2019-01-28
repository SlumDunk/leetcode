package com.github.lintcode.hard;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 16:20
 * @Description:
 */
public class Lintcode43 {
    public static void main(String[] args) {
        Lintcode43 lintcode43 = new Lintcode43();
        int[] nums = new int[]{1, 2, 3};
        int k = 1;
        lintcode43.maxSubArray(nums, k);
    }

    /**
     * @param nums: A list of integers
     * @param k:    An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < k) {
            return 0;
        }
        int len = nums.length;
        //前i个数字做k次切分的最大值
        int[][] globalMax = new int[k + 1][len + 1];
        //以第i个数字结尾的数字做k次切分的最大值
        int[][] localMax = new int[k + 1][len + 1];

        for (int i = 1; i <= k; i++) {
            localMax[i][i - 1] = Integer.MIN_VALUE;
            for (int j = i; j <= len; j++) {
                //第j个数字跟上一个数字组成一个子串，或者单独组成一个子数组
                localMax[i][j] = Math.max(localMax[i][j - 1], globalMax[i - 1][j - 1]) + nums[j - 1];
                if (j == i) {
                    globalMax[i][j] = localMax[i][j];
                } else {
                    //包不包括第j个数字
                    globalMax[i][j] = Math.max(globalMax[i][j - 1], localMax[i][j]);
                }
            }
        }
        for (int i = 0; i < localMax.length; i++) {
            for (int j = 0; j < localMax[0].length; j++) {
                System.out.printf(localMax[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("--------------------------------");
        for (int i = 0; i < globalMax.length; i++) {
            for (int j = 0; j < globalMax[0].length; j++) {
                System.out.printf(globalMax[i][j] + " ");
            }
            System.out.println();
        }
        return globalMax[k][len];
    }
}
