package com.github.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zerongliu
 * @Date: 7/1/19 22:07
 * @Description: Given a matrix consisting of 0s and 1s, we may choose any number of columns in the matrix and flip every cell in that column.  Flipping a cell changes the value of that cell from 0 to 1 or from 1 to 0.
 * <p>
 * Return the maximum number of rows that have all values equal after some number of flips.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[0,1],[1,1]]
 * Output: 1
 * Explanation: After flipping no values, 1 row has all values equal.
 * Example 2:
 * <p>
 * Input: [[0,1],[1,0]]
 * Output: 2
 * Explanation: After flipping values in the first column, both rows have equal values.
 * Example 3:
 * <p>
 * Input: [[0,0,0],[0,0,1],[1,1,0]]
 * Output: 2
 * Explanation: After flipping values in the first two columns, the last two rows have equal values.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= matrix.length <= 300
 * 1 <= matrix[i].length <= 300
 * All matrix[i].length's are equal
 * matrix[i][j] is 0 or 1
 */
public class Leetcode1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < matrix[0].length; ++j)
                //相对位置
                sb.append((matrix[i][j] + matrix[i][0]) % 2);
            String pattern = sb.toString();
            map.put(pattern, map.getOrDefault(pattern, 0) + 1);
            max = Math.max(max, map.get(pattern));
        }
        return max;
    }
}
