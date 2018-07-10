package com.github.leetcode.easy;

/**
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the
 * same element.
 * 
 * Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]] 
 * Output: True Explanation:
 * 1234 5123 9512
 * 
 * In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2,
 * 2]", "[3, 3]", "[4]", and in each diagonal all elements are the same, so the
 * answer is True. 
 * 
 * Example 2:
 * 
 * Input: matrix = [[1,2],[2,2]] Output: False Explanation: The diagonal "[1,
 * 2]" has different elements.
 * 
 * @author liuzhongda
 *
 */
public class Leetcode766 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public static boolean isToeplitzMatrix(int[][] matrix) {
		if (matrix.length > 20 || matrix[0].length > 20) {
			System.out.println("the length of matrix could not larger than 20");
			return false;
		} else {
			int m = matrix.length;
			int n = matrix[0].length;
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (matrix[i][j] != matrix[i + 1][j + 1]) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
