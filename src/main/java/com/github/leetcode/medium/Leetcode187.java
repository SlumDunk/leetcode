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
        //将每个子串放进set集合里，利用set中元素唯一性的特性
        HashSet<String> set = new HashSet<>();
        List<String> result = new ArrayList<String>();

        for (int i = 0; i + 9 < s.length(); i++) {
            String temp = s.substring(i, i + 10);
            if (!set.add(temp)) {//集合中已经存在过了
                if (!result.contains(temp)) {
                    result.add(temp);
                }
            }
        }

        return result;
    }
}
