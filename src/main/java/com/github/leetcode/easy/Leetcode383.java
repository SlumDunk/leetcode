package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class Leetcode383 {
    public static void main(String[] args) {
        Leetcode383 leetcode383 = new Leetcode383();
        System.out.println(leetcode383.canConstruct("aa", "ab"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        //先统计magazine的各个字符数量
        int[] charCount = new int[26];
        for (char value : magazine.toCharArray()) {
            charCount[value - 'a'] = charCount[value - 'a'] + 1;
        }
        //遍历ransomNote的字符
        for (char value : ransomNote.toCharArray()) {
            if (charCount[value - 'a'] == 0) {
                return false;
            } else {
                charCount[value - 'a'] = charCount[value - 'a'] - 1;
            }
        }
        return true;
    }
}
