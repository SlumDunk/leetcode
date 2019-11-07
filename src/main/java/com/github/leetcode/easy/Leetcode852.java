package com.github.leetcode.easy;

/**
 * Let's call an array A a mountain if the following properties hold:
 * <p>
 * A.length >= 3
 * There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * Given an array that is definitely a mountain, return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
 * <p>
 * Example 1:
 * <p>
 * Input: [0,1,0]
 * Output: 1
 * Example 2:
 * <p>
 * Input: [0,2,1,0]
 * Output: 1
 */
public class Leetcode852 {
    public static void main(String[] args) {

    }

    public static int peakIndexInMountainArray(int[] A) {
        //二分查找
        int left = 0, right = A.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (A[mid + 1] > A[mid]) {//在peak点左侧
                left = mid + 1;
            } else {//在peak点右侧，包含peak点
                right = mid;
            }
        }
        return left;
    }


    public int peakIndexInMountainArray__(int[] A) {
        int n = A.length;
        int start = 0, end = n - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] > A[mid - 1]) {//上升边
                start = mid;
            } else if (A[mid] > A[mid + 1]) {//下降边
                end = mid;
            } else {
                end = mid;
            }
        }

        if (A[start] >= A[end]) {
            return start;
        } else {
            return end;
        }
    }
}

