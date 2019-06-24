package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/22/19 20:58
 * @Description: Given an array A (index starts at 1) consisting of N integers: A1, A2, ..., AN and an integer B. The integer B denotes that from any place (suppose the index is i) in the array A, you can jump to any one of the place in the array A indexed i+1, i+2, …, i+B if this place can be jumped to. Also, if you step on the index i, you have to pay Ai coins. If Ai is -1, it means you can’t jump to the place indexed i in the array.
 * <p>
 * Now, you start from the place indexed 1 in the array A, and your aim is to reach the place indexed N using the minimum coins. You need to return the path of indexes (starting from 1 to N) in the array you should take to get to the place indexed N using minimum coins.
 * <p>
 * If there are multiple paths with the same cost, return the lexicographically smallest such path.
 * <p>
 * If it's not possible to reach the place indexed N then you need to return an empty array.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,4,-1,2], 2
 * Output: [1,3,5]
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: [1,2,4,-1,2], 1
 * Output: []
 * <p>
 * <p>
 * Note:
 * <p>
 * Path Pa1, Pa2, ..., Pan is lexicographically smaller than Pb1, Pb2, ..., Pbm, if and only if at the first i where Pai and Pbi differ, Pai < Pbi; when no such i exists, then n < m.
 * A1 >= 0. A2, ..., AN (if exist) will in the range of [-1, 100].
 * Length of A is in the range of [1, 1000].
 * B is in the range of [1, 100].
 */
public class Leetcode656 {

    /**
     * Analysis :
     * <p>
     * State :
     * ( i ) - index of current step, d( i ) - the minimum cost if we start at ( i ) to reach ( N )
     * If we define state in this way, the answer will be d( 1 )
     * Transfer :
     * when we step on ( i ), we have B choices, i.e., we can decide to step on any one of them as below :
     * i + 1, d(i) = A[i] + d(i + 1)
     * i + 2, d(i) = A[i] + d(i + 2)
     * i + 3, d(i) = A[i] + d(i + 3)
     * ...
     * i + B, d(i) = A[i] + d(i + B)
     * We choose the minimum one among them. That is,
     * <p>
     * d(i) = A[i] + min(d(i + 1), d(i + 2), ..., d(i + B));
     * To avoid duplicate calculations on subproblems, we use memorization technique, i.e., memo[].
     * To trace back and print out the solution pattern in the end, we use next[].
     *
     * @param A
     * @param B
     * @return
     */
    public List<Integer> cheapestJump(int[] A, int B) {
        int[] memo = new int[A.length];
        Arrays.fill(memo, -1);
        int[] next = new int[A.length];
        Arrays.fill(next, -1);
        dfs(A, B, 0, next, memo);
        List<Integer> path = new ArrayList<>();
        path.add(1);
        for (int i = 0; i < A.length && next[i] >= 0; i = next[i]) {
            //path的索引从1开始算
            int nxt = next[i] + 1;
            path.add(nxt);
        }
        //能走到结尾
        if (path.contains(A.length)) {
            return path;
        }
        return new ArrayList<>();
    }

    /**
     * @param A
     * @param B
     * @param start 开始位置
     * @param next  存放访问点的位置索引
     * @param memo
     * @return
     */
    private int dfs(int[] A, int B, int start, int[] next, int[] memo) {
        if (memo[start] != -1) {
            return memo[start];
        }
        if (start == A.length - 1) {
            return 0;
        }
        int minCost = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 1; i <= B; i++) {
            if (start + i < A.length && A[start + i] != -1) {
                int tmpAns = dfs(A, B, start + i, next, memo);
                if (tmpAns < minCost) {
                    minCost = tmpAns;
                    minIdx = start + i;
                }
            }
        }
        //下一步走哪里cost最小
        next[start] = minIdx;
        memo[start] = A[start] + minCost;
        return memo[start];
    }
}
