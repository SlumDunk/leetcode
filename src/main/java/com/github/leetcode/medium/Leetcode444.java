package com.github.leetcode.medium;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 6/26/19 23:00
 * @Description: Check whether the original sequence org can be uniquely reconstructed from the sequences in seqs. The org sequence is a permutation of the integers from 1 to n, with 1 ≤ n ≤ 104. Reconstruction means building a shortest common supersequence of the sequences in seqs (i.e., a shortest sequence so that all sequences in seqs are subsequences of it). Determine whether there is only one sequence that can be reconstructed from seqs and it is the org sequence.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3]]
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * [1,2,3] is not the only one sequence that can be reconstructed, because [1,3,2] is also a valid sequence that can be reconstructed.
 * Example 2:
 * <p>
 * Input:
 * org: [1,2,3], seqs: [[1,2]]
 * <p>
 * Output:
 * false
 * <p>
 * Explanation:
 * The reconstructed sequence can only be [1,2].
 * Example 3:
 * <p>
 * Input:
 * org: [1,2,3], seqs: [[1,2],[1,3],[2,3]]
 * <p>
 * Output:
 * true
 * <p>
 * Explanation:
 * The sequences [1,2], [1,3], and [2,3] can uniquely reconstruct the original sequence [1,2,3].
 * Example 4:
 * <p>
 * Input:
 * org: [4,1,5,2,6,3], seqs: [[5,2,6,3],[4,1,5,2]]
 * <p>
 * Output:
 * true
 * UPDATE (2017/1/8):
 * The seqs parameter had been changed to a list of list of strings (instead of a 2d array of strings). Please reload the code definition to get the latest changes.
 */
public class Leetcode444 {
    /**
     * bfs拓扑排序找最短路径
     * @param org
     * @param seqs
     * @return
     */
    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        int n = org.length;
        //存储每个节点
        Set<Integer>[] kids = new Set[n + 1];
        //每个节点的入度
        int[] degrees = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            kids[i] = new HashSet<>();
        }
        int cnt = 0;
        for (List<Integer> seq : seqs) {
            cnt += seq.size();
            //第一个元素超出范围
            if (seq.size() >= 1 && (seq.get(0) <= 0 || seq.get(0) > n)) {
                return false;
            }
            for (int i = 1; i < seq.size(); ++i) {
                //有元素超出范围
                if (seq.get(i) <= 0 || seq.get(i) > n) {
                    return false;
                }
                if (!kids[seq.get(i - 1)].contains(seq.get(i))) {
                    kids[seq.get(i - 1)].add(seq.get(i));
                    //入度加1
                    ++degrees[seq.get(i)];
                }
            }
        }
        //不满足条件
        if (cnt < n) {
            return false;
        }
        //BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            if (degrees[i] == 0) {
                q.offer(i);
            }
        }
        //数组开始索引
        int idx = 0;
        while (q.size() == 1) {
            int ele = q.poll();
            if (org[idx++] != ele) {
                return false;
            }
            for (int next : kids[ele]) {
                --degrees[next];
                if (degrees[next] == 0) {
                    q.offer(next);
                }
            }
        }
        return idx == n;
    }
}
