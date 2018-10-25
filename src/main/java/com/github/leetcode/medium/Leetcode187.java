package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 10/25/18 11:22
 * @Description: All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * Example:
 * <p>
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <p>
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class Leetcode187 {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> set = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String temp = s.substring(i, i + 10);
            if (!set.add(temp)) {
                repeated.add(temp);
            }
        }
        List<String> result = new ArrayList(repeated);
        return result;
    }
}
