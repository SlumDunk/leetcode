package com.github.leetcode.medium;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: zerongliu
 * @Date: 7/21/19 17:36
 * @Description: Suppose you are given the following code:
 * <p>
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * <p>
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 */
public class Leetcode1115 {
    class FooBar {
        private int n;
        private Lock lock = new ReentrantLock();
        Condition foo = lock.newCondition();
        Condition bar = lock.newCondition();

        public FooBar(int n) {
            this.n = n;
        }

        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                try {
                    lock.lock();
                    foo.await();
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    bar.signalAll();
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }
            }

        }

        public void bar(Runnable printBar) throws InterruptedException {
            for (int i = 0; i < n; i++) {
                try {
                    lock.lock();
                    foo.signalAll();
                    bar.await();
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                } catch (InterruptedException e) {

                } finally {
                    lock.unlock();
                }

            }
        }
    }
}
