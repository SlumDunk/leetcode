package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 5/9/21 20:31
 * @Description: You are given a string s, and an array of pairs of indices in the string pairs where pairs[i] = [a, b] indicates 2 indices(0-indexed) of the string.
 * <p>
 * You can swap the characters at any pair of indices in the given pairs any number of times.
 * <p>
 * Return the lexicographically smallest string that s can be changed to after using the swaps.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "dcab", pairs = [[0,3],[1,2]]
 * Output: "bacd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[1] and s[2], s = "bacd"
 * Example 2:
 * <p>
 * Input: s = "dcab", pairs = [[0,3],[1,2],[0,2]]
 * Output: "abcd"
 * Explaination:
 * Swap s[0] and s[3], s = "bcad"
 * Swap s[0] and s[2], s = "acbd"
 * Swap s[1] and s[2], s = "abcd"
 * Example 3:
 * <p>
 * Input: s = "cba", pairs = [[0,1],[1,2]]
 * Output: "abc"
 * Explaination:
 * Swap s[0] and s[1], s = "bca"
 * Swap s[1] and s[2], s = "bac"
 * Swap s[0] and s[1], s = "abc"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10^5
 * 0 <= pairs.length <= 10^5
 * 0 <= pairs[i][0], pairs[i][1] < s.length
 * s only contains lower case English letters.
 */
public class Leetcode1202 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int size = s.length();
        boolean[] visited = new boolean[size];
        char[] array = s.toCharArray();
        Queue<Character> minHeap = new PriorityQueue<>((a, b) -> a - b);
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (List<Integer> pair : pairs) {
            int v1 = pair.get(0), v2 = pair.get(1);
            if (!adj.containsKey(v1)) adj.put(v1, new ArrayList<>());
            if (!adj.containsKey(v2)) adj.put(v2, new ArrayList<>());
            adj.get(v1).add(v2);
            adj.get(v2).add(v1);
        }

        for (List<Integer> pair : pairs) {
            if (visited[pair.get(0)]) continue;
            TreeMap<Integer, Boolean> indices = new TreeMap<>();
            helper(adj, minHeap, array, visited, indices, pair.get(0));
            for (int index : indices.keySet()) {
                array[index] = minHeap.poll();
            }
        }
        return String.valueOf(array);

    }

    private void helper(Map<Integer, List<Integer>> adj, Queue<Character> minHeap, char[] array, boolean[] visited, TreeMap<Integer, Boolean> indices, Integer curr) {
        if (visited[curr]) return;
        visited[curr] = true;
        indices.put(curr, true);
        minHeap.add(array[curr]);
        for (int neighbor :
                adj.get(curr)) {
            helper(adj, minHeap, array, visited, indices, neighbor);
        }
    }
}
