package com.github.leetcode.hard;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 6/4/19 16:47
 * @Description: Strings A and B are K-similar (for some non-negative integer K) if we can swap the positions of two letters in A exactly K times so that the resulting string equals B.
 * <p>
 * Given two anagrams A and B, return the smallest K for which A and B are K-similar.
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: 1
 * Example 2:
 * <p>
 * Input: A = "abc", B = "bca"
 * Output: 2
 * Example 3:
 * <p>
 * Input: A = "abac", B = "baca"
 * Output: 2
 * Example 4:
 * <p>
 * Input: A = "aabc", B = "abca"
 * Output: 2
 * Note:
 * <p>
 * 1 <= A.length == B.length <= 20
 * A and B contain only lowercase letters from the set {'a', 'b', 'c', 'd', 'e', 'f'}
 */
public class Leetcode854 {
    public static void main(String[] args) {
        Leetcode854 leetcode854 = new Leetcode854();
        String a = "abc";
        String b = "bca";
        leetcode854.kSimilarity(a, b);
    }

    /**
     * 交换字符串i和j位置元素
     *
     * @param s
     * @param i
     * @param j
     * @return
     */
    public String swap(String s, int i, int j) {
        char[] cs = s.toCharArray();
        char tmp = cs[i];
        cs[i] = cs[j];
        cs[j] = tmp;
        return new String(cs);
    }

    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        int res = 0;
        //记忆住访问过的单词，防止dead lock
        Set<String> used = new HashSet<>();
        Deque<String> queue = new LinkedList<>();
        queue.add(A);

        //第一个不一样的位置
        int start = 0;
        while (A.charAt(start) == B.charAt(start)) start++;

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                String s = queue.removeLast();
                int j = start;
                while (s.charAt(j) == B.charAt(j)) j++;
                //往前走，寻找s中跟B的j字符相等的位置字符
                for (int k = j + 1; k < B.length(); k++) {
                    if (s.charAt(k) == B.charAt(j)) {
                        String ss = swap(s, j, k);
                        if (used.contains(ss)) continue;
                        if (ss.equals(B)) return res + 1;
                        queue.addFirst(ss);
                        used.add(ss);
                    }
                }
            }
            res++;
            start++;
        }

        return res;
    }
}
