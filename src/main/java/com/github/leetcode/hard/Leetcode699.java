package com.github.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 6/22/19 15:45
 * @Description: On an infinite number line (x-axis), we drop given squares in the order they are given.
 * <p>
 * The i-th square dropped (positions[i] = (left, side_length)) is a square with the left-most point being positions[i][0] and sidelength positions[i][1].
 * <p>
 * The square is dropped with the bottom edge parallel to the number line, and from a higher height than all currently landed squares. We wait for each square to stick before dropping the next.
 * <p>
 * The squares are infinitely sticky on their bottom edge, and will remain fixed to any positive length surface they touch (either the number line or another square). Squares dropped adjacent to each other will not stick together prematurely.
 * <p>
 * <p>
 * Return a list ans of heights. Each height ans[i] represents the current highest height of any square we have dropped, after dropping squares represented by positions[0], positions[1], ..., positions[i].
 * <p>
 * Example 1:
 * <p>
 * Input: [[1, 2], [2, 3], [6, 1]]
 * Output: [2, 5, 5]
 * Explanation:
 * After the first drop of positions[0] = [1, 2]: _aa _aa ------- The maximum height of any square is 2.
 * <p>
 * After the second drop of positions[1] = [2, 3]: __aaa __aaa __aaa _aa__ _aa__ -------------- The maximum height of any square is 5. The larger square stays on top of the smaller square despite where its center of gravity is, because squares are infinitely sticky on their bottom edge.
 * <p>
 * After the third drop of positions[1] = [6, 1]: __aaa __aaa __aaa _aa _aa___a -------------- The maximum height of any square is still 5. Thus, we return an answer of [2, 5, 5].
 * <p>
 * <p>
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: [[100, 100], [200, 100]]
 * Output: [100, 100]
 * Explanation: Adjacent squares don't get stuck prematurely - only their bottom edge can stick to surfaces.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= positions.length <= 1000.
 * 1 <= positions[i][0] <= 10^8.
 * 1 <= positions[i][1] <= 10^6.
 */
public class Leetcode699 {
    int max = Integer.MIN_VALUE;

    public List<Integer> fallingSquares(int[][] positions) {
        List<int[]> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        for (int[] s : positions) {
            int[] node = new int[]{s[0], s[0] + s[1], s[1]};
            ans.add(getMax(list, node));
        }
        return ans;
    }

    /**
     * 返回增加方块后的最大高度
     *
     * @param list
     * @param node node[0]开始位置 node[1]结束位置 node[2]增加的高度
     * @return
     */
    private int getMax(List<int[]> list, int[] node) {
        int height = 0;
        for (int[] e : list) {
            //没有交集，直接跳过
            if (e[0] >= node[1] || e[1] <= node[0]) continue;
            height = Math.max(height, e[2]);
        }
        node[2] += height;
        list.add(node);
        max = Math.max(max, node[2]);
        return max;
    }
}
