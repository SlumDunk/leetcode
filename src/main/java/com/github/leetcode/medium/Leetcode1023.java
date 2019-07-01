package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 20:21
 * @Description: A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)
 * <p>
 * Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * Output: [true,false,true,true,false]
 * Explanation:
 * "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
 * "FootBall" can be generated like this "F" + "oot" + "B" + "all".
 * "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
 * Example 2:
 * <p>
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * Output: [true,false,true,false,false]
 * Explanation:
 * "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
 * "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
 * Example 3:
 * <p>
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * Output: [false,true,false,false,false]
 * Explanation:
 * "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * All strings consists only of lower and upper case English letters.
 */
public class Leetcode1023 {
    class TrieNode {
        Character val;
        TrieNode child;

        TrieNode(Character val) {
            this.val = val;
        }
    }

    /**
     * 根据模板字符串创建Trie树
     *
     * @param pattern
     * @param root
     */
    private void constructTrie(String pattern, TrieNode root) {
        TrieNode currNode = root;
        for (int i = 0; i < pattern.length(); i++) {
            currNode.child = new TrieNode(pattern.charAt(i));
            currNode = currNode.child;
        }
    }

    /**
     * FooBar
     * FoBa
     *
     *
     * @param queries
     * @param pattern
     * @return
     */
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        TrieNode root = new TrieNode('#');
        constructTrie(pattern, root);
        //遍历所有单词
        for (int j = 0; j < queries.length; j++) {
            String query = queries[j];
            TrieNode currNode = root.child;
            //遍历单词所有字符
            for (int i = 0; i < query.length(); i++) {
                char key = query.charAt(i);
                if (currNode == null) {//模板树当前节点是空
                    if (isUpperCase(key)) {
                        res.add(false);
                        break;
                    }
                } else {
                    if (isUpperCase(currNode.val) && isUpperCase(key)) { // 大写，大写
                        if (currNode.val != key) {
                            res.add(false);
                            break;
                        } else {
                            currNode = currNode.child;
                        }
                    } else if (isLowerCase(currNode.val) && isUpperCase(key)) { // 小写，大写
                        res.add(false);
                        break;
                    } else if (currNode.val == key) { // upper, lower or lower, lower 对得上就前进，对不上就表示小写字母是插入的
                        currNode = currNode.child;
                    }
                }
            }
            //
            if (res.size() == j)
                res.add(currNode == null);
        }
        return res;
    }
}
