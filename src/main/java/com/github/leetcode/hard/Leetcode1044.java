package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/12/19 21:03
 * @Description: Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  (The occurrences may overlap.)
 * <p>
 * Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer is "".)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "banana"
 * Output: "ana"
 * Example 2:
 * <p>
 * Input: "abcd"
 * Output: ""
 * <p>
 * <p>
 * Note:
 * <p>
 * 2 <= S.length <= 10^5
 * S consists of lowercase English letters.
 */
public class Leetcode1044 {

    public static void main(String[] args) {
        Leetcode1044 leetcode1044=new Leetcode1044();
        leetcode1044.longestDupSubstring("banana");
    }
    Long MOD;

    /**
     * 二分查找和滚动哈希
     *
     * @param S
     * @return
     */
    public String longestDupSubstring(String S) {
        int N = S.length();
        int max = 0;
        String ans = "";
        MOD = 1000000007L;
        int l = 0, r = N - 1;
        //binary search

        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean breakout = false;
            Map<Long, List<Integer>> map = new HashMap<>(); // the List<Integer> store a list of indexes which have the same hashCode
            long prev = 0;
            long pow26 = calcPower26(mid);
            for (int i = 0; i + mid - 1 < N; i++) {
                long code = calc(S, i, mid, prev, pow26); // calculate hashcode
                if (map.containsKey(code)) {
                    for (int m : map.get(code)) { // iterate thru the list and verify the match to deal with hash collision.
                        if (S.substring(i, i + mid).equals(S.substring(m, m + mid))) {
                            breakout = true;
                            if (mid > max) {
                                max = mid;
                                ans = S.substring(i, i + mid);
                            }
                            break;
                        }
                    }
                }
                if (breakout) break;
                map.putIfAbsent(code, new ArrayList<>());
                map.get(code).add(i);
                prev = code; //log prev for next hashcode calculation.
            }
            if (breakout) l = mid + 1;
            else r = mid - 1;
        }
        return ans;
    }

    /**
     * 计算hash值
     *
     * @param s
     * @param start 开始位置
     * @param len   长度
     * @param prev  前一数字
     * @param pow26 26开方
     * @return
     */
    private long calc(String s, int start, int len, long prev, long pow26) {
        long ans = 0L;
        if (start == 0) { // first time calculation
            for (int i = 0; i < len; i++) {
                ans *= 26L;
                ans += (long) (s.charAt(start + i) - 'a');
                ans %= MOD;
            }
        } else { // defer from previous result.
            ans = prev * 26L;
            ans += (long) (s.charAt(start + len - 1) - 'a');
            ans -= (s.charAt(start - 1) - 'a') * pow26;
        }
        ans %= MOD;
        if (ans < 0L) ans += MOD;
        return ans;
    }

    /**
     * @param n
     * @return
     */
    private long calcPower26(int n) {
        if (n == 0) return 1L;
        if (n == 1) return 26L;
        long half = calcPower26(n / 2);
        long ans = (half * half) % MOD;
        ans *= calcPower26(n - (n / 2) * 2);
        return ans % MOD;
    }

}
