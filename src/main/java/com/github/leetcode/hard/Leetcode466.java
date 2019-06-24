package com.github.leetcode.hard;

import java.util.HashSet;

/**
 * @Author: zerongliu
 * @Date: 6/6/19 09:42
 * @Description: Define S = [s,n] as the string S which consists of n connected strings s. For example, ["abc", 3] ="abcabcabc".
 * <p>
 * On the other hand, we define that string s1 can be obtained from string s2 if we can remove some characters from s2 such that it becomes s1. For example, “abc” can be obtained from “abdbec” based on our definition, but it can not be obtained from “acbbe”.
 * <p>
 * You are given two non-empty strings s1 and s2 (each at most 100 characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the maximum integer M such that [S2,M] can be obtained from S1.
 * <p>
 * Example:
 * <p>
 * Input:
 * s1="acb", n1=4
 * s2="ab", n2=2
 * <p>
 * Return:
 * 2
 */
public class Leetcode466 {
    public static void main(String[] args) {
        Leetcode466 leetcode466 = new Leetcode466();
        leetcode466.getMaxRepetitions("acb", 4, "ab", 2);
    }

    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        //acb acb acb acb
        //ab ab
        HashSet<Character> h1 = new HashSet<>();
        HashSet<Character> h2 = new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            h1.add(s1.charAt(i));
        }

        for (int i = 0; i < s2.length(); i++) {
            h2.add(s2.charAt(i));
        }

        //从s1的第i个字符开始，要多长的子串才能包住一个s2
        int[] lens = new int[s1.length()];

        for (Character ch :
                h2) {
            if (!h1.contains(ch)) {
                return 0;
            }
        }

        if (h1.size() == 1 && h2.size() == 1) {
            return (n1 * s1.length()) / (n2 * s2.length());
        }

        for (int i = 0; i < s1.length(); i++) {
            int j = 0;
            int c = 0;
            while (j < s2.length()) {
                if (s2.charAt(j) == s1.charAt((i + c) % s1.length())) {
                    j++;
                }
                c++;
            }
            lens[i] = c - 1;
        }

        int rep = 0;
        int total_length = s1.length() * n1;

        int temp = 0;
        int k = 0;
        int cur = 0;
        while (true) {
            k += lens[cur] + 1;
            if (k > total_length) break;
            temp++;
            if (temp == n2) {
                rep++;
                temp = 0;
            }
            cur = (cur + lens[cur] + 1) % s1.length();
        }
        return rep;
    }
}
