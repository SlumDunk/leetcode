package com.github.lintcode.hard;

/**
 * @Author: zerongliu
 * @Date: 7/25/19 18:04
 * @Description: Description
 * 中文
 * English
 * Given n books and the i-th book has pages[i] pages. There are k persons to copy these books.
 * <p>
 * These books list in a row and each person can claim a continous range of books. For example, one copier can copy the books from i-th to j-th continously, but he can not copy the 1st book, 2nd book and 4th book (without 3rd book).
 * <p>
 * They start copying books at the same time and they all cost 1 minute to copy 1 page of a book. What's the best strategy to assign books so that the slowest copier can finish at earliest time?
 * <p>
 * Return the shortest time that the slowest copier spends.
 * <p>
 * Have you met this question in a real interview?
 * Example
 * Example 1:
 * <p>
 * Input: pages = [3, 2, 4], k = 2
 * Output: 5
 * Explanation:
 * First person spends 5 minutes to copy book 1 and book 2.
 * Second person spends 4 minutes to copy book 3.
 * Example 2:
 * <p>
 * Input: pages = [3, 2, 4], k = 3
 * Output: 4
 * Explanation: Each person copies one of the books.
 * Challenge
 * O(nk) time
 */
public class Lintcode437 {
    /**
     * @param pages: an array of integers
     * @param k:     An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int n = pages.length;
        if (n == 0) {
            return 0;
        }
        if (k > n) {
            k = n;
        }

        int[][] f = new int[k + 1][n + 1];
        int i, j, l;
        f[0][0] = 0;
        for (j = 1; j <= n; j++) {
            f[0][j] = Integer.MAX_VALUE;
        }
        int sum = 0;
        for (l = 1; l <= k; l++) {
            f[l][0] = 0;
            for (i = 1; i <= n; i++) {
                f[l][i] = Integer.MAX_VALUE;
                sum = 0;
                //划分
                for (j = i; j >= 0; j--) {
                    f[l][i] = Math.min(f[l][i], Math.max(f[l - 1][j], sum));
                    if (j > 0) {
                        sum += pages[j - 1];
                    }
                }
            }
        }
        return f[k][n];
    }
}
