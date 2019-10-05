package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 9/14/19 14:10
 * @Description: Given a string text, we are allowed to swap two of the characters in the string. Find the length of the longest substring with repeated characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "ababa"
 * Output: 3
 * Explanation: We can swap the first 'b' with the last 'a', or the last 'b' with the first 'a'. Then, the longest repeated character substring is "aaa", which its length is 3.
 * Example 2:
 * <p>
 * Input: text = "aaabaaa"
 * Output: 6
 * Explanation: Swap 'b' with the last 'a' (or the first 'a'), and we get longest repeated character substring "aaaaaa", which its length is 6.
 * Example 3:
 * <p>
 * Input: text = "aaabbaaa"
 * Output: 4
 * Example 4:
 * <p>
 * Input: text = "aaaaa"
 * Output: 5
 * Explanation: No need to swap, longest repeated character substring is "aaaaa", length is 5.
 * Example 5:
 * <p>
 * Input: text = "abcdef"
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= text.length <= 20000
 * text consist of lowercase English characters only.
 */
public class Leetcode1156 {

    /**
     * 只能交换一次
     *
     * @param text
     * @return
     */
    public int maxRepOpt1(String text) {
        List<Integer>[] indices = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            indices[i] = new ArrayList<>();
        }

        for (int i = 0; i < text.length(); i++) {
            indices[text.charAt(i) - 'a'].add(i);
        }

        int ans = 1;

        for (int i = 0; i < 26; i++) {
            List<Integer> indexList = indices[i];
            int max = 1;
            int prev = 0;
            int curr = 1;
            for (int j = 1; j < indexList.size(); j++) {
                if (indexList.get(j) == indexList.get(j - 1) + 1) {
                    curr++;
                } else {
                    prev = indexList.get(j) == indexList.get(j - 1) + 2 ? curr : 0;
                    curr = 1;
                }
                max = Math.max(max, prev + curr);
            }

            ans = Math.max(ans, max + (indexList.size() > max ? 1 : 0));
        }
        return ans;
    }
}
