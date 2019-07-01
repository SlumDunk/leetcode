package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 13:19
 * @Description: In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.
 * <p>
 * Return the minimum number of rabbits that could be in the forest.
 * <p>
 * Examples:
 * Input: answers = [1, 1, 2]
 * Output: 5
 * Explanation:
 * The two rabbits that answered "1" could both be the same color, say red.
 * The rabbit than answered "2" can't be red or the answers would be inconsistent.
 * Say the rabbit that answered "2" was blue.
 * Then there should be 2 other blue rabbits in the forest that didn't answer into the array.
 * The smallest possible number of rabbits in the forest is therefore 5: 3 that answered plus 2 that didn't.
 * <p>
 * Input: answers = [10, 10, 10]
 * Output: 11
 * <p>
 * Input: answers = []
 * Output: 0
 * Note:
 * <p>
 * answers will have length at most 1000.
 * Each answers[i] will be an integer in the range [0, 999].
 */
public class Leetcode781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int answer : answers) {
            if (answer == 0) {
                result += 1;
            } else {
                map.put(answer, map.getOrDefault(answer, 0) + 1);
                if (map.get(answer) > answer + 1) {
                    // that color category is full
                    result += (answer + 1);
                    map.put(answer, map.get(answer) - answer - 1);
                }
            }
        }

        for (int k : map.keySet()) {
            result += (k + 1);
        }

        return result;
    }
}
