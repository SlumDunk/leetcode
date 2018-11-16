package com.github.leetcode.vo;

import java.util.List;

/**
 * @Author: zerongliu
 * @Date: 11/1/18 22:17
 * @Description:
 */
public class NestedInteger {

    public NestedInteger() {
    }


    public NestedInteger(int value) {
    }

    public void add(NestedInteger ni) {
    }

    // @return true if this NestedInteger holds a single integer, rather than a
    // nested list.
    public boolean isInteger() {
        return Boolean.TRUE;
    }

    // @return the single integer that this NestedInteger holds, if it holds a
    // single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return -1;
    }

    // @return the nested list that this NestedInteger holds, if it holds a
    // nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}
