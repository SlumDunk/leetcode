package com.github.collections.impl;

import com.github.collections.Deque;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 19:11
 * @Description: 数组实现双向队列涉及到大量的元素移动
 */
public class ArrayDeque<E> implements Deque<E> {
    private static final int DEFAULT_SIZE = 16;

    private E[] items = (E[]) new Object[DEFAULT_SIZE];

    private int size = 0;

    @Override
    public void pushHead(E item) {
        //现有元素后移
        for (int i = size; i > 0; i--) {
            items[i] = items[i - 1];
        }
        size++;
        items[0] = item;
        resize();
    }

    /**
     * 扩容
     */
    private void resize() {
        if (size == items.length) {
            E[] newItems = (E[]) new Object[items.length * 2];
            newItems = Arrays.copyOf(items, newItems.length);
            items = newItems;
        }
    }

    @Override
    public void pushTail(E item) {
        items[size++] = item;
        resize();
    }

    @Override
    public E popHead() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            //取出头部元素
            E item = items[0];
            //后面元素前移
            for (int i = 0; i < size - 1; i++) {
                items[i] = items[i + 1];
            }
            size--;
            return item;
        }
    }

    @Override
    public E popTail() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            //取出头部元素
            E item = items[--size];
            return item;
        }
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

    private class ArrayIterator implements Iterator<E> {
        int index = 0;

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
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < 5; i++) deque.pushHead(i);
        for (int i = 5; i < 10; i++) deque.pushTail(i);

        for (int i : deque) System.out.println(i);
        System.out.println();

        while (deque.size() > 0) {
            if (deque.size() % 2 == 0) System.out.println(deque.popHead());
            else System.out.println(deque.popTail());
        }

    }
}
