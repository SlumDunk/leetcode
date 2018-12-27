package com.github.leetcode.easy;

public class Leetcode374 {
    public int guessNumber(int n) {
        int left = 1, right = n;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {//比实际的大
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return 0;
    }

    private int guess(int mid) {
        return 0;
    }
}
