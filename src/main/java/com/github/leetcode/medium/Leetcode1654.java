package com.github.leetcode.medium;

import java.util.*;

/**
 * A certain bug's home is on the x-axis at position x. Help them get there from position 0.
 * <p>
 * The bug jumps according to the following rules:
 * <p>
 * It can jump exactly a positions forward (to the right).
 * It can jump exactly b positions backward (to the left).
 * It cannot jump backward twice in a row.
 * It cannot jump to any forbidden positions.
 * The bug may jump forward beyond its home, but it cannot jump to positions numbered with negative integers.
 * <p>
 * Given an array of integers forbidden, where forbidden[i] means that the bug cannot jump to the position forbidden[i], and integers a, b, and x, return the minimum number of jumps needed for the bug to reach its home. If there is no possible sequence of jumps that lands the bug on position x, return -1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: forbidden = [14,4,18,1,15], a = 3, b = 15, x = 9
 * Output: 3
 * Explanation: 3 jumps forward (0 -> 3 -> 6 -> 9) will get the bug home.
 * Example 2:
 * <p>
 * Input: forbidden = [8,3,16,6,12,20], a = 15, b = 13, x = 11
 * Output: -1
 * Example 3:
 * <p>
 * Input: forbidden = [1,6,2,14,5,17,4], a = 16, b = 9, x = 7
 * Output: 2
 * Explanation: One jump forward (0 -> 16) then one jump backward (16 -> 7) will get the bug home.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= forbidden.length <= 1000
 * 1 <= a, b, forbidden[i] <= 2000
 * 0 <= x <= 2000
 * All the elements in forbidden are distinct.
 * Position x is not forbidden.
 */
public class Leetcode1654 {

    class Pair {
        int val;
        int lastJumpDirection;

        public Pair(int val, int lastJumpDirection) {
            this.val = val;
            this.lastJumpDirection = lastJumpDirection;
        }
    }

    /**
     * BFS
     * https://www.youtube.com/watch?v=hn7k3udp2_8
     *
     * @param forbidden
     * @param a
     * @param b
     * @param x
     * @return
     */
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int val :
                forbidden) {
            forbiddenSet.add(val);
        }

        Queue<int[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new int[]{0, 0, 1});    // currentPosition, cost, canJumpBack
        visited.add("0,1");

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] t = queue.poll();
                int pos = t[0];
                int cost = t[1];
                int canJumpBack = t[2];

                if (pos == x) return cost;
                if (pos > 6000) continue;

                String forwardKey = (pos + a) + "," + 0;
                String backwardKey = (pos - b) + "," + 1;

                int next = pos + a;
                int prev = pos - b;

                if (!forbiddenSet.contains(next)) {
                    queue.offer(new int[]{next, cost + 1, 1});
                    visited.add(forwardKey);
                }

                if (!forbiddenSet.contains(prev) && prev >= 0 && canJumpBack == 1 && !visited.contains(backwardKey)) {
                    queue.offer(new int[]{prev, cost + 1, 0});
                    visited.add(backwardKey);
                }
            }
        }
        return -1;
    }

    class Position {
        int x;
        int step;
        boolean backward;

        public Position(int x, int step, boolean backward) {
            this.x = x;
            this.step = step;
            this.backward = backward;
        }
    }

    public class Solution {

        public int minimumJumps(int[] forbidden, int a, int b, int x) {

            if (x == 0) {
                return 0;
            }

            Set<Integer> forbiddenSet = new HashSet<>();

            for (int i = 0; i < forbidden.length; i++) {
                forbiddenSet.add(forbidden[i]);
            }

            Set<Integer> visited = new HashSet<>();

            visited.add(0);

            Queue<Position> q = new LinkedList<>();

            if (!forbiddenSet.contains(a)) {
                q.add(new Position(a, 1, false));
            }

            while (!q.isEmpty()) {

                Position position = q.remove();

                if (position.x == x) {
                    return position.step;
                }

                if (position.x + a <= 6000 && !forbiddenSet.contains(position.x + a)
                        && !visited.contains(position.x + a)) {
                    q.add(new Position(position.x + a, position.step + 1, false));
                    visited.add(position.x + a);
                }

                if (position.x - b > 0 && !position.backward && !forbiddenSet.contains(position.x - b)
                        && !visited.contains(position.x - b)) {
                    q.add(new Position(position.x - b, position.step + 1, true));
                }
            }

            return -1;
        }
    }
}
