package com.github.leetcode.hard;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author: zerongliu
 * @Date: 7/24/19 21:21
 * @Description: There are two kinds of threads, oxygen and hydrogen. Your goal is to group these threads to form water molecules. There is a barrier where each thread has to wait until a complete molecule can be formed. Hydrogen and oxygen threads will be given a releaseHydrogen and releaseOxygen method respectfully, which will allow them to pass the barrier. These threads should pass the barrier in groups of three, and they must be able to immediately bond with each other to form a water molecule. You must guarantee that all the threads from one molecule bond before any other threads from the next molecule do.
 * <p>
 * In other words:
 * <p>
 * If an oxygen thread arrives at the barrier when no hydrogen threads are present, it has to wait for two hydrogen threads.
 * If a hydrogen thread arrives at the barrier when no other threads are present, it has to wait for an oxygen thread and another hydrogen thread.
 * We don’t have to worry about matching the threads up explicitly; that is, the threads do not necessarily know which other threads they are paired up with. The key is just that threads pass the barrier in complete sets; thus, if we examine the sequence of threads that bond and divide them into groups of three, each group should contain one oxygen and two hydrogen threads.
 * <p>
 * Write synchronization code for oxygen and hydrogen molecules that enforces these constraints.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "HOH"
 * Output: "HHO"
 * Explanation: "HOH" and "OHH" are also valid answers.
 * Example 2:
 * <p>
 * Input: "OOHHHH"
 * Output: "HHOHHO"
 * Explanation: "HOHHHO", "OHHHHO", "HHOHOH", "HOHHOH", "OHHHOH", "HHOOHH", "HOHOHH" and "OHHOHH" are also valid answers.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * Total length of input string will be 3n, where 1 ≤ n ≤ 30.
 * Total number of H will be 2n in the input string.
 * Total number of O will be n in the input string.
 */
public class Leetcode1117 {

    class H2O {

        private final BlockingQueue<Boolean> hydrogenQueue = new ArrayBlockingQueue<>(1);
        private final BlockingQueue<Boolean> oxygenQueue = new ArrayBlockingQueue<>(1);

        public H2O() {
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            hydrogenQueue.put(true);

            releaseHydrogen.run();
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            oxygenQueue.put(true);

            hydrogenQueue.take();
            releaseOxygen.run();
            hydrogenQueue.take();

            oxygenQueue.take();
        }
    }
}
