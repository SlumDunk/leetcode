package com.github.leetcode.medium;

public class Leetcode1718 {
    public int[] constructDistancedSequence(int n) {
        int len = (n - 1) * 2 + 1;
        int[] result = new int[len];
        helper(n, len, 0, new int[len], new boolean[n + 1], result);
        return result;
    }

    private boolean helper(int n, int len, int index, int[] soFar, boolean[] used, int[] result) {
        if (index == len) {
            for (int i = 0; i < soFar.length; i++) {
                result[i] = soFar[i];
            }
            return true;
        } else if (soFar[index] != 0) {
            boolean finished = helper(n, len, index + 1, soFar, used, result);
            if (finished) {
                return true;
            }
        } else {
            for (int i = n; i >= 0; i--) {
                if (!used[i] && (i == 1 || (index + i < len && soFar[index + i] == 0))) {
                    // choose
                    used[i] = true;
                    soFar[index] = i;
                    if (i != 1) soFar[index + i] = i;
                    boolean finished = helper(n, len, index + 1, soFar, used, result);
                    if (finished) {
                        return true;
                    }
                    used[i] = false;
                    soFar[index] = 0;
                    if (i != 1) soFar[index + i] = 0;
                }
            }
        }
        return false;
    }
}
