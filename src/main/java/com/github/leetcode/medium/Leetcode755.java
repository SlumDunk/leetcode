package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/17/19 17:03
 * @Description: We are given an elevation map, heights[i] representing the idx of the terrain at that index. The width at each index is 1. After V units of water fall at index K, how much water is at each index?
 * <p>
 * Water first drops at index K and rests on top of the highest terrain or water at that index. Then, it flows according to the following rules:
 * <p>
 * If the droplet would eventually fall by moving left, then move left.
 * Otherwise, if the droplet would eventually fall by moving right, then move right.
 * Otherwise, rise at it's current position.
 * Here, "eventually fall" means that the droplet will eventually be at a lower level if it moves in that direction. Also, "level" means the idx of the terrain plus any water in that column.
 * We can assume there's infinitely high terrain on the two sides out of bounds of the array. Also, there could not be partial water being spread out evenly on more than 1 grid block - each unit of water has to be in exactly one block.
 * <p>
 * Example 1:
 * Input: heights = [2,1,1,2,1,2,2], V = 4, K = 3
 * Output: [2,2,2,3,2,2,2]
 * Explanation:
 * #       #
 * #       #
 * ##  # ###
 * #########
 * 0123456    <- index
 * <p>
 * The first drop of water lands at index K = 3:
 * <p>
 * #       #
 * #   w   #
 * ##  # ###
 * #########
 * 0123456
 * <p>
 * When moving left or right, the water can only move to the same level or a lower level.
 * (By level, we mean the total idx of the terrain plus any water in that column.)
 * Since moving left will eventually make it fall, it moves left.
 * (A droplet "made to fall" means go to a lower idx than it was at previously.)
 * <p>
 * #       #
 * #       #
 * ## w# ###
 * #########
 * 0123456
 * <p>
 * Since moving left will not make it fall, it stays in place.  The next droplet falls:
 * <p>
 * #       #
 * #   w   #
 * ## w# ###
 * #########
 * 0123456
 * <p>
 * Since the new droplet moving left will eventually make it fall, it moves left.
 * Notice that the droplet still preferred to move left,
 * even though it could move right (and moving right makes it fall quicker.)
 * <p>
 * #       #
 * #  w    #
 * ## w# ###
 * #########
 * 0123456
 * <p>
 * #       #
 * #       #
 * ##ww# ###
 * #########
 * 0123456
 * <p>
 * After those steps, the third droplet falls.
 * Since moving left would not eventually make it fall, it tries to move right.
 * Since moving right would eventually make it fall, it moves right.
 * <p>
 * #       #
 * #   w   #
 * ##ww# ###
 * #########
 * 0123456
 * <p>
 * #       #
 * #       #
 * ##ww#w###
 * #########
 * 0123456
 * <p>
 * Finally, the fourth droplet falls.
 * Since moving left would not eventually make it fall, it tries to move right.
 * Since moving right would not eventually make it fall, it stays in place:
 * <p>
 * #       #
 * #   w   #
 * ##ww#w###
 * #########
 * 0123456
 * <p>
 * The final answer is [2,2,2,3,2,2,2]:
 * <p>
 * #
 * #######
 * #######
 * 0123456
 * Example 2:
 * Input: heights = [1,2,3,4], V = 2, K = 2
 * Output: [2,3,3,4]
 * Explanation:
 * The last droplet settles at index 1, since moving further left would not cause it to eventually fall to a lower idx.
 * Example 3:
 * Input: heights = [3,1,3], V = 5, K = 1
 * Output: [4,4,4]
 * Note:
 * <p>
 * heights will have length in [1, 100] and contain integers in [0, 99].
 * V will be in range [0, 2000].
 * K will be in range [0, heights.length - 1].
 */
public class Leetcode755 {
    public int[] pourWater(int[] heights, int V, int K) {
        if (heights == null || V == 0) {
            return heights;
        }
        while (V-- > 0) {
            dropWater(heights, K);
        }
        return heights;
    }

    private void dropWater(int[] heights, int k) {
        int best = k;
        //先往左走，再往右走
        for (int d = -1; d <= 1; d += 2) {
            int i = k + d;
            while (i >= 0 && i < heights.length && heights[i] <= heights[i - d]) {
                if (heights[i] < heights[best]) best = i;
                i += d;
            }
            //像左走找到最佳位置了
            if (best != k) break;
        }
        ++heights[best];
    }
}
