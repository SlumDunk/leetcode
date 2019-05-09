package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 3/18/19 13:43
 * @Description: Given a non-empty list of words, return the k most frequent elements.
 * <p>
 * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.
 * <p>
 * Example 1:
 * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * Output: ["i", "love"]
 * Explanation: "i" and "love" are the two most frequent words.
 * Note that "i" comes before "love" due to a lower alphabetical order.
 * Example 2:
 * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * Output: ["the", "is", "sunny", "day"]
 * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
 * with the number of occurrence being 4, 3, 2 and 1 respectively.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Input words contain only lowercase letters.
 * Follow up:
 * Try to solve it in O(n log k) time and O(n) extra space.
 */
public class Leetcode692 {
    class Element {
        String word;
        int frequency;

        public Element(String word, int freq) {
            this.word = word;
            this.frequency = freq;
        }
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList<>();
        if (words == null || words.length == 0) {
            return list;
        }

        Map<String, Integer> map = new HashMap<>();
        for (String word :
                words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Element> queue = new PriorityQueue<>((a, b) -> (b.frequency - a.frequency == 0 ? a.word.compareTo(b.word) : b.frequency - a.frequency));
        for (Map.Entry<String, Integer> entry :
                map.entrySet()) {
            Element element = new Element(entry.getKey(), entry.getValue());
            queue.offer(element);
        }
        while (k > 0 && queue.size() > 0) {
            list.add(queue.poll().word);
            k--;
        }
        return list;
    }
}
