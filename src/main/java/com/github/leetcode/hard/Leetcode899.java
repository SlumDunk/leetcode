package com.github.leetcode.hard;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 6/20/19 14:13
 * @Description: A string S of lowercase letters is given.  Then, we may make any number of moves.
 * <p>
 * In each move, we choose one of the first K letters (starting from the left), remove it, and place it at the end of the string.
 * <p>
 * Return the lexicographically smallest string we could have after any number of moves.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: S = "cba", K = 1
 * Output: "acb"
 * Explanation:
 * In the first move, we move the 1st character ("c") to the end, obtaining the string "bac".
 * In the second move, we move the 1st character ("b") to the end, obtaining the final result "acb".
 * Example 2:
 * <p>
 * Input: S = "baaca", K = 3
 * Output: "aaabc"
 * Explanation:
 * In the first move, we move the 1st character ("b") to the end, obtaining the string "aacab".
 * In the second move, we move the 3rd character ("c") to the end, obtaining the final result "aaabc".
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= K <= S.length <= 1000
 * S consists of lowercase letters only.
 */
public class Leetcode899 {
    public String orderlyQueue(String S, int K) {
        if(K>1) {
            char[] temp=S.toCharArray();
            Arrays.sort(temp);
            return new String(temp);
        }
        String res=S;
        for(int i=1;i<S.length();i++) {
            String temp=S.substring(i)+S.substring(0, i);
            if(temp.compareTo(res)<0) res=temp;
        }
        return res;
    }
}
