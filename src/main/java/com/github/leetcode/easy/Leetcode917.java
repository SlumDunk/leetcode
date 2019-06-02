package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 18:16
 * @Description: Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 * <p>
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 * <p>
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 * <p>
 * <p>
 * Note:
 * <p>
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
public class Leetcode917 {
    public String reverseOnlyLetters(String S) {
        char[] strs = S.toCharArray();
        int left = 0;
        int right = strs.length - 1;
        while (left < right) {
            if (!Character.isLetter(strs[left])) {
                left++;
                continue;
            }
            if (!Character.isLetter(strs[right])) {
                right--;
                continue;
            }
            char tmp = strs[left];
            strs[left++] = strs[right];
            strs[right--] = tmp;
        }

        return new String(strs);
    }
}
