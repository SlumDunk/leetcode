package com.github.leetcode.medium;

import java.util.TreeMap;

/**
 * @Author: zerongliu
 * @Date: 5/25/19 22:28
 * @Description: In an election, the i-th vote was cast for persons[i] at time times[i].
 * <p>
 * Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.
 * <p>
 * Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
 * Output: [null,0,1,1,0,0,1]
 * Explanation:
 * At time 3, the votes are [0], and 0 is leading.
 * At time 12, the votes are [0,1,1], and 1 is leading.
 * At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
 * This continues for 3 more queries at time 15, 24, and 8.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= persons.length = times.length <= 5000
 * 0 <= persons[i] <= persons.length
 * times is a strictly increasing array with all elements in [0, 10^9].
 * TopVotedCandidate.q is called at most 10000 times per test case.
 * TopVotedCandidate.q(int t) is always called with t >= times[0].
 */
public class Leetcode911 {
    class TopVotedCandidate {
        TreeMap<Integer, Integer> timeWinner = new TreeMap<>();

        public TopVotedCandidate(int[] persons, int[] times) {
            int maxPerson = persons[0], maxVotes = 0;
            int[] votes = new int[persons.length];
            for (int i = 0; i < persons.length; i++) {
                votes[persons[i]]++;
                if (votes[persons[i]] >= maxVotes) {
                    maxVotes = votes[persons[i]];
                    maxPerson = persons[i];
                }
                timeWinner.put(times[i], maxPerson);
            }
        }

        public int q(int t) {
            return timeWinner.get(timeWinner.floorKey(t));
        }
    }
}
