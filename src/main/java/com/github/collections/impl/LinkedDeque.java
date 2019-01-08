package com.github.collections.impl;

import com.github.collections.Deque;
import com.github.collections.DoubleLinkedNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 16:03
 * @Description:
 */
public class LinkedDeque<E> implements Deque<E> {

    private DoubleLinkedNode<E> head;
    private DoubleLinkedNode<E> tail;
    private int size = 0;

    public LinkedDeque() {
        this.head = new DoubleLinkedNode<>();
        this.tail = new DoubleLinkedNode<>();
        head.next = tail;
        tail.previous = head;
    }

    @Override
    public void pushHead(E item) {
        DoubleLinkedNode<E> newNode = new DoubleLinkedNode<>(item);
        newNode.previous = head;
        newNode.next = head.next;

        head.next.previous = newNode;
        head.next = newNode;
        size++;
    }

    @Override
    public void pushTail(E item) {
        DoubleLinkedNode<E> newNode = new DoubleLinkedNode<>(item);
        newNode.previous = tail.previous;
        newNode.next = tail;
        tail.previous.next = newNode;
        tail.previous = newNode;
        size++;
    }

    @Override
    public E popHead() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            DoubleLinkedNode<E> node = head.next;
            node.next.previous = node.previous;
            head.next = node.next;
            node.previous = null;
            node.next = null;
            size--;
            return node.item;
        }

    }

    @Override
    public E popTail() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            DoubleLinkedNode<E> node = tail.previous;
            node.previous.next = node.next;
            node.next.previous = node.previous;
            node.previous = null;
            node.next = null;
            size--;
            return node.item;
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
    public Iterator iterator() {
        return new DoubleLinkedNodeIterator(head, size);
    }

    private class DoubleLinkedNodeIterator implements Iterator<E> {
        DoubleLinkedNode<E> head;
        int size;

        public DoubleLinkedNodeIterator(DoubleLinkedNode<E> head) {
            this(head, Integer.MAX_VALUE);

        }

        public DoubleLinkedNodeIterator(DoubleLinkedNode<E> head, int size) {
            this.head = head;
            this.size = size;
        }


        @Override
        public boolean hasNext() {
            return size > 0;
        }

        @Override
        public E next() {
            E item = head.next.item;
            head = head.next;
            size--;
            return item;
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedDeque<>();

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
