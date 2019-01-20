package com.github.lintcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/20/19 15:07
 * @Description:
 */
public class Lintcode121 {
    public static void main(String[] args) {
        Lintcode121 lintcode121 = new Lintcode121();
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        lintcode121.findLadders("a", "c", dict);
    }

    /*
   * @param start: a string
   * @param end: a string
   * @param dict: a set of string
   * @return: a list of lists of string
   */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        List<List<String>> result = new ArrayList<>();
        if (dict == null) {
            result.add(new ArrayList<>());
            return result;
        }

        if (start.equals(end)) {
            List<String> list = new ArrayList<>();
            list.add(end);
            result.add(list);
            return result;
        }

        dict.add(start);
        dict.add(end);
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        bfs(map, distance, start, end, dict);
        List<String> temp = new ArrayList();
        dfs(result, temp, end, start, distance, map);
        return result;
    }

    public void dfs(List<List<String>> result, List<String> temp, String current, String start, Map<String, Integer> distance, Map<String, List<String>> map) {
        temp.add(current);
        if (current.equals(start)) {
            Collections.reverse(temp);
            result.add(new ArrayList<>(temp));
            Collections.reverse(temp);
        } else {
            for (String previous : map.get(current)) {
                if (distance.containsKey(previous) && distance.get(current) == distance.get(previous) + 1) {
                    dfs(result, temp, previous, start, distance, map);
                }
            }
        }
        temp.remove(temp.size() - 1);
    }

    public void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String start, String end, Set<String> dict) {
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        distance.put(start, 0);
        for (String word : dict) {
            map.put(word, new ArrayList<String>());
        }
        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String word : getNextWords(current, dict)) {
                //方便从end节点往回回溯
                map.get(word).add(current);
                if (!distance.containsKey(word)) {
                    distance.put(word, distance.get(current) + 1);
                    queue.offer(word);
                }
            }
        }
    }

    public List<String> getNextWords(String current, Set<String> dict) {
        List<String> words = new ArrayList<String>();
        for (int i = 0; i < current.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == current.charAt(i)) {
                    continue;
                } else {
                    String word = replace(current, i, c);
                    if (dict.contains(word)) {
                        words.add(word);
                    }
                }
            }
        }
        return words;
    }

    public String replace(String current, int index, char c) {
        char[] chars = current.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
}
