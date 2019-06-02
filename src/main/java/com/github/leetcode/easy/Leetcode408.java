package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 6/1/19 21:09
 * @Description: Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.
 * <p>
 * A string such as "word" contains only the following valid abbreviations:
 * <p>
 * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
 * Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".
 * <p>
 * Note:
 * Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.
 * <p>
 * Example 1:
 * Given s = "internationalization", abbr = "i12iz4n":
 * <p>
 * Return true.
 * Example 2:
 * Given s = "apple", abbr = "a2e":
 * <p>
 * Return false.
 */
public class Leetcode408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || word == "") {
            return false;
        }

        if (abbr == null || abbr == "") {
            return false;
        }

        char[] w = word.toCharArray();
        char[] ab = abbr.toCharArray();

        int i = 0, j = 0;

        while (i < w.length && j < ab.length) {
            char w1 = w[i];
            char a1 = ab[j];
            if (Character.isDigit(a1) && a1 - '0' > 0) {
                StringBuilder sb = new StringBuilder();
                int p = j;
                for (; p < ab.length; p++) {
                    if (Character.isDigit(ab[p])) {
                        sb.append(ab[p]);
                    } else {
                        break;
                    }
                }
                int len = Integer.parseInt(sb.toString());
                i += len;
                j = p;
            } else {
                if (w1 == a1) {
                    i++;
                    j++;
                } else {
                    return false;
                }
            }
        }
        if (i != w.length || j != ab.length) {
            return false;
        } else {
            return true;
        }
    }
}
