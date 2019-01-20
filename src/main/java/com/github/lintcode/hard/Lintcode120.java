package com.github.lintcode.hard;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 1/20/19 14:32
 * @Description: Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 * <p>
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the dictionary
 * Example
 * Given:
 * start = "hit"
 * end = "cog"
 * dict = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * <p>
 * Notice
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 */
public class Lintcode120 {
    /*
    * @param start: a string
    * @param end: a string
    * @param dict: a set of string
    * @return: An integer
    */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null) {
            return 0;
        }

        if (start.equals(end)) {
            return 1;
        }

        dict.add(start);
        dict.add(end);

        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String current = queue.poll();
                for (String word : getNextWords(current, dict)) {
                    if (word.equals(end)) {
                        return length + 1;
                    } else {
                        queue.offer(word);
                        dict.remove(word);
                    }
                }
                size--;
            }
            length++;
        }

        return 0;
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
