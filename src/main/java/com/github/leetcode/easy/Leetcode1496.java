package com.github.leetcode.easy;

import java.util.*;

/**
 * @Author: zerongliu
 * @Date: 11/7/20 20:59
 * @Description: Given a string path, where path[i] = 'N', 'S', 'E' or 'W', each representing moving one unit north, south, east, or west, respectively. You start at the origin (0, 0) on a 2D plane and walk on the path specified by path.
 * <p>
 * Return True if the path crosses itself at any point, that is, if at any time you are on a location you've previously visited. Return False otherwise.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: path = "NES"
 * Output: false
 * Explanation: Notice that the path doesn't cross any point more than once.
 * Example 2:
 * <p>
 * <p>
 * <p>
 * Input: path = "NESWW"
 * Output: true
 * Explanation: Notice that the path visits the origin twice.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= path.length <= 10^4
 * path will only consist of characters in {'N', 'S', 'E', 'W}
 */
public class Leetcode1496 {
    class Coordinate {
        int x;
        int y;

        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object other) {
            Coordinate otherObj = (Coordinate) other;
            return this.x == otherObj.x && this.y == otherObj.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    public boolean isPathCrossing(String path) {
        Map<Character, Coordinate> map = new HashMap<>();
        map.put('N', new Coordinate(1, 0));
        map.put('S', new Coordinate(-1, 0));
        map.put('E', new Coordinate(0, 1));
        map.put('W', new Coordinate(0, -1));
        Set<Coordinate> set = new HashSet<>();
        Coordinate cur = new Coordinate(0, 0);
        set.add(cur);
        for (char c : path.toCharArray()) {
            cur.x += map.get(c).x;
            cur.y += map.get(c).y;
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
        }
        return false;
    }
}
