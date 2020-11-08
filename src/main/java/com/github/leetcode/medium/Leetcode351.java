package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 2/25/19 15:32
 * @Description: Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.
 * <p>
 * <p>
 * <p>
 * Rules for a valid pattern:
 * <p>
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
 * The order of keys used matters.
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Explanation:
 * <p>
 * | 1 | 2 | 3 |
 * | 4 | 5 | 6 |
 * | 7 | 8 | 9 |
 * Invalid move: 4 - 1 - 3 - 6
 * Line 1 - 3 passes through key 2 which had not been selected in the pattern.
 * <p>
 * Invalid move: 4 - 1 - 9 - 2
 * Line 1 - 9 passes through key 5 which had not been selected in the pattern.
 * <p>
 * Valid move: 2 - 4 - 1 - 3 - 6
 * Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern
 * <p>
 * Valid move: 6 - 5 - 4 - 1 - 9 - 2
 * Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.
 * <p>
 * <p>
 * <p>
 * Example:
 * <p>
 * Input: m = 1, n = 1
 * Output: 9
 */
public class Leetcode351 {

    /**
     * key 为关联的两个数字，同column, 同row, 或同diagonal,
     * value为两个数字串起来要经过的点
     */
    public Map<Integer, Integer> map = new HashMap<>();

    {
        //diagonal and anti-diagonal
        map.put(19, 5);
        map.put(91, 5);
        map.put(37, 5);
        map.put(73, 5);
        //same column
        map.put(17, 4);
        map.put(71, 4);
        map.put(28, 5);
        map.put(82, 5);
        map.put(39, 6);
        map.put(93, 6);
        //same row
        map.put(13, 2);
        map.put(31, 2);
        map.put(46, 5);
        map.put(64, 5);
        map.put(79, 8);
        map.put(97, 8);
    }

    int m;
    int n;



    /**
     * O(n!)
     *
     * @param m: an integer
     * @param n: an integer
     * @return: the total number of unlock patterns of the Android lock screen
     */
    public int numberOfPatterns(int m, int n) {
        if (m > n) {
            return 0;
        }

        this.m = m;
        this.n = n;
        boolean[] visited = new boolean[10];
        int res = 0;
        for (int i = 1; i <= 9; i++) {
            visited[i] = true;
            res += helper(1, visited, i);
            visited[i] = false;
        }
        return res;
    }

    /**
     * @param len     当前长度
     * @param visited
     * @param prev    前一个key的位置
     * @return
     */
    private int helper(int len, boolean[] visited, int prev) {
        int count = 0;
        if (len >= m && len <= n) {
            count++;
        }
        if (len >= n) {
            return count;
        }

        for (int i = 1; i <= 9; i++) {
            if (visited[i]) {
                continue;
            }
            int key = 10 * i + prev;
            if (map.containsKey(key) && !visited[map.get(key)]) {
                continue;
            }
            visited[i] = true;
            count += helper(len + 1, visited, i);
            visited[i] = false;

        }


        return count;
    }

}
