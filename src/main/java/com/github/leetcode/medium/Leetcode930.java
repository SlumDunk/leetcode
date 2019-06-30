package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 23:10
 * @Description: In an array A of 0s and 1s, how many non-empty subarrays have sum S?
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,0,1,0,1], S = 2
 * Output: 4
 * Explanation:
 * The 4 subarrays are bolded below:
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * [1,0,1,0,1]
 * <p>
 * <p>
 * Note:
 * <p>
 * A.length <= 30000
 * 0 <= S <= A.length
 * A[i] is either 0 or 1.
 */
public class Leetcode930 {
    public int numSubarraysWithSum(int[] A, int S) {
        int[] dp = new int[A.length + 1];
        //前缀和 后面的和大于等于前面的和
        for (int i = 0; i < A.length; i++) dp[i + 1] = dp[i] + A[i];
        //key为目标和，value为次数
        Map<Integer, Integer> count = new HashMap<>();
        int ans = 0;
        for (int c : dp) {
            //有前缀和出现在目标Map中，证明可以构成和为S的子序列
            ans += count.getOrDefault(c, 0);
            //预料目标出现的次数+1
            count.put(c + S, count.getOrDefault(c + S, 0) + 1);
        }
        return ans;
    }
}
