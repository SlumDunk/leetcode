package com.github.collections.impl;

import com.github.collections.Node;
import com.github.collections.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 16:24
 * @Description:
 */
public class LinkedQueue<E> implements Queue<E> {
    /**
     * 头部节点，头部弹出
     */
    private Node<E> head;
    /**
     * 尾部节点， 尾部插入新数据
     */
    private Node<E> tail;

    private int size = 0;

    public LinkedQueue() {
        head = new Node<E>();
        tail = head;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedNodeIterator(head);
    }

    @Override
    public E peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            return head.next.item;
        }
    }

    @Override
    public void offer(E item) {
        Node node = new Node(item);
        tail.next = node;
        tail = node;
        size++;
    }

    @Override
    public E poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            Node<E> curNode = head.next;
            head.next = curNode.next;
            curNode.next = null;
            size--;
            return curNode.item;
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

    private class LinkedNodeIterator implements Iterator<E> {
        Node<E> head;
        int size = 0;

        public LinkedNodeIterator(Node head) {
            this(head, Integer.MAX_VALUE);
        }

        public LinkedNodeIterator(Node head, int size) {
            this.head = head;
            this.size = size;
        }

        @Override
        public boolean hasNext() {
            return size > 0 && head.next != null;
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
        Queue<Integer> queue = new LinkedQueue<Integer>();
        for (int i = 0; i < 10; i++) queue.offer(i);
        for (int i : queue) System.out.println(i);
        while (!queue.isEmpty()) System.out.println(queue.poll());
    }
}
