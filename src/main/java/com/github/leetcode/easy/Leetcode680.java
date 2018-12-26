package com.github.leetcode.easy;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 * <p>
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class Leetcode680 {

    public static void main(String[] args) {
        Leetcode680 leetcode680 = new Leetcode680();
        System.out.println(leetcode680.validPalindrome("abc"));
    }

    public boolean validPalindrome(String s) {
        return valid(s, 0, s.length() - 1, 1);
    }

    /**
     * @param s     字符串
     * @param left  左边指针
     * @param right 右边指针
     * @param d     可删除位数
     * @return
     */
    private boolean valid(String s, int left, int right, int d) {
        //字符本身就是一个长度为1的回文序列
        if (left >= right) return Boolean.TRUE;
        //字符相等
        if (s.charAt(left) == s.charAt(right)) {
            return valid(s, left + 1, right - 1, d);
        } else {
            //去头或去尾，看看是否子串是回文序列
            return d > 0 && (valid(s, left + 1, right, d - 1) || valid(s, left, right - 1, d - 1));
        }
    }
}
