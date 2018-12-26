package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 12/24/18 20:47
 * @Description: Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 */
public class Leetcode125 {
    public boolean isPalindrome(String s) {
        //忽略特殊字符，两个指针，一个从头开始走，一个从尾走
        if (s == null) {
            return false;
        } else if (s.length() == 0) {
            return true;
        } else {
            s = s.toLowerCase();
            int left = 0, right = s.length() - 1;
            while (left < right) {
                char leftChar = s.charAt(left);
                char rightChar = s.charAt(right);
                if (isValid(leftChar) && isValid(rightChar)) {
                    if (leftChar == rightChar) {
                        left++;
                        right--;
                    } else {
                        return false;
                    }
                } else if (!isValid(leftChar)) {
                    left++;
                } else {
                    right--;
                }
            }
            return true;
        }
    }

    /**
     * 判断是否是有效字符
     *
     * @param c
     * @return
     */
    public boolean isValid(char c) {
        if (c >= 'a' && c <= 'z') return true;
        if (c >= '0' && c <= '9') return true;
        return false;
    }
}
