package com.github.leetcode.medium;

import java.util.Iterator;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 08:36
 * @Description:
 */
public class Leetcode284 {
    class PeekingIterator implements Iterator<Integer> {

        Iterator<Integer> iterator;
        int value;
        boolean isValid;

        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
            value = -1;
            isValid = false;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (isValid)
                return value;
            int val = iterator.next();
            value = val;
            isValid = true;
            return val;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (isValid) {
                isValid = false;
                return value;
            }
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            if (isValid)
                return true;
            return iterator.hasNext();
        }
    }
}
