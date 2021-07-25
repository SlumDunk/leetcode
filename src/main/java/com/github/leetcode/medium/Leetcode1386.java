package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * A cinema has n rows of seats, numbered from 1 to n and there are ten seats in each row, labelled from 1 to 10 as shown in the figure above.
 * <p>
 * Given the array reservedSeats containing the numbers of seats already reserved, for example, reservedSeats[i] = [3,8] means the seat located in row 3 and labelled with 8 is already reserved.
 * <p>
 * Return the maximum number of four-person groups you can assign on the cinema seats. A four-person group occupies four adjacent seats in one single row. Seats across an aisle (such as [3,3] and [3,4]) are not considered to be adjacent, but there is an exceptional case on which an aisle split a four-person group, in that case, the aisle split a four-person group in the middle, which means to have two people on each side.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * <p>
 * Input: n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]
 * Output: 4
 * Explanation: The figure above shows the optimal allocation for four groups, where seats mark with blue are already reserved and contiguous seats mark with orange are for one group.
 * Example 2:
 * <p>
 * Input: n = 2, reservedSeats = [[2,1],[1,8],[2,6]]
 * Output: 2
 * Example 3:
 * <p>
 * Input: n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]
 * Output: 4
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 10^9
 * 1 <= reservedSeats.length <= min(10*n, 10^4)
 * reservedSeats[i].length == 2
 * 1 <= reservedSeats[i][0] <= n
 * 1 <= reservedSeats[i][1] <= 10
 * All reservedSeats[i] are distinct.
 */
public class Leetcode1386 {
    int cols = 10;

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // 2, 3, 4, 5
        // 4, 5, 6, 7
        // 6, 7, 8, 9
        Set<Integer> occupiedSeats = new HashSet<>();
        for (int[] reservedSeat :
                reservedSeats) {
            occupiedSeats.add(reservedSeat[0] * cols + reservedSeat[1]);
        }
        int ans = 0;

        for (int i = 1; i <= n; i++) {
            boolean flag1 = false;
            boolean flag2 = false;

            Integer seat2 = i * cols + 2;
            Integer seat3 = i * cols + 3;
            Integer seat4 = i * cols + 4;
            Integer seat5 = i * cols + 5;
            Integer seat6 = i * cols + 6;
            Integer seat7 = i * cols + 7;
            Integer seat8 = i * cols + 8;
            Integer seat9 = i * cols + 9;

            if (!occupiedSeats.contains(seat2) && !occupiedSeats.contains(seat3) && !occupiedSeats.contains(seat4) && !occupiedSeats.contains(5)) {
                ans++;
                flag1 = true;
            }
            if (!flag1 && !occupiedSeats.contains(seat4) && !occupiedSeats.contains(seat5) && !occupiedSeats.contains(seat6) && !occupiedSeats.contains(7)) {
                ans++;
                flag2 = true;
            }
            if (!flag2 && !occupiedSeats.contains(seat6) && !occupiedSeats.contains(seat7) && !occupiedSeats.contains(seat8) && !occupiedSeats.contains(9)) {
                ans++;
            }
        }
        return ans;
    }

    public int maxNumberOfFamilies2(int n, int[][] reservedSeats) {
        Map<Integer, Integer> graph = new HashMap<>();
        for (int i = 0; i < reservedSeats.length; i++) {
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];

            graph.put(row, graph.getOrDefault(row, 0) | (1 << (col - 1)));
        }
        int max = 0;
        for (int row :
                graph.keySet()) {
            int reserved = graph.get(row);
            int cnt = 0;
            if ((reserved & 30) == 0) cnt += 1;
            if ((reserved & 480) == 0) cnt += 1;
            if (((reserved & 120) == 0) && cnt == 0) cnt += 1;
            max += cnt;
        }

        return max + 2 * (n - graph.size());
    }
}
