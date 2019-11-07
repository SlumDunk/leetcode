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


    public List<String> generatePalindromes_(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return result;
        } else {
            List<Character> temp = new ArrayList<>();
            Map<Character, Integer> map = new HashMap<>();
            List<Character> list = new ArrayList<>();

            char[] array = s.toCharArray();
            int odd = 0;
            //count the number of each Character
            for (char item : array) {
                if (map.containsKey(item)) {
                    map.put(item, map.get(item) + 1);
                } else {
                    map.put(item, 1);
                }
                odd += (map.get(item) % 2 == 0 ? -1 : 1);
            }

            if (odd > 1) {
                return result;
            }
            String mid = "";
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                Character key = entry.getKey();
                Integer value = entry.getValue();
                if (value % 2 == 1) {
                    mid += key;
                }

                for (int i = 0; i < value / 2; i++) {
                    list.add(key);
                }

            }

            boolean[] visited = new boolean[list.size()];
            helper(result, list, temp, visited, mid);
            return result;
        }
    }

    public void helper(List<String> result, List<Character> list, List<Character> temp, boolean[] visited, String mid) {
        if (temp.size() == list.size()) {
            result.add(list2str(temp, mid));
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                temp.add(list.get(i));
                helper(result, list, temp, visited, mid);
                temp.remove(temp.size() - 1);
                visited[i] = false;

                while (i < list.size() - 1 && list.get(i) == list.get(i + 1)) {
                    i++;
                }
            }
        }
    }

    private boolean isPalindorme(List<Character> list) {
        int left = 0, right = list.size() - 1;

        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private String list2str(List<Character> list, String mid) {
        StringBuilder buffer = new StringBuilder("");
        for (Character item : list) {
            buffer.append(item);
        }

        return buffer.toString() + mid + buffer.reverse().toString();
    }
}
