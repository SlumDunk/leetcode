package com.github.leetcode.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 14:44
 * @Description: In a social group, there are N people, with unique integer ids from 0 to N-1.
 * <p>
 * We have a list of logs, where each logs[i] = [timestamp, id_A, id_B] contains a non-negative integer timestamp, and the ids of two different people.
 * <p>
 * Each log represents the time in which two different people became friends.  Friendship is symmetric: if A is friends with B, then B is friends with A.
 * <p>
 * Let's say that person A is acquainted with person B if A is friends with B, or A is a friend of someone acquainted with B.
 * <p>
 * Return the earliest time for which every person became acquainted with every other person. Return -1 if there is no such earliest time.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = [[20190101,0,1],[20190104,3,4],[20190107,2,3],[20190211,1,5],[20190224,2,4],[20190301,0,3],[20190312,1,2],[20190322,4,5]], N = 6
 * Output: 20190301
 * Explanation:
 * The first event occurs at timestamp = 20190101 and after 0 and 1 become friends we have the following friendship groups [0,1], [2], [3], [4], [5].
 * The second event occurs at timestamp = 20190104 and after 3 and 4 become friends we have the following friendship groups [0,1], [2], [3,4], [5].
 * The third event occurs at timestamp = 20190107 and after 2 and 3 become friends we have the following friendship groups [0,1], [2,3,4], [5].
 * The fourth event occurs at timestamp = 20190211 and after 1 and 5 become friends we have the following friendship groups [0,1,5], [2,3,4].
 * The fifth event occurs at timestamp = 20190224 and as 2 and 4 are already friend anything happens.
 * The sixth event occurs at timestamp = 20190301 and after 0 and 3 become friends we have that all become friends.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 100
 * 1 <= logs.length <= 10^4
 * 0 <= logs[i][0] <= 10^9
 * 0 <= logs[i][1], logs[i][2] <= N - 1
 * It's guaranteed that all timestamps in logs[i][0] are different.
 * Logs are not necessarily ordered by some criteria.
 * logs[i][1] != logs[i][2]
 */
public class Leetcode1101 {
    public int earliestAcq(int[][] logs, int N) {
        int[] parent = IntStream.range(0, N).toArray();
        //全部互相认识的最早时间， 不认识的人数
        int time = -1, cnt = N;
        //按时间升序排列
        Arrays.sort(logs, (a, b) -> a[0] - b[0]);
        for (int[] log : logs) {
            int t = log[0], a = log[1], b = log[2];
            int A = root(a, parent), B = root(b, parent);
            //合并
            if (A != B) {
                parent[A] = B;
                time = t;
                cnt--;
            }
        }
        return cnt == 1 ? time : -1;
    }

    /**
     * 寻找祖宗节点
     *
     * @param a
     * @param parent
     * @return
     */
    public int root(int a, int[] parent) {
        return parent[a] == a ? a : root(parent[a], parent);
    }
}
