package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 4/23/21 21:10
 * @Description: You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.
 * <p>
 * To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.
 * <p>
 * If k > 0, replace the ith number with the sum of the next k numbers.
 * If k < 0, replace the ith number with the sum of the previous k numbers.
 * If k == 0, replace the ith number with 0.
 * As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].
 * <p>
 * Given the circular array code and an integer key k, return the decrypted code to defuse the bomb!
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: code = [5,7,1,4], k = 3
 * Output: [12,10,16,13]
 * Explanation: Each number is replaced by the sum of the next 3 numbers. The decrypted code is [7+1+4, 1+4+5, 4+5+7, 5+7+1]. Notice that the numbers wrap around.
 * Example 2:
 * <p>
 * Input: code = [1,2,3,4], k = 0
 * Output: [0,0,0,0]
 * Explanation: When k is zero, the numbers are replaced by 0.
 * Example 3:
 * <p>
 * Input: code = [2,4,9,3], k = -2
 * Output: [12,5,6,13]
 * Explanation: The decrypted code is [3+9, 2+3, 4+2, 9+4]. Notice that the numbers wrap around again. If k is negative, the sum is of the previous numbers.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * n == code.length
 * 1 <= n <= 100
 * 1 <= code[i] <= 100
 * -(n - 1) <= k <= n - 1
 */
public class Leetcode1652 {
    public int[] decrypt(int[] code, int k) {
        int len = code.length;
        if (k == 0) {
            for (int i = 0; i < len; i++) {
                code[i] = 0;
            }
            return code;
        } else {
            int[] ans = new int[len];
            if (k > 0) {
                for (int i = 0; i < len; i++) {
                    int temp = 0;
                    int j = 1;
                    while (j <= k) {
                        temp += code[(j + i) % len];
                        j++;
                    }
                    ans[i] = temp;
                }
            } else {
                k = -1 * k;
                for (int i = len; i >= 0; i--) {
                    int temp = 0;
                    int j = 1;
                    while (j <= k) {
                        temp += code[(len + i - j) % len];
                        j++;
                    }
                    ans[i] = temp;
                }
            }
            return ans;
        }
    }
}
