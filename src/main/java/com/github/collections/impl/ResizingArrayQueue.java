package com.github.collections.impl;

import com.github.collections.Queue;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 14:12
 * @Description:
 */
public class ResizingArrayQueue<E> implements Queue<E> {
    private static final int DEFAULT_SIZE = 16;

    private E[] items = (E[]) new Object[DEFAULT_SIZE];

    /**
     * 下个要出队列的元素位置
     */
    private int first = 0;

    private int size = 0;

    public ResizingArrayQueue() {

    }

    public ResizingArrayQueue(Queue<E> queue) {
        for (E item :
                queue) {
            offer(item);
        }
    }

    @Override
    public E peek() {
        if (size == 0) throw new NoSuchElementException();
        return items[first];
    }

    @Override
    public void offer(E item) {
        if (first + size == items.length) {
            resize();
        }
        items[first + size] = item;
        size++;
    }

    /**
     * 扩容
     */
    private void resize() {
        if (size > items.length / 2) resize(items.length * 2);
        else if (size <= items.length / 4 && items.length > DEFAULT_SIZE) {
            resize(items.length / 2);
        } else {
            resize(items.length);
        }
    }

    private void resize(int max) {
        //数组长度不改变时不需要开辟新空间，在数组内部即可进行调整
        E[] newItems = items;
        if (max != items.length) {
            newItems = (E[]) new Object[max];
        }
        for (int i = 0; i < size; i++) {
            newItems[i] = items[first + i];
            items[first + i] = null;
        }
        first = 0;
        items = newItems;
    }

    @Override
    public E poll() {
        if (size == 0) throw new NoSuchElementException();
        E item = items[first];
        items[first] = null;
        first++;
        size--;
        if (size <= items.length / 4 && items.length > DEFAULT_SIZE) {
            resize();
        }
        return item;

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
            return items[first + index++];
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new ResizingArrayQueue<Integer>();
        //入队
        for (int i = 0; i < 1000; i++) {
            queue.offer(i);
        }

        //用已有队列构造一个新队列
        for (int i : new ResizingArrayQueue<>(queue)) {
            System.out.println(i);
        }

        System.out.println();

        //出队
        for (int i = 0; i < 1000; i++) {
            if (queue.poll() != i) System.out.println("error");
        }
    }
}
