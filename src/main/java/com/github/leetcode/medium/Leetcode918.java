package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 3/23/19 16:58
 * @Description: Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * <p>
 * Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i] when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 * <p>
 * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 * Example 2:
 * <p>
 * Input: [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 * Example 3:
 * <p>
 * Input: [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 * Example 4:
 * <p>
 * Input: [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 * Example 5:
 * <p>
 * Input: [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 * <p>
 * <p>
 * Note:
 * <p>
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 */
public class Leetcode918 {
    /**
     * Intuition
     * I guess you know how to solve max subarray sum (without circular).
     * If not, you can have a reference here: 53. Maximum Subarray
     * <p>
     * <p>
     * Explanation
     * So there are two case.
     * <p>
     * The first is that the subarray take only a middle part, and we know how to find the max subarray sum.
     * The second is that the subarray take a part of head array and a part of tail array.
     * We can transfer this case to the first one.
     * The maximum result equals to the total sum minus the minimum subarray sum.
     * <p>
     * Here is a diagram by @motorix:
     * image
     * <p>
     * So the max subarray circular sum equals to
     * max(the max subarray sum, the total sum - the min subarray sum)
     * <p>
     * <p>
     * Corner case
     * Just one to pay attention:
     * If all numbers are negative, maxSum = max(A) and minSum = sum(A).
     * In this case, max(maxSum, total - minSum) = 0, which means the sum of an empty subarray.
     * According to the deacription, We need to return the max(A), instead of sum of am empty subarray.
     * So we return the maxSum to handle this corner case.
     * <p>
     * <p>
     * Complexity
     * One pass, time O(N)
     * No extra space, space O(1)
     *
     * @param A
     * @return
     */
    public int maxSubarraySumCircular(int[] A) {
        int total = 0, maxSum = -30000, curMax = 0, minSum = 30000, curMin = 0;
        for (int a :
                A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
