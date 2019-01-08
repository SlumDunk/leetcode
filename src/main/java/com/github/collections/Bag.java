package com.github.collections;

import java.util.Iterator;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 13:37
 * @Description: 背包
 * 背包是一种不支持从中删除元素的集合数据类型——
 * 它的目的就是帮助用例收集元素并迭代遍历所有收集到的元素（用例也可以检查背包是否为空或者获取背包中元素的数量）
 */
public interface Bag<E> extends Iterable<E> {
    /**
     * 往背包里添加元素
     *
     * @param item
     */
    void add(E item);

    /**
     * 判断背包是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 背包里头元素的个数
     *
     * @return
     */
    int size();
}
