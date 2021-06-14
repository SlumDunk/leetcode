package com.github.leetcode.medium;

import java.util.*;

/**
 * Design a Leaderboard class, which has 3 functions:
 * <p>
 * addScore(playerId, score): Update the leaderboard by adding score to the given player's score. If there is no player with such id in the leaderboard, add him to the leaderboard with the given score.
 * top(K): Return the score sum of the top K players.
 * reset(playerId): Reset the score of the player with the given id to 0 (in other words erase it from the leaderboard). It is guaranteed that the player was added to the leaderboard before calling this function.
 * Initially, the leaderboard is empty.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["Leaderboard","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","top"]
 * [[],[1,73],[2,56],[3,39],[4,51],[5,4],[1],[1],[2],[2,51],[3]]
 * Output:
 * [null,null,null,null,null,null,73,null,null,null,141]
 * <p>
 * Explanation:
 * Leaderboard leaderboard = new Leaderboard ();
 * leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
 * leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
 * leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
 * leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
 * leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
 * leaderboard.top(1);           // returns 73;
 * leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
 * leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
 * leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
 * leaderboard.top(3);           // returns 141 = 51 + 51 + 39;
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= playerId, K <= 10000
 * It's guaranteed that K is less than or equal to the current number of players.
 * 1 <= score <= 100
 * There will be at most 1000 function calls.
 */
public class Leetcode1244 {
    class Leaderboard {
        class Pair {
            int playerId;
            int score;

            public Pair(int playerId, int score) {
                this.playerId = playerId;
                this.score = score;
            }
        }

        Map<Integer, Pair> playerScoreMap = new HashMap<>();
        Queue<Pair> maxHeap = new PriorityQueue<Pair>((a, b) -> Integer.compare(b.score, a.score));

        public Leaderboard() {

        }

        public void addScore(int playerId, int score) {
            if (playerScoreMap.containsKey(playerId)) {
                Pair playerScorePair = playerScoreMap.get(playerId);
                maxHeap.remove(playerScorePair);
                playerScorePair.score += score;
                playerScoreMap.put(playerId, playerScorePair);
                maxHeap.offer(playerScorePair);
            } else {
                Pair playerScorePair = new Pair(playerId, score);
                playerScoreMap.put(playerId, playerScorePair);
                maxHeap.offer(playerScorePair);
            }
        }

        public int top(int K) {
            int sum = 0;
            List<Pair> tempList = new ArrayList<>();
            while (K > 0 && maxHeap.size() > 0) {
                Pair pair = maxHeap.poll();
                sum += pair.score;
                K--;
                tempList.add(pair);
            }
            maxHeap.addAll(tempList);
            return sum;
        }

        public void reset(int playerId) {
            Pair playerScorePair = playerScoreMap.remove(playerId);
            maxHeap.remove(playerScorePair);
        }
    }
}
