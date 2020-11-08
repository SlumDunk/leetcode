package com.github.leetcode.medium;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author: zerongliu
 * @Date: 5/8/19 12:14
 * @Description: Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * <p>
 * Input: S = "aaab"
 * Output: ""
 * Note:
 * <p>
 * S will consist of lowercase letters and have length in range [1, 500].
 */
public class Leetcode767 {

    /**
     * nlgA A is the number of alphabet
     * @param S
     * @return
     */
    public String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c :
                S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (Character key :
                map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            int[] first = pq.poll();
            if (sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)) {
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            } else {
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }


    class Pair{
        int freq;
        char val;

        public Pair(char c, int freq){
            this.val=c;
            this.freq=freq;
        }
    }

    /**
     * O(nlgA)
     * @param S
     * @return
     */
    public String reorganizeString_(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        Map<Character, Integer> map = new HashMap<>();
        for (char c :
                S.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            if (count > (S.length() + 1) / 2) return "";
            map.put(c, count);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return Integer.compare(b.freq,a.freq);
            }
        });
        for (Character key :
                map.keySet()) {
            pq.add(new Pair(key,map.get(key)));
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size()>=2) {
            Pair first = pq.poll();
            Pair second=pq.poll();

            sb.append(first.val);
            sb.append(second.val);

            if(--first.freq>0){
                pq.add(first);
            }

            if(--second.freq>0){
                pq.add(second);
            }

        }

        if(pq.size()>0){
            sb.append(pq.poll().val);
        }
        return sb.toString();
    }
}
