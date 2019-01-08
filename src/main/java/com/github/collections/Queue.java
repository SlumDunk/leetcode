package com.github.collections;

import java.util.Iterator;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 13:47
 * @Description: 队列
 * 只能头部插入元素，尾部取出元素 FIFO
 */
public interface Queue<E> extends Iterable<E> {
    /**
     * 获取队列头部元素
     *
     * @return
     */
    E peek();

    /**
     * 往队列里头添加元素
     *
     * @param item
     */
    void offer(E item);

    /**
     * 取出元素
     */
    E poll();

    /**
     * 是否为空
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
