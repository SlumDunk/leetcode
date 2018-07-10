package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.  Return a list of all possible strings we could create.
 * <p>
 * Examples:
 * Input: S = "a1b2"
 * Output: ["a1b2", "a1B2", "A1b2", "A1B2"]
 * <p>
 * Input: S = "3z4"
 * Output: ["3z4", "3Z4"]
 * <p>
 * Input: S = "12345"
 * Output: ["12345"]
 */
public class Leetcode784 {
    public static void main(String[] args) {

    }

    public List<String> letterCasePermutation(String S) {
        List<String> res = new ArrayList<String>();
        if (S == null) {
            return null;
        }
        //dfs
        char[] a = S.toLowerCase().toCharArray();
        helper(a, 0, res);
        return res;
    }

    private void helper(char[] a, int position, List<String> res) {
        if (position == a.length) {
            res.add(new String(a));
            return;
        }

        helper(a, position + 1, res);

        if (Character.isLetter(a[position])) {
            a[position] = Character.toUpperCase(a[position]);
            helper(a, position + 1, res);
            a[position] = Character.toLowerCase(a[position]);
        }
    }
}
