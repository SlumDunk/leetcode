package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/23/19 23:17
 * @Description: Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
 * <p>
 * Example :
 * Input:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 * Note:
 * <p>
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50].s
 */
public class Leetcode792 {
    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        //存储每个字符出现的位置
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (!map.containsKey(S.charAt(i))) map.put(S.charAt(i), new ArrayList<Integer>());
            map.get(S.charAt(i)).add(i);
        }
        //遍历单词列表
        for (int i = 0; i < words.length; i++) {
            int d;
            int k = -1;//存储上个字符出现的位置
            for (d = 0; d < words[i].length(); d++) {
                if (!map.containsKey(words[i].charAt(d))) {
                    break;
                } else {
                    ArrayList<Integer> l = map.get(words[i].charAt(d));
                    boolean has = false;
                    for (int m = 0; m < l.size(); m++) {
                        if (l.get(m) > k) {
                            k = l.get(m);
                            has = true;
                            break;
                        }
                    }
                    if (!has) break;
                }
            }
            //走到单词尾部
            if (d == words[i].length())
                res++;
        }
        return res;
    }
}
