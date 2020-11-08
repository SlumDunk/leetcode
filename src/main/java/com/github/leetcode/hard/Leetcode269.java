package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/4/19 19:25
 * @Description: There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.
 * <p>
 * For example,
 * Given the following words in dictionary,
 * [
 * "wrt",
 * "wrf",
 * "er",
 * "ett",
 * "rftt"
 * ]
 * The correct order is: "wertf".
 * <p>
 * Note:
 * You may assume all letters are in lowercase.
 * If the order is invalid, return an empty string.
 * There may be multiple valid order of letters, return any one of them is fine.
 * Hide Company Tags Google Facebook
 * Hide Tags Graph Topological Sort
 * Hide Similar Problems (M) Course Schedule II
 */
public class Leetcode269 {
    /**
     * 拓扑排序
     * dfs 找到叶子节点，放进stack，再回溯，最后按stack中元素弹出顺序返回
     * bfs 找到入度为0的节点，BFS
     *
     * O(mn) m is the average length of words
     *
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        StringBuilder result = new StringBuilder();
        //构造图 key为节点值，Set为另一端Vertex节点列表
        HashMap<Character, Set<Character>> map = new HashMap<Character, Set<Character>>();
        //节点的入度
        Map<Character, Integer> degree = new HashMap<>();
        int len = words.length;
        for (String word : words) {
            for (Character val : word.toCharArray()) {
                degree.put(val, 0);
            }
        }
        //构造图
        for (int i = 0; i < len - 1; i++) {
            String cur = words[i];
            String next = words[i + 1];
            int min = Math.min(cur.length(), next.length());
            for (int j = 0; j < min; j++) {
                char from = cur.charAt(j);
                char to = next.charAt(j);
                if (from != to) {
                    Set<Character> set = map.getOrDefault(from, new HashSet<>());
                    if (!set.contains(to)) {
                        set.add(to);
                        //入度加1
                        degree.put(to, degree.get(to) + 1);
                    }
                    map.put(from,set);
                    break;
                }
            }
        }

        //入度为0的节点先入队列，广度优先搜索
        Queue<Character> queue = new LinkedList<>();
        for (Character key :
                degree.keySet()) {
            if (degree.get(key) == 0) {
                queue.add(key);
            }
        }
        while (!queue.isEmpty()) {
            Character from = queue.poll();
            result.append(from);
            //调整邻边节点的入度
            if (map.containsKey(from)) {
                for (char to : map.get(from)) {
                    degree.put(to, degree.get(to) - 1);
                    if (degree.get(to) == 0) {//入度为0，证明前置节点已经处理完
                        queue.offer(to);
                    }
                }
            }
        }
        //防止死循环 结果长度和节点长度应该一致
        return result.length() == degree.size() ? result.toString() : "";
    }
}
