package com.github.leetcode.medium;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * You have the four functions:
 * <p>
 * printFizz that prints the word "Fizz" to the console,
 * printBuzz that prints the word "Buzz" to the console,
 * printFizzBuzz that prints the word "FizzBuzz" to the console, and
 * printNumber that prints a given integer to the console.
 * You are given an instance of the class FizzBuzz that has four functions: fizz, buzz, fizzbuzz and number. The same instance of FizzBuzz will be passed to four different threads:
 * <p>
 * Thread A: calls fizz() that should output the word "Fizz".
 * Thread B: calls buzz() that should output the word "Buzz".
 * Thread C: calls fizzbuzz() that should output the word "FizzBuzz".
 * Thread D: calls number() that should only output the integers.
 * Modify the given class to output the series [1, 2, "Fizz", 4, "Buzz", ...] where the ith token (1-indexed) of the series is:
 * <p>
 * "FizzBuzz" if i is divisible by 3 and 5,
 * "Fizz" if i is divisible by 3 and not 5,
 * "Buzz" if i is divisible by 5 and not 3, or
 * i if i is not divisible by 3 or 5.
 * Implement the FizzBuzz class:
 * <p>
 * FizzBuzz(int n) Initializes the object with the number n that represents the length of the sequence that should be printed.
 * void fizz(printFizz) Calls printFizz to output "Fizz".
 * void buzz(printBuzz) Calls printBuzz to output "Buzz".
 * void fizzbuzz(printFizzBuzz) Calls printFizzBuzz to output "FizzBuzz".
 * void number(printNumber) Calls printnumber to output the numbers.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 15
 * Output: [1,2,"fizz",4,"buzz","fizz",7,8,"fizz","buzz",11,"fizz",13,14,"fizzbuzz"]
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: [1,2,"fizz",4,"buzz"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 50
 */
public class Leetcode1195 {
    static class FizzBuzz {
        private static final Lock lock = new ReentrantLock();
        private Condition condition = lock.newCondition();

        private static int CURRENT;
        private int n;

        public FizzBuzz(int n) {
            this.n = n;
            CURRENT = 1;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            lock.lock();
            try {
                while (CURRENT <= n) {
                    if (CURRENT % 3 == 0 && CURRENT % 5 != 0) {
                        printFizz.run();
                        CURRENT++;
                        condition.signalAll();
                    } else {
                        condition.await();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            lock.lock();
            try {
                while (CURRENT <= n) {
                    if (CURRENT % 5 == 0 && CURRENT % 3 != 0) {
                        printBuzz.run();
                        CURRENT++;
                        condition.signalAll();
                    } else {
                        condition.await();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            lock.lock();
            try {
                while (CURRENT <= n) {
                    if (CURRENT % 3 == 0 && CURRENT % 5 == 0) {
                        printFizzBuzz.run();
                        CURRENT++;
                        condition.signalAll();
                    } else {
                        condition.await();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            lock.lock();
            try {
                while (CURRENT <= n) {
                    if (CURRENT % 3 != 0 && CURRENT % 5 != 0) {
                        printNumber.accept(CURRENT);
                        CURRENT++;
                        condition.signalAll();
                    } else {
                        condition.await();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
