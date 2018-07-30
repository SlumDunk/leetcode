package com.github.leetcode.easy;

public class Leetcode374 {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == -1) {
                high = mid + 1;
            } else {
                low = mid - 1;
            }
        }
        return -1;
    }
}
