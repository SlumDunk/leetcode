package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string s, return the maximum number of ocurrences of any substring under the following rules:
 * <p>
 * The number of unique characters in the substring must be less than or equal to maxLetters.
 * The substring size must be between minSize and maxSize inclusive.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
 * Output: 2
 * Explanation: Substring "aab" has 2 ocurrences in the original string.
 * It satisfies the conditions, 2 unique letters and size 3 (between minSize and maxSize).
 * Example 2:
 * <p>
 * Input: s = "aaaa", maxLetters = 1, minSize = 3, maxSize = 3
 * Output: 2
 * Explanation: Substring "aaa" occur 2 times in the string. It can overlap.
 * Example 3:
 * <p>
 * Input: s = "aabcabcab", maxLetters = 2, minSize = 2, maxSize = 3
 * Output: 3
 * Example 4:
 * <p>
 * Input: s = "abcde", maxLetters = 2, minSize = 3, maxSize = 3
 * Output: 0
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * 1 <= maxLetters <= 26
 * 1 <= minSize <= maxSize <= min(26, s.length)
 * s only contains lowercase English letters.
 */
public class Leetcode1297 {

    /**
     * 超时
     *
     * @param s
     * @param maxLetters
     * @param minSize
     * @param maxSize
     * @return
     */
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        // 先切长度，再找unique
        if (s == null || s.length() == 0 || s.length() < minSize) {
            return 0;
        } else {
            int max = 0;
            for (int len = minSize; len <= maxSize; len++) {
                for (int i = 0; i < s.length() - len; i++) {
                    int endIndex = i + len;
                    String subString = s.substring(i, endIndex);
                    if (satisfy(subString, maxLetters)) {
                        int temp = 0;
                        int curIndex = -1;
                        int startIndex = i;
                        while (startIndex < s.length() && s.indexOf(subString, startIndex) != -1) {
                            int index = s.indexOf(subString, startIndex);
                            if (index != curIndex) {
                                temp++;
                                curIndex = index;
                            }
                            startIndex++;
                        }

                        max = Math.max(max, temp);
                    }
                }
            }
            return max;
        }
    }

    private boolean satisfy(String subString, int maxLetters) {
        Set<Character> set = new HashSet<>();
        for (char c :
                subString.toCharArray()) {
            set.add(c);
        }
        return set.size() <= maxLetters;
    }

    public int maxFreq2(String s, int maxLetters, int minSize, int maxSize) {
        final Map<String, Integer> subStringOccurances = new HashMap<>();
        final Map<Character, Integer> uniqueChars = new HashMap<>();
        int left = 0;
        int right = 0;
        final StringBuilder current = new StringBuilder();
        while (left <= right && right < s.length()) {
            //add one char
            uniqueChars.merge(s.charAt(right), 1, Integer::sum);
            current.append(s.charAt(right));
            right++;
            //check if we can shrink current window
            while (current.length() > maxSize || current.length() > minSize || uniqueChars.size() > maxLetters) {
                if (uniqueChars.computeIfPresent(s.charAt(left), (key, oldValue) -> oldValue - 1) == 0) {
                    uniqueChars.remove(s.charAt(left));
                }
                current.deleteCharAt(0);
                left++;
            }
            //if valid window then add it to map
            if (current.length() >= minSize && current.length() <= maxSize) {
                subStringOccurances.merge(current.toString(), 1, Integer::sum);
            }
        }
        //find max value in the map
        return subStringOccurances.values().stream().mapToInt(value -> value).max().orElse(0);
    }


    public int maxFreq3(String s, int maxLetters, int minSize, int maxSize) {
        final Map<String, Integer> subStringOccurances = new HashMap<>();
        final Map<Character, Integer> uniqueChars = new HashMap<>();

        int left = 0;
        int right = 0;
        final StringBuilder current = new StringBuilder();
        while (left <= right && right < s.length()) {
            uniqueChars.merge(s.charAt(right), 1, Integer::sum);
            current.append(s.charAt(right));
            right++;
            while (current.length() > minSize || uniqueChars.size() > maxLetters) {
                if (uniqueChars.computeIfPresent(s.charAt(left), (key, oldValue) -> oldValue - 1) == 0) {
                    uniqueChars.remove(s.charAt(left));
                }
                current.deleteCharAt(0);
                left++;
            }

            if (current.length() >= minSize && current.length() <= maxSize) {
                subStringOccurances.merge(current.toString(), 1, Integer::sum);
            }
        }
        return subStringOccurances.values().stream().mapToInt(value -> value).max().orElse(0);
    }

}
