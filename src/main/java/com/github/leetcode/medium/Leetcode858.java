package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 7/3/19 19:41
 * @Description: There is a special square room with mirrors on each of the four walls.  Except for the southwest corner, there are receptors on each of the remaining corners, numbered 0, 1, and 2.
 * <p>
 * The square room has walls of length p, and a laser ray from the southwest corner first meets the east wall at a distance q from the 0th receptor.
 * <p>
 * Return the number of the receptor that the ray meets first.  (It is guaranteed that the ray will meet a receptor eventually.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: p = 2, q = 1
 * Output: 2
 * Explanation: The ray meets receptor 2 the first time it gets reflected back to the left wall.
 * <p>
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= p <= 1000
 * 0 <= q <= p
 */
public class Leetcode858 {
    public static void main(String[] args) {
        Leetcode858 leetcode858 = new Leetcode858();
        leetcode858.mirrorReflection(2, 1);
    }

    public int mirrorReflection(int p, int q) {
        int g = gcd(p, q);
        p /= g;
        p %= 2;
        q /= g;
        q %= 2;

        if (p == 1 && q == 1) return 1;
        return p == 1 ? 0 : 2;
    }

    public int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
}
