package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 9/15/19 09:41
 * @Description:
 */
public class Leetcode1181 {
    class Pair {
        int index;
        String value;

        public Pair(int index, String value) {
            this.index = index;
            this.value = value;
        }
    }

    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        //成语接龙
        Map<String, List<Pair>> headMap = new HashMap<>();
        Map<String, List<Pair>> tailMap = new HashMap<>();

        int index = 0;
        for (String phrase : phrases) {
            String[] array = phrase.split(" ");
            String head = array[0];
            String tail = array[array.length - 1];

            headMap.putIfAbsent(head, new ArrayList<>());
            tailMap.putIfAbsent(tail, new ArrayList<>());

            headMap.get(head).add(new Pair(index, phrase));
            tailMap.get(tail).add(new Pair(index, phrase));
            index++;
        }
        TreeSet<String> set = new TreeSet<>((a, b) -> {
            return a.compareTo(b);
        });

        for (String key : tailMap.keySet()) {
            List<Pair> tailSentences = tailMap.get(key);
            if (headMap.get(key) != null) {
                List<Pair> headSentences = headMap.get(key);
                generateSentences(tailSentences, headSentences, set);
            }
        }

        List<String> result = new ArrayList<>();
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            result.add(iterator.next());
        }
        return result;

    }

    /**
     * @param tailSentences
     * @param headSentences
     * @param set
     */
    private void generateSentences(List<Pair> tailSentences, List<Pair> headSentences, TreeSet<String> set) {
        StringBuilder buffer1 = new StringBuilder();
        StringBuilder buffer2 = new StringBuilder();
        for (Pair tail :
                tailSentences) {
            String[] array1 = tail.value.split(" ");
            for (int i = 0; i < array1.length - 1; i++) {
                buffer1.append(array1[i]);
                buffer1.append(" ");
            }
            for (Pair head :
                    headSentences) {
                if (tail.index == head.index) {
                    continue;
                }
                String[] array2 = head.value.split(" ");
                for (int i = 0; i < array2.length - 1; i++) {
                    buffer2.append(array2[i]);
                    buffer2.append(" ");
                }
                buffer2.append(array2[array2.length - 1]);
                set.add(buffer1.toString() + buffer2.toString());
                buffer2.setLength(0);

            }
            buffer1.setLength(0);
        }
    }
}
