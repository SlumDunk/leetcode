package com.github.interview.wepay;

/**
 * @Author: zerongliu
 * @Date: 10/24/19 14:31
 * @Description:
 */
public class Wepay53 {

    static int maxSumWithK(int a[], int n, int k) {
        // the maximum subarray end with element a[i]
        int[] maxSum = new int[n];
        maxSum[0] = a[0];

        int curSum = a[0];
        for (int i = 1; i < n; i++) {
            curSum = Math.max(curSum + a[i], a[i]);
            maxSum[i] = curSum;
        }

        //maintain a window with size of k
        //sum of first size of k elements
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += a[i];
        }
        int result = sum;

        for (int i = k; i < n; i++) {
            sum = sum + a[i] - a[i - k];
            result = Math.max(result, sum);

            //check element a[i-k] can contribute to sum or not
            result = Math.max(result, sum + maxSum[i - k]);
        }

        return result;
    }

    // Driver method
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, -10, -3};
        int k = 4;
        System.out.println(maxSumWithK(arr, arr.length, k));
    }
}
