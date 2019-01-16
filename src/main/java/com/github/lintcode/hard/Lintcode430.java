package com.github.lintcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 1/16/19 08:47
 * @Description:
 */
public class Lintcode430 {
    public static void main(String[] args) {
        Lintcode430 lintcode430 = new Lintcode430();
        //lintcode430.isScrambleDP("great", "rgeat");
        lintcode430.isScramble("great", "rgeat");
    }

    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    public boolean isScrambleDP(String s1, String s2) {
        // write your code here
        int m = s1.length();
        int n = s2.length();
        if (m != n) {
            return false;
        }

        boolean[][][] dp = new boolean[n][n][n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][1] = (s1.charAt(i) == s2.charAt(j));
            }
        }
        int i, j, w, len;
        for (len = 2; len <= n; len++) {
            for (i = 0; i <= n - len; i++) {
                for (j = 0; j <= n - len; j++) {
                    //s1[i....i+len-1], s2[j...j+len-1]
                    dp[i][j][len] = false;
                    //切分成两段
                    //i...i+w-1, i+w....i+len-1
                    for (w = 1; w < len; w++) {
                        //no swap
                        //S1->T1, S2->T2
                        if (dp[i][j][w] && dp[i + w][j + w][len - w]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        //swap
                        //S1->T2, S2->T1
                        if (dp[i][j + len - w][w] && dp[i + w][j][len - w]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }

                }
            }
        }
        for (int k = 0; k <= n; k++) {
            for (i = 0; i < n; i++) {
                for (j = 0; j < n; j++) {

                    System.out.printf("" + dp[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        return dp[0][0][n];
    }

    /**
     * @param s1: A string
     * @param s2: Another string
     * @return: whether s2 is a scrambled string of s1
     */
    Map<String, Boolean> map = new HashMap<String, Boolean>();

    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        if (map.containsKey(s1 + "#" + s2)) {
            return map.get(s1 + "#" + s2);
        }
        int n = s1.length();
        if (n == 1) {
            return s1.charAt(0) == s2.charAt(0);
        }
        for (int k = 1; k < n; k++) {
            if (isScramble(s1.substring(0, k), s2.substring(0, k)) && isScramble(s1.substring(k, n), s2.substring(k, n)) || isScramble(s1.substring(0, k), s2.substring(n - k, n)) && isScramble(s1.substring(k, n), s2.substring(0, n - k))) {
                map.put(s1 + "#" + s2, true);
                return true;
            }
        }
        map.put(s1 + "#" + s2, false);
        return false;
    }
}
