package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 11:27
 * @Description: Given an integer d between 0 and 9, and two positive integers low and high as lower and upper bounds, respectively. Return the number of times that d occurs as a digit in all integers between low and high, including the bounds low and high.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: d = 1, low = 1, high = 13
 * Output: 6
 * Explanation:
 * The digit d=1 occurs 6 times in 1,10,11,12,13. Note that the digit d=1 occurs twice in the number 11.
 * Example 2:
 * <p>
 * Input: d = 3, low = 100, high = 250
 * Output: 35
 * Explanation:
 * The digit d=3 occurs 35 times in 103,113,123,130,131,...,238,239,243.
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= d <= 9
 * 1 <= low <= high <= 2×10^8
 */
public class Leetcode1067 {
    public static void main(String[] args) {
        Leetcode1067 leetcode1067 = new Leetcode1067();
        leetcode1067.digitsCount(1, 1, 13);
    }

    public int digitsCount(int d, int low, int high) {
        return countDigit(high, d) - countDigit(low - 1, d);
    }

    /**
     * @param n 右边界值
     * @param d 出现的digit
     * @return
     */
    int countDigit(int n, int d) {
        int res = 0;
        if (n < 1) return 0;
        int p = 1;
        //10 130
        //100 130
        while (Math.pow(10, p) <= n * 10) {
            res += count(d, n, p);
            p++;
        }
        return res;
    }

    /**
     * d=1, n=13
     * pow10=10, prePow10=1
     * residue=3
     *
     *
     * @param d
     * @param n
     * @param p
     * @return
     */
    private int count(int d, int n, int p) {
        double pow10 = Math.pow(10, p), prePow10 = pow10 / 10;
        //最高位取d且不超过n的数字个数
        int res = (int) ((int)(n / pow10) * prePow10);
        //首位不能取0
        if (d == 0) res -= prePow10;
        //取余
        int residue = (int)(n % pow10);
        int val = (int) (residue / prePow10);
        //处理最低位
        if (val > d) {//11这种情况
            res += prePow10;
        } else if (val == d) {
            res += residue - prePow10 * d + 1;
        }
        return res;
    }
}
