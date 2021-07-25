package com.github.leetcode.medium;

import java.util.HashMap;

/**
 * Given the string s, return the size of the longest substring containing each vowel an even number of times. That is, 'a', 'e', 'i', 'o', and 'u' must appear an even number of times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "eleetminicoworoep"
 * Output: 13
 * Explanation: The longest substring is "leetminicowor" which contains two each of the vowels: e, i and o and zero of the vowels: a and u.
 * Example 2:
 * <p>
 * Input: s = "leetcodeisgreat"
 * Output: 5
 * Explanation: The longest substring is "leetc" which contains two e's.
 * Example 3:
 * <p>
 * Input: s = "bcbcbc"
 * Output: 6
 * Explanation: In this case, the given string "bcbcbc" is the longest because all vowels: a, e, i, o and u appear zero times.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 5 x 10^5
 * s contains only lowercase English letters.
 */
public class Leetcode1371 {

    HashMap<Character, Integer> vowelMask = new HashMap<Character, Integer>() {
        {
            put('a', 1);
            put('e', 2);
            put('i', 4);
            put('o', 8);
            put('u', 16);
        }
    };

    /**
     * aaaeeeuuu
     *
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> hmap = new HashMap<Integer, Integer>();
        hmap.put(0, -1);
        int maxLength = 0;
        int x = 0;
        for (int i = 0; i < s.length(); i++) {
            if (vowelMask.containsKey(s.charAt(i))) {
                x = x ^ vowelMask.get(s.charAt(i));
            }
            if (hmap.containsKey(x)) {
                maxLength = Math.max(maxLength, i - hmap.get(x));
            } else {
                hmap.put(x, i);
            }

        }
        return maxLength;
    }

    public static void main(String[] args) {
        Leetcode1371 leetcode1371=new Leetcode1371();
        leetcode1371.findTheLongestSubstring("aaaeeeuuu");
    }
}
