package com.github.leetcode.hard;

import java.util.*;

public class Leetcode1298 {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int ans = 0;
        Queue<Integer> openBoxQueue = new LinkedList<>();
        Set<Integer> closedBoxes = new HashSet<>();
        Set<Integer> visitedBoxes = new HashSet<>();

        for (int i = 0; i < initialBoxes.length; i++) {
            int box = initialBoxes[i];
            if (status[box] == 1) {
                openBoxQueue.offer(box);
            } else {
                closedBoxes.add(box);
            }
        }

        while (!openBoxQueue.isEmpty()) {
            int openedBox = openBoxQueue.poll();
            ans += candies[openedBox];
            int[] foundKeys = keys[openedBox];
            for (int foundKey :
                    foundKeys) {
                status[foundKey] = 1;
            }
            int[] foundBoxes = containedBoxes[openedBox];
            for (int foundBox :
                    foundBoxes) {
                if (visitedBoxes.contains(foundBox)) {
                    continue;
                }
                if (status[foundBox] == 1) {
                    openBoxQueue.offer(foundBox);
                } else {
                    closedBoxes.add(foundBox);
                }
            }
            List<Integer> boxToBeOpened=new ArrayList<>();
            // 可能原来没钥匙，现在有了
            for (int closedBox :
                    closedBoxes) {
                if(status[closedBox]==1) {
                    boxToBeOpened.add(closedBox);
                    openBoxQueue.offer(closedBox);
                }
            }

            closedBoxes.removeAll(boxToBeOpened);
            visitedBoxes.add(openedBox);
        }
        return ans;
    }
}
