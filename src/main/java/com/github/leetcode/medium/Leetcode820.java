package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 18:49
 * @Description: Given a list of words, we may encode it by writing a reference string S and a list of indexes A.
 * <p>
 * For example, if the list of words is ["time", "me", "bell"], we can write it as S = "time#bell#" and indexes = [0, 2, 5].
 * <p>
 * Then for each index, we will recover the word by reading from the reference string from that index until we reach a "#" character.
 * <p>
 * What is the length of the shortest reference string S possible that encodes the given words?
 * <p>
 * Example:
 * <p>
 * Input: words = ["time", "me", "bell"]
 * Output: 10
 * Explanation: S = "time#bell#" and indexes = [0, 2, 5].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= words.length <= 2000.
 * 1 <= words[i].length <= 7.
 * Each word has only lowercase letters.
 */
public class Leetcode820 {

    class Trie {
        Trie[] children;
        Boolean end;
        int depth;

        Trie() {
            children = new Trie[26];
            end = false;
            depth = 0;
        }

        public int calcLength(String word) {
            Trie curNode = this;
            char c;
            //要把'#'加进去
            int idx, len = word.length(), ret = len + 1;
            //从后往前扫
            for (int i = len - 1; i >= 0; i--) {
                c = word.charAt(i);
                idx = c - 'a';
                if (curNode.children[idx] == null) {
                    curNode.children[idx] = new Trie();
                } else if (curNode.children[idx].end) {//表明能和别的单词共用一部分尾部
                    ret = ret - curNode.children[idx].depth - 1;

                }
                curNode = curNode.children[idx];
            }

            curNode.end = true;
            //从根节点走下来的深度
            curNode.depth = len;

            // If current node has no children, return the result.
            // Otherwise return 0 because it means this word is a suffix of another word.
            return isEmpty(curNode) ? ret : 0;
        }

        private boolean isEmpty(Trie trieNode) {
            for (Trie node :
                    trieNode.children) {
                if (node != null) {
                    return false;
                }
            }
            return true;
        }
    }

    public int minimumLengthEncoding(String[] words) {
        Trie root = new Trie();
        Set<String> set = new HashSet();
        int res = 0;
        for (String s : new HashSet<String>(Arrays.asList(words))) {
            res += root.calcLength(s);
        }
        return res;
    }
}
