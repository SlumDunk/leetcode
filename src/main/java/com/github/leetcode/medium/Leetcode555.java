package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 21:45
 * @Description: Given a list of strings, you could concatenate these strings together into a loop, where for each string you could choose to reverse it or not. Among all the possible loops, you need to find the lexicographically biggest string after cutting the loop, which will make the looped string into a regular one.
 * <p>
 * Specifically, to find the lexicographically biggest string, you need to experience two phases:
 * <p>
 * Concatenate all the strings into a loop, where you can reverse some strings or not and connect them in the same order as given.
 * Cut and make one breakpoint in any place of the loop, which will make the looped string into a regular one starting from the character at the cutpoint.
 * And your job is to find the lexicographically biggest one among all the possible regular strings.
 * <p>
 * Example:
 * Input: "abc", "xyz"
 * Output: "zyxcba"
 * Explanation: You can get the looped string "-abcxyz-", "-abczyx-", "-cbaxyz-", "-cbazyx-",
 * where '-' represents the looped status.
 * The answer string came from the fourth looped one,
 * where you could cut from the middle character 'a' and get "zyxcba".
 * Note:
 * The input strings will only contain lowercase letters.
 * The total length of all the strings will not over 1,000.
 */
public class Leetcode555 {
    public String splitLoopedString(String[] strs) {
        int n = strs.length;
        //翻转和不翻转比较，保持大的
        for (int i = 0; i < n; i++) {
            String rev = new StringBuilder(strs[i]).reverse().toString();
            if (strs[i].compareTo(rev) < 0) strs[i] = rev;
        }
        if (n == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        //拼接起前n-1个字符串
        for (int i = 0; i < n - 1; i++) sb.append(strs[i]);
        //默认最大的结果就是按顺序拼接
        String mid = sb.toString(), result ="";
        for (int i = 0; i < n; i++) {
            String str = strs[i], rev = new StringBuilder(str).reverse().toString();
            //预留位置给新的字符串
            mid = mid.substring(str.length()) + strs[(i + n - 1) % n];
            //看从当前单词哪个位置进行处理比较好
            for (int j = 0; j <= str.length(); j++) {
                String s1 = str.substring(j) + mid + str.substring(0, j), s2 = rev.substring(j) + mid + rev.substring(0, j);
                if (s1.compareTo(s2) >= 0 && s1.compareTo(result) > 0) result = s1;
                else if (s2.compareTo(s1) >= 0 && s2.compareTo(result) > 0) result = s2;
            }
        }
        return result;
    }
}
