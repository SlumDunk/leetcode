package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/25/19 23:03
 * @Description: Given an integer array nums with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example
 * Example1
 * <p>
 * Input: nums = [1, 2, 4], and target = 4
 * Output: 6
 * Explanation:
 * The possible combination ways are:
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 * [4]
 * Example2
 * <p>
 * Input: nums = [1, 2], and target = 4
 * Output: 5
 * Explanation:
 * The possible combination ways are:
 * [1, 1, 1, 1]
 * [1, 1, 2]
 * [1, 2, 1]
 * [2, 1, 1]
 * [2, 2]
 * Notice
 * A number in the array can be used multiple times in the combination.
 * Different orders are counted as different combinations.
 */
public class Lintcode564 {
    /**
     * @param nums:   an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI(int[] nums, int target) {
        // write your code here
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int i, j;
        int[] pai = new int[target + 1];
        int[] f = new int[target + 1];
        f[0] = 1;
        for (i = 1; i <= target; i++) {
            for (j = 0; j < n; j++) {
                if (i >= nums[j]) {
                    f[i] += f[i - nums[j]];
                    if (f[i - nums[j]] > 0) {
                        pai[i] = nums[j];
                    }
                }
            }
        }

        if (f[target] > 0) {
            i = target;
            System.out.println(i + "=");
            while (i != 0) {
                System.out.println(pai[i]);
                i -= pai[i];
            }
        }
        return f[target];
    }



    /**
     * @param nums: an integer array and all positive numbers, no duplicates
     * @param target: An integer
     * @return: An integer
     */
    public int backPackVI__(int[] nums, int target) {
        // write your code here
        int n=nums.length;
        int[] dp=new int[target+1];

        dp[0]=1;
        for(int i=1;i<=target;i++){
            for(int j=0;j<n;j++){//最后一步
                if(nums[j]<=i){
                    dp[i]+=dp[i-nums[j]];
                }
            }
        }

        return dp[target];
    }
}
