package com.github.leetcode.hard;

/**
 * @Author: zerongliu
 * @Date: 6/4/19 22:26
 * @Description: Two strings X and Y are similar if we can swap two letters (in different positions) of X, so that it equals Y.
 * <p>
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2), and "rats" and "arts" are similar, but "star" is not similar to "tars", "rats", or "arts".
 * <p>
 * Together, these form two connected groups by similarity: {"tars", "rats", "arts"} and {"star"}.  Notice that "tars" and "arts" are in the same group even though they are not similar.  Formally, each group is such that a word is in the group if and only if it is similar to at least one other word in the group.
 * <p>
 * We are given a list A of strings.  Every string in A is an anagram of every other string in A.  How many groups are there?
 * <p>
 * Example 1:
 * <p>
 * Input: ["tars","rats","arts","star"]
 * Output: 2
 * Note:
 * <p>
 * A.length <= 2000
 * A[i].length <= 1000
 * A.length * A[i].length <= 20000
 * All words in A consist of lowercase letters only.
 * All words in A have the same length and are anagrams of each other.
 * The judging time limit has been increased for this question.
 */
public class Leetcode839_2 {
    public int numSimilarGroups(String[] A) {
        int n = A.length;
        int[] parent = new int[n];
        for (int i = 1; i < n; i++) parent[i] = i;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilarString(A[i], A[j])) {
                    int p1 = find(parent, i), p2 = find(parent, j);
                    if (p1 != p2) {
                        parent[p2] = p1;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) res++;
        }
        return res;
    }

    /**
     * 判断两个字符串是否相似
     *
     * @param s1
     * @param s2
     * @return
     */
    private boolean isSimilarString(String s1, String s2) {
        int diff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) diff++;
        }
        return (diff == 2 || diff == 0);
    }

    /**
     * 找a[x]的最祖宗节点
     *
     * @param a
     * @param x
     * @return
     */
    private int find(int[] a, int x) {
        if (a[x] != x) {
            a[x] = find(a, a[x]);
        }
        return a[x];
    }
}
