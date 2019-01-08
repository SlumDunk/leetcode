package com.github.collections;

import java.util.Iterator;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 13:54
 * @Description:
 */
public interface Steque<E> extends Iterator<E> {
    /**
     * @param item
     */
    void push(E item);

    /**
     * @param item
     */
    void offer(E item);

    /**
     * @return
     */
    E pop();

    /**
     * @return
     */
    E peek();

    /**
     * @return
     */
    boolean isEmpty();

    /**
     * @return
     */
    int size();
}
