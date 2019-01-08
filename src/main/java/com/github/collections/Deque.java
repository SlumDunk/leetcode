package com.github.collections;

import java.util.Iterator;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 13:40
 * @Description: 双向队列
 * 可从头部插入弹出元素
 * 也可以从尾部插入和弹出元素
 */
public interface Deque<E> extends Iterable<E> {
    /**
     * 往队列头部插入元素
     *
     * @param item
     */
    void pushHead(E item);

    /**
     * 往队列尾部插入元素
     *
     * @param item
     */
    void pushTail(E item);

    /**
     * 队列头部取出元素
     *
     * @return
     */
    E popHead();

    /**
     * 队列尾部取出元素
     *
     * @return
     */
    E popTail();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 队列元素大小
     *
     * @return
     */
    int size();
}
