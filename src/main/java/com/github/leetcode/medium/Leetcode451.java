package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: zerongliu
 * @Date: 5/8/19 15:45
 * @Description: Given a string, sort it in decreasing order based on the frequency of characters.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * "tree"
 * <p>
 * Output:
 * "eert"
 * <p>
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 * <p>
 * Input:
 * "cccaaa"
 * <p>
 * Output:
 * "cccaaa"
 * <p>
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 * <p>
 * Input:
 * "Aabb"
 * <p>
 * Output:
 * "bbAa"
 * <p>
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */
public class Leetcode451 {
    public String frequencySort(String s) {
        int[] charCount = new int[256];
        char[] chars = s.toCharArray();
        for (char c :
                chars) {
            charCount[c]++;
        }

        Integer[] order = new Integer[256];
        for (int i = 0; i < 256; i++) {
            order[i] = i;
        }
        Arrays.sort(order, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (charCount[o1] != charCount[o2]) {
                    return charCount[o2] - charCount[o1];
                }
                return o1 - o2;

            }
        });

        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < 256; i++) {
            int c = order[i];
            for (int j = 0; j < charCount[c]; j++) {
                buffer.append((char) (c));
            }
        }
        return buffer.toString();
    }
}
