package com.github.leetcode.medium;

/**
 * @Author: zerongliu
 * @Date: 6/30/19 15:08
 * @Description: On a broken calculator that has a number showing on its display, we can perform two operations:
 * <p>
 * Double: Multiply the number on the display by 2, or;
 * Decrement: Subtract 1 from the number on the display.
 * Initially, the calculator is displaying the number X.
 * <p>
 * Return the minimum number of operations needed to display the number Y.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: X = 2, Y = 3
 * Output: 2
 * Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.
 * Example 2:
 * <p>
 * Input: X = 5, Y = 8
 * Output: 2
 * Explanation: Use decrement and then double {5 -> 4 -> 8}.
 * Example 3:
 * <p>
 * Input: X = 3, Y = 10
 * Output: 3
 * Explanation:  Use double, decrement and double {3 -> 6 -> 5 -> 10}.
 * Example 4:
 * <p>
 * Input: X = 1024, Y = 1
 * Output: 1023
 * Explanation: Use decrement operations 1023 times.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= X <= 10^9
 * 1 <= Y <= 10^9
 */
public class Leetcode991 {
    /**
     * 逆向思维 Y->X
     * 除法操作和加1操作
     *
     * @param X
     * @param Y
     * @return
     */
    public int brokenCalc(int X, int Y) {
        if (X == Y) return 0;

        if (Y < X)//加1操作
            return brokenCalc(X, Y + (X - Y)) + (X - Y);
        else if (Y % 2 == 0)//偶数 除法操作
            return brokenCalc(X, Y / 2) + 1;
        else//奇数 加1+除法
            return brokenCalc(X, (Y + 1) / 2) + 2;
    }
}
