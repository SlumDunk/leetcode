package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/9/19 22:09
 * @Description: A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 * <p>
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */
public class Leetcode763 {
    public List<Integer> partitionLabels(String S) {
        int[] lastPositionMap = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            lastPositionMap[chars[i] - 'a'] = i;
        }
        List<Integer> result = new ArrayList<>();
        int maxIndex = 0;
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            int lastPosition = lastPositionMap[chars[i] - 'a'];
            if (maxIndex < lastPosition) maxIndex = lastPosition;
            if (i <= maxIndex) count++;
            if (i == maxIndex) {
                result.add(count);
                count = 0;
            }
        }
        return result;
    }
}
