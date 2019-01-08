package com.github.collections.impl;

import com.github.collections.Stack;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 14:33
 * @Description:
 */
public class ResizingArrayStack<E> implements Stack<E> {

    private static final int DEFAULT_SIZE = 16;

    private E[] items = (E[]) new Object[DEFAULT_SIZE];

    private int size = 0;

    public ResizingArrayStack() {

    }

    public ResizingArrayStack(Stack<E> stack) {
        Stack<E> tempStack = new ResizingArrayStack<E>();
        for (E item :
                stack) {
            tempStack.push(item);
        }
        while (!tempStack.isEmpty()) {
            push(tempStack.pop());
        }
    }

    @Override
    public void push(E item) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size++] = item;
    }

    @Override
    public E pop() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E item = items[--size];
        items[size] = null;
        if (size <= items.length / 4 && size > DEFAULT_SIZE) {
            resize(items.length / 2);
        }
        return item;
    }

    /**
     * 调整数组大小
     *
     * @param len
     */
    private void resize(int len) {
        E[] newItems = (E[]) new Object[len];
        newItems = Arrays.copyOf(items, newItems.length);
        items = newItems;
    }


    @Override
    public E peek() {
        if (size == 0) throw new NoSuchElementException();
        return items[size - 1];
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
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<E> {
        private int index = size;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public E next() {
            return items[--index];
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new ResizingArrayStack<Integer>();
        for (int i = 0; i < 10; i++) stack.push(i);

        for (int i : new ResizingArrayStack<>(stack)) System.out.println(i);
        System.out.println();

        while (!stack.isEmpty()) System.out.println(stack.pop());
    }
}
