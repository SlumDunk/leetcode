package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 11/2/18 16:50
 * @Description: our task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 * <p>
 * Example 1:
 * <p>
 * Input: a = 2, b = [3]
 * Output: 8
 * Example 2:
 * <p>
 * Input: a = 2, b = [1,0]
 * Output: 1024
 */
public class Leetcode372 {
    private static final int BASE = 1337;

    public int superPow(int a, int[] b) {
        if (a == 0 || a == 1) return a;
        return superPowMod(a, b, b.length - 1);
    }

    //O(n), where n=b.length
    private int superPowMod(int a, int[] b, int index) {
        if (index < 0) return 1;
        int c = superPowMod(a, b, index - 1);
        return (powMod(c, 10) * powMod(a, b[index])) % BASE;
    }

    //O(10) (a*b)%m=((a%m)*(b%m))%m
    private int powMod(int a, int m) {
        if (a == 1) return 1;
        int res = 1;
        int pow = a % BASE;
        for (int i = 0; i < m; i++) {
            res = (res * pow) % BASE;
        }
        return res;
    }
}
