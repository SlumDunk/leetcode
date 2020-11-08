package com.github.interview.ibm;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 10/18/20 17:09
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(1);
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        int k = 2;
        System.out.println(evenSubarray(numbers, k));
    }

    private static Map<String, String> cache = new HashMap<>();

    public static int evenSubarray(List<Integer> numbers, int k) {
        List<Integer> copyList = new ArrayList<>(numbers);
        for (int i = 0; i < numbers.size(); i++) {
            numbers.set(i, numbers.get(i) % 2 == 0 ? 0 : 1);
        }
        Set<String> set = new HashSet<String>();

        for (int m = 0; m <= k; m++) {
            //key为前缀和，value为出现的位置
            Map<Integer, Pair> map = new HashMap<>();
            int sum = 0;
            Pair prePair = new Pair();
            prePair.set.add(-1);
            map.put(0, prePair);
            for (int i = 0; i < numbers.size(); i++) {
                //当前位置i
                sum += numbers.get(i);
                if (map.containsKey(sum - m)) {
                    Set<Integer> startSet = map.get(sum - m).set;
                    for (Integer idx : startSet) {
                        set.add(buildElement(copyList, idx + 1, i));
                    }
                }
                if (map.containsKey(sum)) {
                    map.get(sum).set.add(i);
                } else {
                    Pair pair = new Pair();
                    pair.set.add(i);
                    map.put(sum, pair);
                }
            }
        }
//        System.out.println(set);
        return set.size();

    }

    private static String buildElement(List<Integer> numbers, int start, int end) {
        String key = start + "#" + end;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }
        StringBuilder buffer = new StringBuilder("");
        for (int i = start; i <= end; i++) {
            buffer.append(numbers.get(i) + "#");
        }
        cache.put(key, buffer.toString());
        return buffer.toString();
    }

    public static class Pair {
        public Set<Integer> set = new HashSet<>();
    }
}
