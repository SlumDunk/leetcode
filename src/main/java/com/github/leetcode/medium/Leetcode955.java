package com.github.leetcode.medium;

import java.util.Arrays;

/**
 * @Author: zerongliu
 * @Date: 7/2/19 16:17
 * @Description: We are given an array A of N lowercase letter strings, all of the same length.
 * <p>
 * Now, we may choose any set of deletion indices, and for each string, we delete all the characters in those indices.
 * <p>
 * For example, if we have an array A = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef","vyz"].
 * <p>
 * Suppose we chose a set of deletion indices D such that after deletions, the final array has its elements in lexicographic order (A[0] <= A[1] <= A[2] ... <= A[A.length - 1]).
 * <p>
 * Return the minimum possible value of D.length.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["ca","bb","ac"]
 * Output: 1
 * Explanation:
 * After deleting the first column, A = ["a", "b", "c"].
 * Now A is in lexicographic order (ie. A[0] <= A[1] <= A[2]).
 * We require at least 1 deletion since initially A was not in lexicographic order, so the answer is 1.
 * Example 2:
 * <p>
 * Input: ["xc","yb","za"]
 * Output: 0
 * Explanation:
 * A is already in lexicographic order, so we don't need to delete anything.
 * Note that the rows of A are not necessarily in lexicographic order:
 * ie. it is NOT necessarily true that (A[0][0] <= A[0][1] <= ...)
 * Example 3:
 * <p>
 * Input: ["zyx","wvu","tsr"]
 * Output: 3
 * Explanation:
 * We have to delete every column.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 */
public class Leetcode955 {
    public int minDeletionSize(String[] A) {
        if (A.length == 0) return 0;
        int strSize = A[0].length();
        int count = 0;
    /*use int array to record the status of adjacent characters cj - 1 and cj. If cj - 1 is equal
    to cj, status[j] is equal to 0, if cj - 1 is smaller than cj, status[j] is equal to 1.*/
        int[] status = new int[A.length];
        for (int i = 0; i < strSize; i++) {
            //if we found 2 adjacent characters where the first one is larger than the second one
            boolean hasLarge = false;
            //复制上一状态
            int[] tempStatus = Arrays.copyOf(status, status.length);
            for (int j = 1; j < A.length; j++) {
                //已经是有序的了
                if (status[j] == 1) continue;
                char c1 = A[j - 1].charAt(i);
                char c2 = A[j].charAt(i);
                //前一个单词的当前字符比后一个大，需要删除
                if (c1 > c2) {
                    hasLarge = true;
                    count++;
                    break;
                } else if (c1 < c2) {//前后单词有序
                    tempStatus[j] = 1;
                }
            }
            //需要删除，这一列的更新状态不考虑
            if (!hasLarge) status = tempStatus;
        }
        return count;
    }
}
