package com.github.leetcode.medium;

import java.util.Iterator;

/**
 * @Author: zerongliu
 * @Date: 10/27/18 08:36
 * @Description:
 */
public class Leetcode284 {
    /**
     * 实现迭代器接口 代理模式
     */
    class PeekingIterator implements Iterator<Integer> {
        /**
         * 真正的迭代器
         */
        Iterator<Integer> iterator;
        /**
         * 存储迭代器的下一个元素
         */
        int value;
        /**
         * peek读取出来的元素是否还有效
         */
        boolean isValid;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            value = -1;
            isValid = false;
        }

        /**
         * 返回迭代器顶部元素
         *
         * @return
         */
        public Integer peek() {
            if (isValid)
                return value;
            int val = iterator.next();
            value = val;
            isValid = true;
            return val;
        }

        /**
         * 返回下一个元素
         *
         * @return
         */
        @Override
        public Integer next() {
            //如果val是有效的，直接返回，并置为false
            if (isValid) {
                isValid = false;
                return value;
            }
            return iterator.next();
        }

        /**
         * 是否迭代完所有元素
         *
         * @return
         */
        @Override
        public boolean hasNext() {
            //如果val元素是有效的，直接返回true
            if (isValid)
                return true;
            return iterator.hasNext();
        }
    }
}
