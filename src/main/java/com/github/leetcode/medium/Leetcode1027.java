package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/24/19 20:52
 * @Description: Given an array A of integers, return the length of the longest arithmetic subsequence in A.
 * <p>
 * Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [3,6,9,12]
 * Output: 4
 * Explanation:
 * The whole array is an arithmetic sequence with steps of length = 3.
 * Example 2:
 * <p>
 * Input: [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 * Example 3:
 * <p>
 * Input: [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= A.length <= 2000
 * 0 <= A[i] <= 10000
 */
public class Leetcode1027 {
    public int longestArithSeqLength(int[] A) {
        int res = 0;
        //存储每个元素参与的等差序列的长度 key为等差，value为长度
        Map<Integer,Integer>[] dp = new HashMap[A.length];
        dp[0] = new HashMap();
        for(int i=1; i<A.length; i++){
            dp[i] = new HashMap<>();
            //[0....i]
            for(int j=0; j<i; j++){
                int diff = A[i]-A[j];
                if(dp[j].containsKey(diff)){
                    dp[i].put(diff,dp[j].get(diff)+1);
                }
                else{
                    dp[i].put(diff,2);
                }
                res = Math.max(res,dp[i].get(diff));
            }
        }
        return res;
    }
}
