package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/29/18 17:08
 * @Description: Write a function that takes an unsigned integer and return the number of '1' bits it has (also known as the Hamming weight).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 00000000000000000000000000001011
 * Output: 3
 * Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.
 * Example 2:
 * <p>
 * Input: 00000000000000000000000010000000
 * Output: 1
 * Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.
 * Example 3:
 * <p>
 * Input: 11111111111111111111111111111101
 * Output: 31
 * Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.
 */
public class Leetcode191 {
    public int hammingWeight(int n) {
        //利用n和n-1与操作的结果
        //n&=(n-1) 最低位的1改为0
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public int hammingWeight__(int n) {
        int result = 0;

        while (n != 0) {
            //取得最低位的1
            n &= (n - 1);
            result++;
        }

        return result;
    }
}
