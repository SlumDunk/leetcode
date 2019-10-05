package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/1/18 21:55
 * @Description: Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
 * <p>
 * Example 1:
 * <p>
 * Input: 2
 * Output: [0,1,1]
 * Example 2:
 * <p>
 * Input: 5
 * Output: [0,1,1,2,1,2]
 * Follow up:
 * <p>
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class Leetcode338 {
    public int[] countBits(int num) {
        if (num < 0) {
            return new int[]{};
        } else {
            //[0,2),[2,4),[4,8)
            //[000,001),[010,011),[100,101,110,111)
            //存储第n个数字有多少个1, 以2的i-1次幂到2的i次幂是一个周期
            int[] dp = new int[num + 1];
            dp[0] = 0;
            int base = 1;
            while (base <= num) {
                int next = base * 2;//下一个周期数字
                for (int i = base; i < next && i <= num; i++) {
                    //新高位置为1，后面位数为之前的dp中1的位数
                    dp[i] = dp[i - base] + 1;
                }
                base = next;
            }
            return dp;
        }
    }

    public int[] countBits__(int num) {
        int[] dp = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            dp[i] = i % 2 + dp[i >> 1];
        }

        return dp;
    }
}
