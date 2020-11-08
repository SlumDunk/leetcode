package com.github.leetcode.medium;

import java.util.Iterator;
import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 1/3/19 17:12
 * @Description: Implement an iterator to flatten a 2d vector.
 * <p>
 * For example,
 * Given 2d vector =
 * <p>
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * By calling children repeatedly until hasNext returns false, the order of elements returned by children should be: [1,2,3,4,5,6].
 * <p>
 * Hint:
 * <p>
 * How many variables do you need to keep track?
 * Two variables is all you need. Try with x and y.
 * Beware of empty rows. It could be the first few rows.
 * To write correct code, think about the invariant to maintain. What is it?
 * The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
 * Not sure? Think about how you would implement hasNext(). Which is more complex?
 * Common logic in two different places should be refactored into a common method.
 * Follow up:
 * As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class Leetcode251 {
    class Vector2D implements Iterator<Integer> {
        /**
         * 存储数据的二维数组list
         */
        List<List<Integer>> vec2d;

        /**
         * 行位置
         */
        int row = 0;
        /**
         * 列位置
         */
        int col = 0;

        public Vector2D(List<List<Integer>> vec2d) {
            this.vec2d = vec2d;
        }

        @Override
        public boolean hasNext() {
            if (vec2d.isEmpty() || row >= vec2d.size()) {
                return false;
            } else {
                //判断是否需要更新列位置
                if (col == vec2d.get(row).size()) {
                    row++;
                    while (row != vec2d.size()) {//找到接下来第一个非空的行
                        if (vec2d.get(row).size() == 0) {
                            row++;
                        } else {
                            break;
                        }
                    }
                    //不存在非空的行了
                    if (row == vec2d.size()) {
                        return false;
                    }
                }
            }
            return true;
        }

        @Override
        public Integer next() {
            Integer value = vec2d.get(row).get(col);
            col++;
            return value;
        }
    }
}
