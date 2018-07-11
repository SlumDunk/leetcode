package com.github.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 * <p>
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves; 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate to any other number and become invalid.
 * <p>
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * <p>
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * <p>
 * N  will be in range [1, 10000].
 */
public class Leetcode788 {
    public static void main(String[] args) {
        Leetcode788 leetcode788 = new Leetcode788();
        System.out.println(leetcode788.rotatedDigits(857));
    }

    public static List<Integer> rotatedNumList = new ArrayList<Integer>();

    static {
        rotatedNumList.add(2);
        rotatedNumList.add(5);
        rotatedNumList.add(6);
        rotatedNumList.add(9);
    }

    public static List<Integer> unchangedNumList = new ArrayList<Integer>();

    static {
        unchangedNumList.add(0);
        unchangedNumList.add(1);
        unchangedNumList.add(8);
    }


    public int rotatedDigits(int N) {
        if (N < 1 || N > 10000) {
            System.out.println("N must be in range [1,10000]");
            return 0;
        } else {
            int count = 0;
            int modCount = 0;
            for (int i = 1; i <= N; i++) {
                if (N / 10000 > 0) {
                    modCount = 4;
                } else if (N / 1000 > 0) {
                    modCount = 3;
                } else if (N / 100 > 0) {
                    modCount = 2;
                } else if (N / 10 > 0) {
                    modCount = 1;
                } else {
                    modCount = 0;
                }
                if (validateNum(i, modCount)) {
                    count++;
                    System.out.println(i);
                }
            }
            return count;
        }
    }

    /**
     * validte whether a number is a rotated number
     *
     * @param num
     * @param modCount
     * @return
     */
    private Boolean validateNum(int num, int modCount) {
        int temp;
        Boolean flag = false;
        for (int i = 0; i <= modCount; i++) {
            if (i > 0) {
                int dividor = (int) Math.pow(10, i);
                temp = (num / dividor) % 10;
            } else {
                temp = num % 10;
            }
            if (rotatedNumList.indexOf(temp) == -1 && unchangedNumList.indexOf(temp) == -1) {
                return false;
            } else if (rotatedNumList.indexOf(temp) != -1) {
                flag = true;
            } else {
                continue;

            }
        }
        return flag;
    }
}
