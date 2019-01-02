package com.github.leetcode.medium;

import com.github.leetcode.vo.NestedInteger;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/1/18 22:11
 * @Description: Given a nested list of integers, implement an iterator to flatten it.
 * <p>
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,1],2,[1,1]]
 * Output: [1,1,2,1,1]
 * Explanation: By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2:
 * <p>
 * Input: [1,[4,[6]]]
 * Output: [1,4,6]
 * Explanation: By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,4,6].
 */
public class Leetcode341 {
    public class NestedIterator implements Iterator<Integer> {
        /**
         * list
         */
        List<NestedInteger> nestedList;
        /**
         * 当前元素的值，调用hasNext()方法的时候赋值
         */
        int data;

        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
        }

        @Override
        public Integer next() {
            return data;
        }

        @Override
        public boolean hasNext() {
            //list非空
            while (nestedList != null && nestedList.size() > 0) {
                //获取list的首元素 并移除
                NestedInteger tmpInt = nestedList.remove(0);
                //若是数字
                if (tmpInt.isInteger()) {
                    data = tmpInt.getInteger();
                    return true;
                } else {//若是集合，直接添加到list头部
                    nestedList.addAll(0, tmpInt.getList());
                }
            }
            return false;
        }

    }
}