package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/2/18 14:15
 * @Description: Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * <p>
 * Example:
 * <p>
 * Input: 2
 * Output: 91
 * Explanation: The answer should be the total numbers in the range of 0 ≤ x < 100,
 * excluding 11,22,33,44,55,66,77,88,99
 */
public class Leetcode357 {
    public static void main(String[] args) {
        Leetcode357 leetcode357 = new Leetcode357();
        System.out.println(leetcode357.countNumbersWithUniqueDigits(10));
    }

    public int countNumbersWithUniqueDigits(int n) {
//        backtrack(0,n, new boolean[10]);
        if (n == 0) return 1;
        if (n == 1) return 10;
        //存储n位数不唯一的数字数量
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 10;
        int result = dp[1];
        //应用排列组合公式
        for (int i = 2; i <= n; i++) {
            dp[i] = 9;//第一位只能有9种选择
            for (int j = 1; j < i; j++) {
                dp[i] *= (10 - j);
            }
            result += dp[i];
        }
        return result;
    }

    /**
     * @param digit      当前位数
     * @param totalDigit 总共位数
     * @param used       数字使用标记数组
     * @return 000
     */
    private int backtrack(int digit, int totalDigit, boolean[] used) {
        if (digit == totalDigit) return 1;
        //必须以1开始
        int total = 1;
        //第一位数字只能是1-9
        for (int j = (digit == 0) ? 1 : 0; j <= 9; j++) {
            if (!used[j]) {
                used[j] = true;
                //往前一位
                total += backtrack(digit + 1, totalDigit, used);
                used[j] = false;
            }
        }
        return total;
    }
}
