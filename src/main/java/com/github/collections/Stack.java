package com.github.collections;

import java.util.Iterator;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 13:50
 * @Description:栈 LIFO
 */
public interface Stack<E> extends Iterable<E> {
    /**
     * 往栈插入元素
     *
     * @param item
     */
    void push(E item);

    /**
     * 弹出栈顶元素
     *
     * @return
     */
    E pop();

    /**
     * 获取栈顶元素
     *
     * @return
     */
    E peek();

    /**
     * 判断栈是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 栈中元素数量
     *
     * @return
     */
    int size();
}
