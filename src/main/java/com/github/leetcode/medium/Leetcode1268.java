package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 12/30/19 22:45
 * @Description: Given an array of strings products and a string searchWord. We want to design a system that suggests at most three product names from products after each character of searchWord is typed. Suggested products should have common prefix with the searchWord. If there are more than three products with a common prefix return the three lexicographically minimums products.
 * <p>
 * Return list of lists of the suggested products after each character of searchWord is typed.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: products = ["mobile","mouse","moneypot","monitor","mousepad"], searchWord = "mouse"
 * Output: [
 * ["mobile","moneypot","monitor"],
 * ["mobile","moneypot","monitor"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"],
 * ["mouse","mousepad"]
 * ]
 * Explanation: products sorted lexicographically = ["mobile","moneypot","monitor","mouse","mousepad"]
 * After typing m and mo all products match and we show user ["mobile","moneypot","monitor"]
 * After typing mou, mous and mouse the system suggests ["mouse","mousepad"]
 * Example 2:
 * <p>
 * Input: products = ["havana"], searchWord = "havana"
 * Output: [["havana"],["havana"],["havana"],["havana"],["havana"],["havana"]]
 * Example 3:
 * <p>
 * Input: products = ["bags","baggage","banner","box","cloths"], searchWord = "bags"
 * Output: [["baggage","bags","banner"],["baggage","bags","banner"],["baggage","bags"],["bags"]]
 * Example 4:
 * <p>
 * Input: products = ["havana"], searchWord = "tatiana"
 * Output: [[],[],[],[],[],[],[]]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= products.length <= 1000
 * There are no repeated elements in products.
 * 1 <= Σ products[i].length <= 2 * 10^4
 * All characters of products[i] are lower-case English letters.
 * 1 <= searchWord.length <= 1000
 * All characters of searchWord are lower-case English letters.
 */
public class Leetcode1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new ArrayList<>();
        if (products == null || products.length == 0 || searchWord == null || searchWord.length() == 0) {
            return result;
        } else {
            TrieNode root = buildProductDict(products);
            int len = searchWord.length();
            for (int i = 0; i < len; i++) {
                String word = searchWord.substring(0, i + 1);
                result.add(helper(root, word));
            }
            return result;
        }


    }

    private List<String> helper(TrieNode root, String word) {
        List<String> temp = new ArrayList<>();
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return temp;
            } else {
                current = current.children[c - 'a'];
            }
        }
        if (current != null && current.words != null) {
            Collections.sort(current.words);
            int idx = 0;
            while (idx < 3 && current.words.size() >= idx + 1) {
                temp.add(current.words.get(idx));
                idx++;
            }
        }
        return temp;
    }

    private TrieNode buildProductDict(String[] products) {
        TrieNode root = new TrieNode(' ');
        for (String product : products) {
            TrieNode current = root;
            for (Character c : product.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    TrieNode child = new TrieNode(c);
                    child.words.add(product);
                    current.children[c - 'a'] = child;
                } else {
                    current.children[c - 'a'].words.add(product);
                }
                current = current.children[c - 'a'];
            }
        }
        return root;
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> words = new ArrayList<>();
        Character value;

        public TrieNode(Character value) {
            this.value = value;

        }


    }
}
