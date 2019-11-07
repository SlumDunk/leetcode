package com.github.interview.amazon;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 12:36
 * @Description:
 */
public class SubstringsOfSizeKWithKDistinctChars {
    public static Set<String> uniqueSubstringSizeK(String s, int k) {
        Set<String> set = new HashSet<>();
        int[] ch = new int[26];
        int lo = 0;
        int hi = 0;
        while (lo <= hi && hi < s.length()) {
            ch[s.charAt(hi) - 'a']++;
            while (ch[s.charAt(hi) - 'a'] != 1) {
                ch[s.charAt(lo) - 'a']--;
                lo++;
            }
            if (hi - lo + 1 == k) {
                set.add(s.substring(lo, hi + 1));
                ch[s.charAt(lo) - 'a']--;
                lo++;
            }
            hi++;
        }
        System.out.println(set.size());
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return set;
    }

    public static void main(String[] args) {
        uniqueSubstringSizeK("abcabc", 3);
        uniqueSubstringSizeK("abacab", 3);
        uniqueSubstringSizeK("awaglknagawunagwkwagl", 4);
    }
}
