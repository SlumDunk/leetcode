package com.github.leetcode.medium;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 3/5/19 08:23
 * @Description: Given two 1d vectors, implement an iterator to return their elements alternately.
 * <p>
 * Example:
 * <p>
 * Input:
 * v1 = [1,2]
 * v2 = [3,4,5,6]
 * <p>
 * Output: [1,3,2,4,5,6]
 * <p>
 * Explanation: By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,3,2,4,5,6].
 * Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?
 * <p>
 * Clarification for the follow up question:
 * The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases. If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic". For example:
 * <p>
 * Input:
 * [1,2,3]
 * [4,5,6,7]
 * [8,9]
 * <p>
 * Output: [1,4,8,2,5,9,3,6,7].
 */
public class Leetcode281 {
    class ZigzagIterator {
        private Iterator<Integer> nextIterator, currentIterator, temp;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            nextIterator = v2.iterator();
            currentIterator = v1.iterator();
        }

        public int next() {
            if (currentIterator.hasNext()) {
                temp = currentIterator;
                currentIterator = nextIterator;
                nextIterator = temp;
            }
            return nextIterator.next();
        }

        public boolean hasNext() {
            return nextIterator.hasNext() || currentIterator.hasNext();
        }
    }
}
