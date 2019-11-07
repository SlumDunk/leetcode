package com.github.lintcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/27/19 09:10
 * @Description: Given an integer array, heapify it into a min-heap array.
 * <p>
 * For a heap array A, A[0] is the root of heap, and for each A[i], A[i * 2 + 1] is the left child of A[i] and A[i * 2 + 2] is the right child of A[i].
 * Example
 * Given [3,2,1,4,5], return [1,2,3,4,5] or any legal heap array.
 * <p>
 * Challenge
 * O(n) time complexity
 * <p>
 * Clarification
 * What is heap?
 * <p>
 * Heap is a data structure, which usually have three methods: push, pop and top. where "push" add a new element the heap, "pop" delete the minimum/maximum element in the heap, "top" return the minimum/maximum element.
 * <p>
 * What is heapify?
 * Convert an unordered integer array into a heap array. If it is min-heap, for each element A[i], we will get A[i * 2 + 1] >= A[i] and A[i * 2 + 2] >= A[i].
 * <p>
 * What if there is a lot of solutions?
 * Return any of them.
 */
public class Lintcode130 {
    /*
    https://www.geeksforgeeks.org/time-complexity-of-building-a-heap/
    O(n)
     * @param A: Given an integer array
     * @return: nothing
     */
    public void heapify(int[] A) {
        // write your code here
        int len = A.length;
        for (int i = len / 2; i >= 0; i--) {
            siftdown(A, i);
        }
    }

    public void siftdown(int[] A, int k) {
        while (k < A.length) {
            int smallest = k;
            if (2 * k + 1 < A.length && A[2 * k + 1] < A[smallest]) {
                smallest = 2 * k + 1;
            }
            if (2 * k + 2 < A.length && A[2 * k + 2] < A[smallest]) {
                smallest = 2 * k + 2;
            }
            if (smallest != k) {
                int temp = A[smallest];
                A[smallest] = A[k];
                A[k] = temp;
            } else {
                break;
            }
            k = smallest;
        }
    }
}
