package com.github.interview.amazon;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/6/19 16:01
 * @Description:
 */
public class No3ConsecutiveCharsAreSame {
    private static String generateString(Map<Character, Integer> map) {

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<Map.Entry<Character, Integer>>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(map.entrySet());

        Queue<Map.Entry<Character, Integer>> waitQueue = new LinkedList<Map.Entry<Character, Integer>>();

        StringBuilder sb = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> cur = maxHeap.poll();

            int len = sb.length();

            if (len >= 2 && sb.charAt(len - 1) == sb.charAt(len - 2) && sb.charAt(len - 1) == cur.getKey()) {
                return "IMPOSSIBLE TO CONSTRUCT";
            }

            if (cur.getValue() >= 2) {
                sb.append(cur.getKey());
                sb.append(cur.getKey());
                cur.setValue(cur.getValue() - 2);
            } else if (cur.getValue() > 0) {
                sb.append(cur.getKey());
                cur.setValue(cur.getValue() - 1);
            }

            if (cur.getValue() > 0)
                waitQueue.add(cur);
            //中间有别的字符插入了，可以重新入队
            if (sb.length() % 3 == 0 || maxHeap.isEmpty()) {
                if (!waitQueue.isEmpty()) {
                    Map.Entry<Character, Integer> front = waitQueue.poll();
                    maxHeap.offer(front);
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        map.put('A', 1);
        map.put('B', 1);
        map.put('C', 6);
        System.out.println("[A = 1, B = 1, C = 6]");
        System.out.println(generateString(map));
        System.out.println();

        map.put('A', 1);
        map.put('B', 2);
        map.put('C', 3);
        System.out.println("[A = 1, B = 2, C = 3]");
        System.out.println(generateString(map));
        System.out.println();


        map.put('A', 3);
        map.put('B', 3);
        map.put('C', 3);
        System.out.println("[A = 3, B = 3, C = 3]");
        System.out.println(generateString(map));
        System.out.println();

        map.put('A', 1);
        map.put('B', 1);
        map.put('C', 9);
        System.out.println("[A = 1, B = 1, C = 9]");
        System.out.println(generateString(map));
        System.out.println();

    }
}
