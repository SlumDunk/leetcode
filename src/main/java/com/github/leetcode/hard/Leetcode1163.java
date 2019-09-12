package com.github.leetcode.hard;

import java.util.HashSet;

/**
 * @Author: zerongliu
 * @Date: 9/12/19 15:00
 * @Description: Given a string s, return the last substring of s in lexicographical order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abab"
 * Output: "bab"
 * Explanation: The substrings are ["a", "ab", "aba", "abab", "b", "ba", "bab"]. The lexicographically maximum substring is "bab".
 * Example 2:
 * <p>
 * Input: "leetcode"
 * Output: "tcode"
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= s.length <= 4 * 10^5
 * s contains only lowercase English letters.
 */
public class Leetcode1163 {
    public static void main(String[] args) {
        Leetcode1163 leetcode1163=new Leetcode1163();
        leetcode1163.lastSubstring("abab");
    }

    /**
     * 子串按字典顺序排列，返回最后一个子串
     * @param s
     * @return
     */
    public String lastSubstring(String s) {
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) > s.charAt(start)) start = i;
        }
        //最大字符的位置set
        HashSet<Integer> candidates = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            // avoid "aaaaaaa" case
            if (s.charAt(i) == s.charAt(start) && (i == 0 || s.charAt(i - 1) != s.charAt(start))) {
                candidates.add(i);
            }
        }
        int len = 1;
        //候选集合非空
        while (candidates.size() > 1) {
            //这一轮结束需要移除的候选人
            HashSet<Integer> needRemove = new HashSet<>();
            //此轮比较的最大字符
            char maxC = 'a';
            //遍历获取最大的字符
            for (int candidate : candidates) {
                //下个字符位置
                int end = candidate + len;
                //越界了
                if (end >= s.length()) {
                    needRemove.add(candidate);
                    continue;
                }
                char c = s.charAt(end);
                if (c > maxC) maxC = c;
            }
            //移除不合格的候选人
            for (int candidate : candidates) {
                int end = candidate + len;
                if (end >= s.length()) continue;
                char c = s.charAt(end);
                if (c != maxC) needRemove.add(candidate);
            }
            if (needRemove.size() >= candidates.size()) break;
            //移除不合格任选
            for (int idx : needRemove) candidates.remove(idx);
            len += 1;
        }
        String res = "";
        for (int candidate : candidates) {
            String str = s.substring(candidate, s.length());
            if (str.compareTo(res) > 0) res = str;
        }
        return res;
    }
}
