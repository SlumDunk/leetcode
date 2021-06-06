package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/8/20 13:37
 * @Description: Given alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).
 * <p>
 * You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.
 * <p>
 * Return the reformatted string or return an empty string if it is impossible to reformat the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by digits.
 * Example 3:
 * <p>
 * Input: s = "1229857369"
 * Output: ""
 * Explanation: "1229857369" has only digits so we cannot separate them by characters.
 * Example 4:
 * <p>
 * Input: s = "covid2019"
 * Output: "c2o0v1i9d"
 * Example 5:
 * <p>
 * Input: s = "ab123"
 * Output: "1a2b3"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters and/or digits.
 */
public class Leetcode1417 {
    public static void main(String[] args) {
        Leetcode1417 leetcode1417 = new Leetcode1417();
        leetcode1417.reformat("covid2019");
    }

    public String reformat(String s) {
        List<Character> alphaList = new ArrayList<>();
        List<Character> numList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                numList.add(s.charAt(i));
            } else {
                alphaList.add(s.charAt(i));
            }
        }
        if (alphaList.size() != numList.size() && Math.abs(alphaList.size() - numList.size()) != 1) {
            return "";
        } else {
            char[] array = new char[alphaList.size() + numList.size()];
            if (alphaList.size() >= numList.size()) {
                int idx = 0;
                while (alphaList.size() > 0) {
                    array[idx] = alphaList.remove(0);
                    if (numList.size() > 0) {
                        array[idx + 1] = numList.remove(0);
                    }
                    idx += 2;
                }
            } else {
                int idx = 0;
                while (numList.size() > 0) {
                    array[idx] = numList.remove(0);
                    if (alphaList.size() > 0) {
                        array[idx + 1] = alphaList.remove(0);
                    }
                    idx += 2;
                }
            }
            return new String(array);
        }

    }
}
