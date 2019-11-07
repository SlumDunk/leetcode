package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 11/4/18 20:21
 * @Description: Given an integer array with all positive numbers and no duplicates, find the number of possible combinations that add up to a positive integer target.
 * <p>
 * Example:
 * <p>
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * The possible combination ways are:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * Note that different sequences are counted as different combinations.
 * <p>
 * Therefore the output is 7.
 * Follow up:
 * What if negative numbers are allowed in the given array?
 * How does it change the problem?
 * What limitation we need to add to the question to allow negative numbers?
 * <p>
 * Credits:
 * Special thanks to @pbrother for adding this problem and creating all test case
 */
public class Leetcode377 {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0 || target <= 0) return 0;
//        int[] dp = new int[target + 1];
//        dp[0] = 1;
//        for (int i = 1; i <= target; i++)
//            for (int j = 0; j < nums.length; j++)
//                if (i >= nums[j]) dp[i] += dp[i - nums[j]];
//        return dp[target];
        //中间数组，用于存储能够组合成目标和的组合次数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }


    /**
     * O(target*N)
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4__(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;

        Arrays.sort(nums);

        for(int i=1;i<=target;i++){
            for(int num:nums){
                if(num>i){
                    break;
                }else{
                    dp[i]+=dp[i-num];
                }
            }
        }

        return dp[target];
    }
}
