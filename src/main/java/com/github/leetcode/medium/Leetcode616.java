package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 5/27/19 20:46
 * @Description: Given a string s and a list of strings dict, you need to add a closed pair of bold tag <b> and </b> to wrap the substrings in s that exist in dict. If two such substrings overlap, you need to wrap them together by only one pair of closed bold tag. Also, if two substrings wrapped by bold tags are consecutive, you need to combine them.
 * Example 1:
 * Input:
 * s = "abcxyz123"
 * dict = ["abc","123"]
 * Output:
 * "<b>abc</b>xyz<b>123</b>"
 * Example 2:
 * Input:
 * s = "aaabbcc"
 * dict = ["aaa","aab","bc"]
 * Output:
 * "<b>aaabbc</b>c"
 * Note:
 * The given dict won't contain duplicates, and its length won't exceed 100.
 * All the strings in input have length in range [1, 1000].
 */
public class Leetcode616 {
    public String addBoldTag(String s, String[] dict) {
        if (dict.length == 0 || s.isEmpty()) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        List<int[]> intervals = new ArrayList<>();
        for (String word :
                dict) {
            int index = -1;
            index = s.indexOf(word, index);
            while (index != -1) {
                intervals.add(new int[]{index, index + (word.length() - 1)});
                index += 1;
                index = s.indexOf(word, index);
            }
        }
        if (intervals.isEmpty()) {
            return s;
        }
        Collections.sort(intervals, Comparator.comparing(o -> o[0]));

        int[] temp = intervals.get(0);
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(temp);
        for (int i = 1; i < intervals.size(); i++) {
            int[] last = mergedIntervals.get(mergedIntervals.size() - 1);
            int[] current = intervals.get(i);
            if (current[0] - last[1] <= 1) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                mergedIntervals.add(current);
            }
        }

        int m = 0;
        int[] last = mergedIntervals.get(m);
        int start = last[0];
        int end = last[1];

        for (int i = 0; i < s.length(); i++) {
            if (i == start) {
                sb.append("<b>");
            }
            if (i <= end) {
                sb.append(s.charAt(i));
            }
            if (i == end) {
                sb.append("</b>");
                m++;
                if (m < mergedIntervals.size()) {
                    last = mergedIntervals.get(m);
                    start = last[0];
                    end = last[1];
                }
            }
        }
        if (end < s.length() - 1) {
            sb.append(s.substring(end + 1));
        }
        return sb.toString();

    }
}
