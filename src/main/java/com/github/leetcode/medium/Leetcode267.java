package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 3/4/19 20:55
 * @Description: Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.
 * <p>
 * Example 1:
 * <p>
 * Input: "aabb"
 * Output: ["abba", "baab"]
 * Example 2:
 * <p>
 * Input: "abc"
 * Output: []
 */
public class Leetcode267 {
    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            odd += map.get(c) % 2 != 0 ? 1 : -1;
        }

        if (odd > 1) return res;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val % 2 != 0) mid += key;
            for (int i = 0; i < val / 2; i++) {
                list.add(key);
            }
        }
        boolean[] visited = new boolean[list.size()];
        helper(list, mid, visited, new StringBuilder(), res);
        return res;


    }

    private void helper(List<Character> list, String mid, boolean[] visited, StringBuilder stringBuilder, List<String> res) {
        if (stringBuilder.length() == list.size()) {
            res.add(stringBuilder.toString() + mid + stringBuilder.reverse().toString());
            stringBuilder.reverse();
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                stringBuilder.append(list.get(i));
                helper(list, mid, visited, stringBuilder, res);
                visited[i] = false;
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
    }
}
