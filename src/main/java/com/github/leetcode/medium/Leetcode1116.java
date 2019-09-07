package com.github.leetcode.medium;

import java.util.function.IntConsumer;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 21:12
 * @Description: Suppose you are given the following code:
 * <p>
 * class ZeroEvenOdd {
 * public ZeroEvenOdd(int n) { ... }      // constructor
 * public void zero(printNumber) { ... }  // only output 0's
 * public void even(printNumber) { ... }  // only output even numbers
 * public void odd(printNumber) { ... }   // only output odd numbers
 * }
 * The same instance of ZeroEvenOdd will be passed to three different threads:
 * <p>
 * Thread A will call zero() which should only output 0's.
 * Thread B will call even() which should only ouput even numbers.
 * Thread C will call odd() which should only output odd numbers.
 * Each of the thread is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: "0102030405"
 */
public class Leetcode1116 {

    /**
     * 01020304
     */
    class ZeroEvenOdd {
        private int n;
        /**
         * 当前打印0的状态
         */
        private boolean printZero = true;
        /**
         * 决定打印奇数还是偶数
         */
        private boolean printOdd = true;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                until(true, false);
                printNumber.accept(0);
                incPrintState();
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                until(false, false);
                printNumber.accept(i);
                incPrintState();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                until(false, true);
                printNumber.accept(i);
                incPrintState();
            }
        }

        /**
         * @param printZero 当前是否要打印0
         * @param printOdd  当前是否要打印奇数
         * @throws InterruptedException
         */
        public synchronized void until(boolean printZero, boolean printOdd) throws InterruptedException {
            // While not ready to print
            while (
                    !(
                            // Condition for zero to print
                            (printZero && this.printZero) ||
                                    // Condition for odd or even to print
                                    (!printZero && !this.printZero && printOdd == this.printOdd)
                    )
                    ) {
                wait();
            }
        }

        /**
         * 变换状态
         */
        public synchronized void incPrintState() {
            //不是打印0，打印奇数或者偶数，直接取异或
            printOdd = printOdd ^ (!printZero);
            //打印0的状态位取反
            printZero = !printZero;
            notifyAll();
        }
    }
}
