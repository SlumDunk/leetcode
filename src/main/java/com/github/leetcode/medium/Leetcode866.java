package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 5/28/19 21:13
 * @Description:
 */
public class Leetcode866 {
    public int primePalindrome(int N) {
        if (8 <= N && N <= 11) return 11;
        for (int i = 0; i < 100000; i++) {
            String s = Integer.toString(i), r = new StringBuilder(s).reverse().toString().substring(1);
            int y = Integer.parseInt(s + r);
            if (y >= N && isPrime(y)) return y;
        }
        return -1;
    }

    /**
     * 判断是否是素数
     *
     * @param x
     * @return
     */
    private boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) return x == 2;
        for (int i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
}
