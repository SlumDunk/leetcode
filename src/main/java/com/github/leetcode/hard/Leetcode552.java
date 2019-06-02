package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 08:59
 * @Description: Given a positive integer n, return the number of all possible attendance records with length n, which will be regarded as rewardable. The answer may be very large, return it after mod 109 + 7.
 * <p>
 * A student attendance record is a string that only contains the following three characters:
 * <p>
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A record is regarded as rewardable if it doesn't contain more than one 'A' (absent) or more than two continuous 'L' (late).
 * <p>
 * Example 1:
 * Input: n = 2
 * Output: 8
 * Explanation:
 * There are 8 records with length 2 will be regarded as rewardable:
 * "PP" , "AP", "PA", "LP", "PL", "AL", "LA", "LL"
 * Only "AA" won't be regarded as rewardable owing to more than one absent times.
 * Note: The value of n won't exceed 100,000.
 */
public class Leetcode552 {
    static final int M = 1000000007;

    public int checkRecord(int n) {
        long[] PorL = new long[n + 1]; // ending with P or L, no A
        long[] P = new long[n + 1]; // ending with P, no A
        PorL[0] = P[0] = 1; PorL[1] = 2; P[1] = 1;

        for (int i = 2; i <= n; i++) {
            P[i] = PorL[i - 1];
            PorL[i] = (P[i] + P[i - 1] + P[i - 2]) % M;
        }

        long res = PorL[n];
        for (int i = 0; i < n; i++) { // inserting A into (n-1)-length strings
            long s = (PorL[i] * PorL[n - i - 1]) % M;
            res = (res + s) % M;
        }

        return (int) res;
    }

    int [][][] dp;
    int MOD = 1000000007;

    public int checkRecordDFS(int n) {
        dp = new int[n + 1][3][2];
        for(int [][] arr : dp)
            for(int [] bar : arr)
                Arrays.fill(bar, -1);

        return helper(n, 0, 0) % MOD;
    }

    public int helper(int n, int L, int A){
        if(n == 0) return 1;

        if(dp[n][L][A] != -1)
            return dp[n][L][A] % MOD;

        int sol = 0;
        sol += helper(n - 1, 0, A) % MOD; //P
        sol %= MOD;

        if(L <= 1)
            sol += helper(n - 1, L + 1, A) % MOD; //L Sequence

        sol %= MOD;
        if(A == 0)
            sol += helper(n - 1, 0, 1) % MOD; //A

        sol %= MOD;
        dp[n][L][A] = sol;
        return sol;
    }
}
