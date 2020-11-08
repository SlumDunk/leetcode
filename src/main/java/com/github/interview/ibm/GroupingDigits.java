package com.github.interview.ibm;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/3/20 18:49
 * @Description:
 */
public class GroupingDigits {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
//        arr.add(0);
//        arr.add(1);
//        arr.add(0);
//        arr.add(1);
//        System.out.println(minMoves(arr));
        System.out.println(minMovesAjacent(arr));
        //1,1,1,1,0,1,0,1
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        arr.add(0);
        arr.add(1);
        System.out.println(minMovesAjacent(arr));
    }

    /**
     * 只能移动相邻的
     * [0,1,0,1]
     * 1
     * [
     *
     * @param arr
     * @return
     */
    public static int minMoves(List<Integer> arr) {
        int numberOfOnes = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            if (arr.get(i) == 1) {
                numberOfOnes++;
            }
        }
        int x = numberOfOnes;

        int countOnes = 0, maxOnes;
        for (int i = 0; i < x; i++) {
            if (arr.get(i) == 1) {
                countOnes++;
            }
        }
        maxOnes = countOnes;
        for (int i = 1; i <= n - x; i++) {
            if (arr.get(i - 1) == 1) {
                countOnes--;
            }
            if (arr.get(i + x - 1) == 1) {
                countOnes++;
            }
            maxOnes = Math.max(maxOnes, countOnes);
        }
        int numberOfZeroes = x - maxOnes;
        return numberOfZeroes;
    }

    public static int minMovesAjacent(List<Integer> arr) {
        int n0 = 0, i0 = 0, n1 = 0, i1 = 0;
        int len = arr.size();
        for (int p = 0; p < len; p++) {
            if (arr.get(p) == 0) {
                n0 += p - i0++;
            } else {
                n1 += p - i1++;
            }
        }
        return Math.min(n0, n1);
    }
}
