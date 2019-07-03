package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 08:00
 * @Description: On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.
 * <p>
 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).
 * <p>
 * Examples:
 * Input: N = 1, K = 1
 * Output: 0
 * <p>
 * Input: N = 2, K = 1
 * Output: 0
 * <p>
 * Input: N = 2, K = 2
 * Output: 1
 * <p>
 * Input: N = 4, K = 5
 * Output: 1
 * <p>
 * Explanation:
 * row 1: 0
 * row 2: 01
 * row 3: 0110
 * row 4: 01101001
 * Note:
 * <p>
 * N will be an integer in the range [1, 30].
 * K will be an integer in the range [1, 2^(N-1)].
 */
public class Leetcode779 {
    /**
     * @param N
     * @param K
     * @return
     */
    public int kthGrammar(int N, int K) {
        if (N == 1) return 0;
        //找上一层父节点
        if (kthGrammar(N - 1, (K + 1) / 2) == 0) {//父节点是0
            //K是偶数，1，奇数 0
            return K % 2 == 0 ? 1 : 0;
        } else {//父节点是1
            //K是偶数 0， 奇数 1
            return K % 2 == 0 ? 0 : 1;
        }
    }
}
