package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/3/19 13:19
 * @Description: Given a text string and words (a list of strings), return all index pairs [i, j] so that the substring text[i]...text[j] is in the list of words.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "thestoryofleetcodeandme", words = ["story","fleet","leetcode"]
 * Output: [[3,7],[9,13],[10,17]]
 * Example 2:
 * <p>
 * Input: text = "ababa", words = ["aba","ab"]
 * Output: [[0,1],[0,2],[2,3],[2,4]]
 * Explanation:
 * Notice that matches can overlap, see "aba" is found in [0,2] and [2,4].
 * <p>
 * <p>
 * Note:
 * <p>
 * All strings contains only lowercase English letters.
 * It's guaranteed that all strings in words are different.
 * 1 <= text.length <= 100
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 50
 * Return the pairs [i,j] in sorted order (i.e. sort them by their first coordinate in case of ties sort them by their second coordinate).
 */
public class Leetcode1065 {
    public int[][] indexPairs(String text, String[] words) {
        List<int[]> list = new ArrayList<>();
        for (String word :
                words) {
            int index = 0;
            while (index < text.length()) {
                if (text.substring(index).startsWith(word)) {
                    list.add(new int[]{index, index + word.length() - 1});
                }
                index++;
            }
        }
        int[][] res = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        Arrays.sort(res, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]);
            }
        });
        return res;
    }
}
