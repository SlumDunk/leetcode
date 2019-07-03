package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 07:44
 * @Description: Given a non-negative integer N, find the largest number that is less than or equal to N with monotone increasing digits.
 * <p>
 * (Recall that an integer has monotone increasing digits if and only if each pair of adjacent digits x and y satisfy x <= y.)
 * <p>
 * Example 1:
 * Input: N = 10
 * Output: 9
 * Example 2:
 * Input: N = 1234
 * Output: 1234
 * Example 3:
 * Input: N = 332
 * Output: 299
 * Note: N is an integer in the range [0, 10^9].
 */
public class Leetcode738 {
    public static void main(String[] args) {
        Leetcode738 leetcode738 = new Leetcode738();
        leetcode738.monotoneIncreasingDigits(332);
    }

    public int monotoneIncreasingDigits(int N) {
        char[] nStr = String.valueOf(N).toCharArray();
        char[] mono = new char[nStr.length];
        for (int i = 0; i < nStr.length; i++) {
            //先置为当前字符
            mono[i] = nStr[i];
            //必须是递增的 如果不是递增，需要作调整 3 3 2-> 3 2 9->2 9 9
            for (int k = i; k >= 1 && mono[k] < mono[k - 1]; k--) {
                //低位置为9
                mono[k] = '9';
                if (mono[k - 1] == nStr[k - 1])
                    mono[k - 1]--;
            }
        }
        return Integer.valueOf(new String(mono));
    }
}
