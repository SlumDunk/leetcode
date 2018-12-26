package com.github.leetcode.easy;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 9/2/18 09:19
 * @Description: Given two strings A and B of lowercase letters, return true if and only if we can swap two letters in A so that the result equals B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 * <p>
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 * <p>
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 * <p>
 * Input: A = "", B = "aa"
 * Output: false
 * <p>
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 */
public class Leetcode859 {
    public static void main(String[] args) {

    }

    public boolean buddyStrings(String A, String B) {
        if (A.length() < 2 || B.length() < 2) {
            return false;
        }
        //字符串相等
        if (A.equals(B)) {
            int j = 0;
            //只由一种字符组成
            for (int i = 1; i < A.length(); i++) {
                if (A.charAt(0) == A.charAt(i)) {
                    return true;
                }
            }
        }

        // 字符串不相等
        //只能有两个位置的字符不相等
        char[] nonmatched = new char[6];
        int nm = 0;
        for (int i = 0; nm < 6 && i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                nonmatched[nm] = A.charAt(i);
                nonmatched[++nm] = B.charAt(i);
                nm++;
            }
        }
        if (nm == 4) {//两个位置不一致，且对称相等
            return (nonmatched[0] == nonmatched[3] && nonmatched[1] == nonmatched[2]);
        }
        return false;
    }
}
