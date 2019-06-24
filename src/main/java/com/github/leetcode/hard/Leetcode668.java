package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/8/19 11:32
 * @Description: Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from the multiplication table?
 * <p>
 * Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return the k-th smallest number in this table.
 * <p>
 * Example 1:
 * Input: m = 3, n = 3, k = 5
 * Output:
 * Explanation:
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 * 3	6	9
 * <p>
 * The 5-th smallest number is 3 (1, 2, 2, 3, 3).
 * Example 2:
 * Input: m = 2, n = 3, k = 6
 * Output:
 * Explanation:
 * The Multiplication Table:
 * 1	2	3
 * 2	4	6
 * <p>
 * The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
 * Note:
 * The m and n will be in the range [1, 30000].
 * The k will be in the range [1, m * n]
 */
public class Leetcode668 {
    public int findKthNumber(int m, int n, int k) {
        if (m * n < k) {
            return -1;
        }
        int l = 1;
        int r = m * n;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            int cnt = count(mid, m, n);
            if (cnt >= k) {
                r = mid;
            } else {
                l = mid;
            }
        }
        if (count(l, m, n) >= k) {
            return l;
        } else {
            return r;
        }
    }

    /**
     * @param v
     * @param m 行数量
     * @param n 列数量
     * @return
     */
    private int count(int v, int m, int n) {
        int cnt = 0;
        //每行比v小的数字个数
        for (int i = 1; i <= m; ++i) {
            cnt += Math.min(n, v / i);
        }
        return cnt;
    }
}
