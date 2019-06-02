package com.github.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @Author: zerongliu
 * @Date: 5/28/19 20:28
 * @Description: Given a blacklist B containing unique integers from [0, N), write a function to return a uniform random integer from [0, N) which is NOT in B.
 * <p>
 * Optimize it such that it minimizes the call to system’s Math.random().
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 1000000000
 * 0 <= B.length < min(100000, N)
 * [0, N) does NOT include N. See interval notation.
 * Example 1:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[1,[]],[],[],[]]
 * Output: [null,0,0,0]
 * Example 2:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[2,[]],[],[],[]]
 * Output: [null,1,1,1]
 * Example 3:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[3,[1]],[],[],[]]
 * Output: [null,0,0,2]
 * Example 4:
 * <p>
 * Input:
 * ["Solution","pick","pick","pick"]
 * [[4,[2]],[],[],[]]
 * Output: [null,1,3,1]
 * Explanation of Input Syntax:
 * <p>
 * The input is two lists: the subroutines called and their arguments. Solution's constructor has two arguments, N and the blacklist B. pick has no arguments. Arguments are always wrapped with a list, even if there aren't any.
 */
public class Leetcode710 {
    class Solution {
        Map<Integer, Integer> map;
        int M;
        Random rand;

        public Solution(int N, int[] blacklist) {
            map = new HashMap<>();
            M = N - blacklist.length;
            for (int e :
                    blacklist) {
                map.put(e, -1);
            }
            N--;
            for (int e :
                    blacklist) {
                if (e < M) {
                    while (map.containsKey(N)) N--;
                    map.put(e, N--);
                }
            }
            rand = new Random();
        }

        public int pick() {
            int idx = rand.nextInt(M);
            return map.containsKey(idx) ? map.get(idx) : idx;
        }
    }
}
