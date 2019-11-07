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


    public int guessNumber__(int n) {
        int start = 1, end = n;
        int mid = 1;

        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid;
            } else if (guess(mid) == -1) {
                end = mid;
            }
        }

        if (guess(start) == 0) {
            return start;
        } else if (guess(end) == 0) {
            return end;
        }

        return 0;
    }
}
