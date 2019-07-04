package com.github.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 19:26
 * @Description: In a group of N people (labelled 0, 1, 2, ..., N-1), each person has different amounts of money, and different levels of quietness.
 * <p>
 * For convenience, we'll call the person with label x, simply "person x".
 * <p>
 * We'll say that richer[i] = [x, y] if person x definitely has more money than person y.  Note that richer may only be a subset of valid observations.
 * <p>
 * Also, we'll say quiet[x] = q if person x has quietness q.
 * <p>
 * Now, return answer, where answer[x] = y if y is the least quiet person (that is, the person y with the smallest value of quiet[y]), among all people who definitely have equal to or more money than person x.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
 * Output: [5,5,2,5,4,5,6,7]
 * Explanation:
 * answer[0] = 5.
 * Person 5 has more money than 3, which has more money than 1, which has more money than 0.
 * The only person who is quieter (has lower quiet[x]) is person 7, but
 * it isn't clear if they have more money than person 0.
 * <p>
 * answer[7] = 7.
 * Among all people that definitely have equal to or more money than person 7
 * (which could be persons 3, 4, 5, 6, or 7), the person who is the quietest (has lower quiet[x])
 * is person 7.
 * <p>
 * The other answers can be filled out with similar reasoning.
 * Note:
 * <p>
 * 1 <= quiet.length = N <= 500
 * 0 <= quiet[i] < N, all quiet[i] are different.
 * 0 <= richer.length <= N * (N-1) / 2
 * 0 <= richer[i][j] < N
 * richer[i][0] != richer[i][1]
 * richer[i]'s are all different.
 * The observations in richer are all logically consistent.
 */
public class Leetcode851 {
    /**
     * 缓存比当前节点富有，且最吵的节点
     */
    int[] memo;

    public int[] loudAndRich(int[][] richer, int[] quiet) {
        memo = new int[quiet.length];
        Arrays.fill(memo, Integer.MIN_VALUE);
        int[] res = new int[quiet.length];
        List<Integer>[] graph = new List[quiet.length];
        for (int[] edge : richer) {
            if (graph[edge[1]] == null) {
                graph[edge[1]] = new ArrayList<Integer>();
            }
            graph[edge[1]].add(edge[0]);
        }

        for (int i = 0; i < quiet.length; i++) {
            res[i] = getLoudestIndex(graph, quiet, i);
        }
        return res;
    }

    /**
     * @param graph    有向图，由穷的指向富的
     * @param quiet    安静数组
     * @param curIndex 当前找的节点
     * @return
     */
    public int getLoudestIndex(List<Integer>[] graph, int[] quiet, int curIndex) {
        //找到结果了，直接返回
        if (memo[curIndex] != Integer.MIN_VALUE) return memo[curIndex];
        //走到头了
        if (graph[curIndex] == null) return curIndex;
        //找不到的话那就是本身
        int res = curIndex;
        for (int next : graph[curIndex]) {
            //深度搜索富裕的节点
            int curRes = getLoudestIndex(graph, quiet, next);
            //比较安静值，找安静值最小的
            if (quiet[curRes] < quiet[res]) {
                res = curRes;
            }
        }
        memo[curIndex] = res;
        return res;
    }
}
