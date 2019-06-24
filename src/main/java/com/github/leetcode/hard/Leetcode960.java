package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/5/19 17:42
 * @Description: We are given an array A of N lowercase letter strings, all of the same length.
 * <p>
 * Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
 * <p>
 * For example, if we have an array A = ["babca","bbazb"] and deletion indices {0, 1, 4}, then the final array after deletions is ["bc","az"].
 * <p>
 * Suppose we chose a set of deletion indices D such that after deletions, the final array has every element (row) in lexicographic order.
 * <p>
 * For clarity, A[0] is in lexicographic order (ie. A[0][0] <= A[0][1] <= ... <= A[0][A[0].length - 1]), A[1] is in lexicographic order (ie. A[1][0] <= A[1][1] <= ... <= A[1][A[1].length - 1]), and so on.
 * <p>
 * Return the minimum possible value of D.length.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["babca","bbazb"]
 * Output: 3
 * Explanation: After deleting columns 0, 1, and 4, the final array is A = ["bc", "az"].
 * Both these rows are individually in lexicographic order (ie. A[0][0] <= A[0][1] and A[1][0] <= A[1][1]).
 * Note that A[0] > A[1] - the array A isn't necessarily in lexicographic order.
 * Example 2:
 * <p>
 * Input: ["edcba"]
 * Output: 4
 * Explanation: If we delete less than 4 columns, the only row won't be lexicographically sorted.
 * Example 3:
 * <p>
 * Input: ["ghi","def","abc"]
 * Output: 0
 * Explanation: All rows are already lexicographically sorted.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 */
public class Leetcode960 {

    /**
     * https://leetcode.com/problems/delete-columns-to-make-sorted-iii/discuss/205679/C%2B%2BJavaPython-Maximum-Increasing-Subsequence
     *
     * @param A
     * @return
     */
    public int minDeletionSize(String[] A) {
        //dp[i] means the longest subsequence ends with i-th element.
        //For all j < i, if A[][j] < A[][i], then dp[j] = max(dp[j], dp[i] + 1)
        int[] dp = new int[A[0].length()];
        Arrays.fill(dp, 1);
        int res = A[0].length(), k;
        //子串长度
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 0; j < i; j++) {
                //遍历所有单词
                for (k = 0; k < A.length; k++) {
                    if (A[k].charAt(i) < A[k].charAt(j))
                        break;
                }
                if (k == A.length && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            res = Math.min(res, A[0].length() - dp[i]);
        }
        return res;
    }
}
