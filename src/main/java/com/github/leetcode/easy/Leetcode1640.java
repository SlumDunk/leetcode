package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/3/20 15:31
 * @Description: You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].
 * <p>
 * Return true if it is possible to form the array arr from pieces. Otherwise, return false.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr = [85], pieces = [[85]]
 * Output: true
 * Example 2:
 * <p>
 * Input: arr = [15,88], pieces = [[88],[15]]
 * Output: true
 * Explanation: Concatenate [15] then [88]
 * Example 3:
 * <p>
 * Input: arr = [49,18,16], pieces = [[16,18,49]]
 * Output: false
 * Explanation: Even though the numbers match, we cannot reorder pieces[0].
 * Example 4:
 * <p>
 * Input: arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
 * Output: true
 * Explanation: Concatenate [91] then [4,64] then [78]
 * Example 5:
 * <p>
 * Input: arr = [1,3,5,7], pieces = [[2,4,6,8]]
 * Output: false
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= pieces.length <= arr.length <= 100
 * sum(pieces[i].length) == arr.length
 * 1 <= pieces[i].length <= arr.length
 * 1 <= arr[i], pieces[i][j] <= 100
 * The integers in arr are distinct.
 * The integers in pieces are distinct (i.e., If we flatten pieces in a 1D array, all the integers in this array are distinct).
 */
public class Leetcode1640 {
    public static void main(String[] args) {
        Leetcode1640 leetcode1640 = new Leetcode1640();
        int[] arr = {1, 2, 3};
        int[][] pieces = {{2}, {1, 3}};
        leetcode1640.canFormArray(arr, pieces);
    }

    public boolean canFormArray(int[] arr, int[][] pieces) {
        StringBuilder buffer = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
            buffer.append(arr[i]);
            buffer.append(",");
        }

        int m = pieces.length;

        for (int i = 0; i < m; i++) {
            StringBuilder subBuffer = new StringBuilder("");
            int n = pieces[i].length;
            for (int j = 0; j < n; j++) {
                subBuffer.append(pieces[i][j]);
                subBuffer.append(",");
            }
            if (buffer.indexOf(subBuffer.toString()) == -1) {
                return false;
            }
        }
        return true;
    }
}
