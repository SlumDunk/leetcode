package com.github.leetcode.medium;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: zerongliu
 * @Date: 5/25/19 20:31
 * @Description: A gene string can be represented by an 8-character long string, with choices from "A", "C", "G", "T".
 * <p>
 * Suppose we need to investigate about a mutation (mutation from "start" to "end"), where ONE mutation is defined as ONE single character changed in the gene string.
 * <p>
 * For example, "AACCGGTT" -> "AACCGGTA" is 1 mutation.
 * <p>
 * Also, there is a given gene "bank", which records all the valid gene mutations. A gene must be in the bank to make it a valid gene string.
 * <p>
 * Now, given 3 things - start, end, bank, your task is to determine what is the minimum number of mutations needed to mutate from "start" to "end". If there is no such a mutation, return -1.
 * <p>
 * Note:
 * <p>
 * Starting point is assumed to be valid, so it might not be included in the bank.
 * If multiple mutations are needed, all mutations during in the sequence must be valid.
 * You may assume start and end string is not the same.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * start: "AACCGGTT"
 * end:   "AACCGGTA"
 * bank: ["AACCGGTA"]
 * <p>
 * return: 1
 * <p>
 * <p>
 * Example 2:
 * <p>
 * start: "AACCGGTT"
 * end:   "AAACGGTA"
 * bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
 * <p>
 * return: 2
 * <p>
 * <p>
 * Example 3:
 * <p>
 * start: "AAAAACCC"
 * end:   "AACCCCCC"
 * bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
 * <p>
 * return: 3
 */
public class Leetcode433 {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bs = new HashSet<>();
        Set<Character> cs = new HashSet<>();
        if (bank == null || bank.length == 0) return -1;
        for (String s :
                bank) {
            bs.add(s);
            for (Character c :
                    s.toCharArray()) {
                if (!cs.contains(c)) cs.add(c);
            }
        }
        if (!bs.contains(end)) return -1;
        if (start.equals(end)) return 0;

        int step = 0;
        Set<String> used = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                String curr = queue.poll();
                used.add(curr);
                for (int j = 0; j < curr.length(); j++) {
                    for (char k :
                            cs) {
                        if (k != curr.charAt(j)) {
                            String ns = curr.substring(0, j) + k + curr.substring(j + 1);
                            if (ns.equals(end)) return step;
                            if (!used.contains(ns) && bs.contains(ns)) queue.add(ns);
                        }
                    }

                }
            }
        }
        return -1;
    }
}
