package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.
 * <p>
 * Return the maximum possible length of s.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = ["un","iq","ue"]
 * Output: 4
 * Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
 * Maximum length is 4.
 * Example 2:
 * <p>
 * Input: arr = ["cha","r","act","ers"]
 * Output: 6
 * Explanation: Possible solutions are "chaers" and "acters".
 * Example 3:
 * <p>
 * Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
 * Output: 26
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= arr.length <= 16
 * 1 <= arr[i].length <= 26
 * arr[i] contains only lower case English letters.
 */
public class Leetcode1239 {
    List<Integer> encodeList = new ArrayList<>();
    int ans = 0;

    /**
     * O(2^N)
     *
     * @param arr
     * @return
     */
    public int maxLength(List<String> arr) {
        int len = arr.size();
        for (int i = 0; i < len; i++) {
            int mask = 0;
            String word = arr.get(i);
            for (int j = 0; j < word.length(); j++) {
                mask |= (1 << (word.charAt(j) - 'a'));
            }
            if (getOneCount(mask) == word.length()) {
                encodeList.add(mask);
            }
        }

        helper(0, 0);
        return ans;

    }

    private void helper(int index, int mask) {
        ans = Math.max(ans, getOneCount(mask));
        for (int i = index; i < encodeList.size(); i++) {
            if ((mask & encodeList.get(i)) == 0) {
                helper(i + 1, mask | encodeList.get(i));
            }
        }
    }

    private int getOneCount(int val) {
        String binaryStr = Integer.toBinaryString(val);
        int count = 0;
        for (int i = 0; i < binaryStr.length(); i++) {
            if (binaryStr.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }
}
