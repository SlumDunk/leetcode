package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 17:39
 * @Description: Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity. The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 * <p>
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * <p>
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
 * <p>
 * Note: There will be exactly one celebrity if he/she is in the party. Return the celebrity's label if there is a celebrity in the party. If there is no celebrity, return -1.
 */
public class Leetcode277 {

    /**
     * O(n)
     *
     * @param n
     * @return
     */
    public int findCelebrity(int n) {
        //名人就是所有人都认识他，他不认识任何人
        int k = 0;
        for (int i = 1; i < n; i++) {
            k = knows(i, k) ? k : i;
        }


        for (int i = 0; i < n; i++) {
            //有人他认识或者是有不认识他的人
            if (i != k && (knows(k, i) || !knows(i, k))) {
                return -1;
            }
        }
        return k;
    }

    /**
     * a是否认识b
     *
     * @param a
     * @param b
     * @return
     */
    private boolean knows(int a, int b) {
        return true;
    }
}
