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
        System.out.println(leetcode788.rotatedDigits(10));
    }

    /**
     * 翻转后改变的数字
     */
    public static List<Integer> rotatedNumList = new ArrayList<Integer>();

    static {
        rotatedNumList.add(2);
        rotatedNumList.add(5);
        rotatedNumList.add(6);
        rotatedNumList.add(9);
    }

    /**
     * 翻转后不改变的数字
     */
    public static List<Integer> unchangedNumList = new ArrayList<Integer>();

    static {
        unchangedNumList.add(0);
        unchangedNumList.add(1);
        unchangedNumList.add(8);
    }


    public int rotatedDigits(int N) {
        if (N < 1 || N > 10000) {
            return 0;
        } else {
            int count = 0;
            for (int i = 1; i <= N; i++) {
                if (validateNum(i)) {
                    count++;
                }
            }
            return count;
        }
    }

    /**
     * 是否有效的数字
     *
     * @param num
     * @return
     */
    private Boolean validateNum(int num) {
        int temp;
        Boolean flag = false;
        while (num > 0) {
            temp = num % 10;
            num /= 10;
            if (rotatedNumList.indexOf(temp) == -1 && unchangedNumList.indexOf(temp) == -1) {//翻转后不是有效的数字
                return false;
            } else if (rotatedNumList.indexOf(temp) != -1) {//翻转后数字会改变
                flag = true;
            } else {//翻转后数字不改变
                continue;
            }
        }
        return flag;
    }
}
