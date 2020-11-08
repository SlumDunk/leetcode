package com.github.sort;

/**
 * @Author: zerongliu
 * @Date: 1/10/20 21:20
 * @Description:
 */
public class PancakeSort {
    static int[] pancakeSort(int[] arr) {
        // your code goes here
        int n = arr.length;
        while (n > 0) {
            int index = findMax(arr, n);

            //flip [0...index] to exchange the max value to the first item
            flip(arr, index + 1);

            flip(arr, n);

            n--;
        }

        return arr;
    }

    static int findMax(int[] arr, int n) {
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[max]) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{23, 10, 20, 11, 12, 6, 72};
        arr = pancakeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    static void flip(int[] arr, int k) {
        int left = 0, right = k - 1;
        while (left < right) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left++;
            right--;
        }
    }
}
