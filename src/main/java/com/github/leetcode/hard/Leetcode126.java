package com.github.leetcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 3/3/19 15:35
 * @Description: Given two words (beginWord and endWord), and a dictionary'word word list, find all shortest transformation sequence(word) from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output:
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: []
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class Leetcode126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList == null || !wordList.contains(endWord)) {
            result.add(new ArrayList<>());
            return result;
        }

        wordList.add(beginWord);
        //存储图结构，后置节点指向前置节点
        Map<String, List<String>> map = new HashMap<>();
        //存储开始节点到当前节点的长度
        Map<String, Integer> distance = new HashMap<>();
        bfs(map, distance, beginWord, endWord, wordList);
        List<String> temp = new ArrayList<>();
        dfs(result, temp, endWord, beginWord, distance, map);
        return result;
    }

    /**
     * @param result
     * @param temp
     * @param current   当前单词
     * @param beginWord 开始单词
     * @param distance
     * @param map
     */
    private void dfs(List<List<String>> result, List<String> temp, String current, String beginWord, Map<String, Integer> distance, Map<String, List<String>> map) {
        temp.add(current);
        if (current.equals(beginWord)) {
            Collections.reverse(temp);
            result.add(new ArrayList<>(temp));
            Collections.reverse(temp);
        } else {
            for (String previous :
                    map.get(current)) {
                if (distance.containsKey(previous) && distance.get(current) == distance.get(previous) + 1) {
                    dfs(result, temp, previous, beginWord, distance, map);
                }
            }
        }
        temp.remove(temp.size() - 1);
    }

    /**
     * 获取图结构
     *
     * @param map
     * @param distance
     * @param beginWord
     * @param endWord
     * @param wordList
     */
    private void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);
        for (String word :
                wordList) {
            map.put(word, new ArrayList<>());
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            for (String word :
                    getNextWords(current, wordList)) {
                //从后指向前
                map.get(word).add(current);
                if (!distance.containsKey(word)) {
                    distance.put(word, distance.get(current) + 1);
                    queue.offer(word);
                }
            }
        }
    }

    /**
     * 获取下一个单词
     *
     * @param current
     * @param wordList
     * @return
     */
    public List<String> getNextWords(String current, List<String> wordList) {
        List<String> words = new ArrayList<String>();
        for (int i = 0; i < current.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == current.charAt(i)) {
                    continue;
                } else {
                    String word = replace(current, i, c);
                    if (wordList.contains(word)) {
                        words.add(word);
                    }
                }
            }
        }
        return words;
    }

    /**
     * 替换单词中的某个字符
     *
     * @param current
     * @param index
     * @param c
     * @return
     */
    public String replace(String current, int index, char c) {
        char[] chars = current.toCharArray();
        chars[index] = c;
        return new String(chars);
    }


    /**
     * O(N*26^l) l is the average length of word
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public List<List<String>> findLadders_(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (wordList == null || !wordList.contains(endWord)) {
            return result;
        }

        wordList.add(beginWord);

        Set<String> wordSet = new HashSet<>(wordList);

        Map<String, List<String>> map = new HashMap<>();

        Map<String, Integer> distance = new HashMap<>();

        bfs(map, distance, beginWord, wordSet);

        List<String> temp = new ArrayList<>();

        dfs_(result, temp, endWord, beginWord, distance, map);

        return result;
    }


    public void dfs_(List<List<String>> result, List<String> temp, String current, String beginWord, Map<String, Integer> distance, Map<String, List<String>> map) {
        temp.add(current);
        if (current.equals(beginWord)) {
            result.add(reverse(temp));
        } else {
            for (String previous : map.getOrDefault(current, new ArrayList<>())) {
                if (distance.containsKey(previous) && distance.get(current) == distance.get(previous) + 1) {
                    dfs_(result, temp, previous, beginWord, distance, map);
                }
            }
        }
        temp.remove(temp.size() - 1);
    }

    public void bfs(Map<String, List<String>> map, Map<String, Integer> distance, String beginWord, Set<String> wordSet) {
        Queue<String> queue = new LinkedList<>();

        queue.add(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            for (String word : getWordList(current, wordSet)) {
                List<String> prevWords = map.getOrDefault(word, new ArrayList<>());
                prevWords.add(current);
                map.put(word, prevWords);
                if (!distance.containsKey(word)) {
                    distance.put(word, distance.get(current) + 1);
                    queue.add(word);
                }
            }
        }


    }

    private List<String> getWordList(String current, Set<String> wordSet) {
        List<String> words = new ArrayList<String>();
        for (int i = 0; i < current.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == current.charAt(i)) {
                    continue;
                } else {
                    String word = replace_(current, i, c);
                    if (wordSet.contains(word)) {
                        words.add(word);
                    }
                }
            }
        }
        return words;
    }

    private String replace_(String current, int i, char c) {
        char[] array = current.toCharArray();
        array[i] = c;
        return new String(array);
    }

    private List<String> reverse(List<String> list) {
        List<String> result = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            result.add(list.get(i));
        }
        return result;
    }
}
