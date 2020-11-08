package com.github.leetcode.easy;

/**
 * @Author: zerongliu
 * @Date: 11/1/20 19:21
 * @Description: Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
 * <p>
 * Return the number of cells with odd values in the matrix after applying the increment to all indices.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: n = 2, m = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 * After applying first increment it becomes [[1,2,1],[0,1,0]].
 * The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
 * Example 2:
 * <p>
 * <p>
 * Input: n = 2, m = 2, indices = [[1,1],[0,0]]
 * Output: 0
 * Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 50
 * 1 <= m <= 50
 * 1 <= indices.length <= 100
 * 0 <= indices[i][0] < n
 * 0 <= indices[i][1] < m
 */
public class Leetcode1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix=new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            for (int j = 0; j < 2; j++) {
                if(j==0){
                    //处理的是行
                    for (int k = 0; k < m; k++) {
                        matrix[indices[i][j]][k]++;
                    }
                }else{
                    //处理的是列
                    for (int k = 0; k < n; k++) {
                        matrix[k][indices[i][j]]++;
                    }
                }
            }
        }
        int ans=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]%2==1){
                    ans++;
                }
            }
        }
        return ans;
    }
}
