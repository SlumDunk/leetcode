package com.github.leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 21:30
 * @Description: There are N rooms and you start in room 0.  Each room has a distinct number in 0, 1, 2, ..., N-1, and each room may have some keys to access the next room.
 * <p>
 * Formally, each room i has a list of keys rooms[i], and each key rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.  A key rooms[i][j] = v opens the room with number v.
 * <p>
 * Initially, all the rooms start locked (except for room 0).
 * <p>
 * You can walk back and forth between rooms freely.
 * <p>
 * Return true if and only if you can enter every room.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1],[2],[3],[]]
 * Output: true
 * Explanation:
 * We start in room 0, and pick up key 1.
 * We then go to room 1, and pick up key 2.
 * We then go to room 2, and pick up key 3.
 * We then go to room 3.  Since we were able to go to every room, we return true.
 * Example 2:
 * <p>
 * Input: [[1,3],[3,0,1],[2],[0]]
 * Output: false
 * Explanation: We can't enter the room with number 2.
 * Note:
 * <p>
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * The number of keys in all rooms combined is at most 3000.
 */
public class Leetcode841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        if (rooms == null)
            return true;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        visited[0] = true;
        for (int r : rooms.get(0)) {
            q.add(r);
            visited[r] = true;
        }

        while (!q.isEmpty()) {
            int r = q.poll();
            for (int x : rooms.get(r)) {
                if (visited[x] != true) {
                    q.add(x);
                    visited[x] = true;
                }
            }
        }
        //检查还有没访问的房间没
        for (int i = 0; i < n; i++) {
            if (visited[i] != true)
                return false;
        }
        return true;
    }
}
