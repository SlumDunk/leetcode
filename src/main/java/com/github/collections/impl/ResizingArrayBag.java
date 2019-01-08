package com.github.collections.impl;

import com.github.collections.Bag;

import java.util.Arrays;
import java.util.Iterator;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 14:00
 * @Description:
 */
public class ResizingArrayBag<E> implements Bag<E> {
    private static final int DEFAULT_SIZE = 16;

    private E[] items = (E[]) new Object[DEFAULT_SIZE];

    private int size = 0;

    @Override
    public void add(E item) {
        if (size == items.length) {
            resize();
        }
        items[size++] = item;
    }

    /**
     * 扩容
     */
    private void resize() {
        E[] newItems = (E[]) new Object[items.length * 2];
        newItems = Arrays.copyOf(items, newItems.length);
        items = newItems;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator();
    }

    /**
     * 迭代器
     */
    private class ArrayIterator implements Iterator<E> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public E next() {
            return items[index++];
        }
    }

    public static void main(String[] args) {
        Bag<Integer> bag = new ResizingArrayBag<Integer>();
        for (int i = 0; i < 10; i++) bag.add(i);
        for (int i : bag) System.out.println(i);
    }
}
