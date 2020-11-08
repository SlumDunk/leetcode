package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 20:45
 * @Description: A magical string S consists of only '1' and '2' and obeys the following rules:
 * <p>
 * The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string S itself.
 * <p>
 * The first few elements of string S is the following: S = "1221121221221121122……"
 * <p>
 * If we group the consecutive '1's and '2's in S, it will be:
 * <p>
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......
 * <p>
 * and the occurrences of '1's or '2's in each group are:
 * <p>
 * 1 2	2 1 1 2 1 2 2 1 2 2 ......
 * <p>
 * You can see that the occurrence sequence above is the S itself.
 * <p>
 * Given an integer N as input, return the number of '1's in the first N number in the magical string S.
 * <p>
 * Note: N will not exceed 100,000.
 * <p>
 * Example 1:
 * Input: 6
 * Output: 3
 * Explanation: The first 6 elements of magical string S is "12211" and it contains three 1's, so return 3.
 */
public class Leetcode481 {
    /**
     * 12211
     * 1 22 11 2 1
     * 1 2 2 1 1
     * 122开头
     *
     * @param n
     * @return
     */
    public int magicalString(int n) {
        if (n < 1) return 0;
        if (n < 4) return 1;
        //魔术字符串数组
        int[] magic = new int[n];
        magic[0] = 1;
        magic[1] = 2;
        magic[2] = 2;

        int result = 1;
        int next = 1;  // children number, 1 or 2
        int countIndex = 2;//计数的索引
        int count = magic[countIndex];  //下一个数字出现的次数

        for (int i = 3; i < n; ) {
            while (count > 0 && i < n) {
                if (next == 1) {
                    result++;
                }
                magic[i] = next;
                count--;
                i++;
            }
            next = next == 1 ? 2 : 1;
            countIndex++;
            count = magic[countIndex];
        }
        return result;
    }
}
