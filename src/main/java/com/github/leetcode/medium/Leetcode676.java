package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/29/19 17:41
 * @Description: Implement a magic directory with buildDict, and search methods.
 * <p>
 * For the method buildDict, you'll be given a list of non-repetitive words to build a dictionary.
 * <p>
 * For the method search, you'll be given a word, and judge whether if you modify exactly one character into another character in this word, the modified word is in the dictionary you just built.
 * <p>
 * Example 1:
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * Note:
 * You may assume that all the inputs are consist of lowercase letters a-z.
 * For contest purpose, the test data is rather small by val. You could think about highly efficient algorithm after the contest.
 * Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are persisted across multiple test cases. Please see here for more details.
 */
public class Leetcode676 {
    class MagicDictionary {

        private Trie root;

        public MagicDictionary() {
            root = new Trie();
        }

        public void buildDict(String[] dict) {
            for (String word : dict) {
                Trie curr = root;
                for (char c : word.toCharArray()) {
                    int index = c - 'a';
                    if (curr.children[index] == null)
                        curr.children[index] = new Trie();
                    curr = curr.children[index];
                }
                curr.ends = true;
            }
        }

        public boolean search(String word) {
            char[] s = word.toCharArray();
            Trie prefix = root;
            for (int i = 0; i < s.length; i++) {
                //所有可能的替换可能
                for (char c = 'a'; c <= 'z'; ++c) {
                    if (s[i] == c) continue;
                    //保存当前字符，给后面重置
                    char tmp = s[i];
                    s[i] = c;
                    if (contains(s, prefix, i)) return true;
                    //置位
                    s[i] = tmp;
                }
                prefix = prefix.children[s[i] - 'a'];
                if (prefix == null) return false;
            }
            return false;
        }

        /**
         *
         * @param word 搜索的单词
         * @param prefix 父节点
         * @param index 修改的位置
         * @return
         */
        private boolean contains(char[] word, Trie prefix, int index) {
            Trie curr = prefix;
            for (int i = index; i < word.length; ++i) {
                curr = curr.children[word[i] - 'a'];
                if (curr == null) return false;
            }
            return curr.ends;
        }

        /**
         * Trie树节点
         */
        class Trie {
            private boolean ends;
            private Trie[] children;

            public Trie() {
                children = new Trie[26];
                ends = false;
            }
        }
    }
}
