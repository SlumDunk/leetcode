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
            int[] res = new int[num + 1];
            res[0] = 0;

            int base = 1;//末尾为1的情况
            while (base <= num) {
                int next = base * 2;//下一个末尾全为0的值
                for (int i = base; i < next && i <= num; i++) {
                    res[i] = res[i - base] + 1;
                }
                base = next;
            }
            return res;
        }
    }
}
