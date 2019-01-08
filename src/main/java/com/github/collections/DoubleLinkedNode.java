package com.github.collections;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 15:56
 * @Description: 双向链表节点
 */
public class DoubleLinkedNode<E> {
    public E item;
    public DoubleLinkedNode<E> previous;
    public DoubleLinkedNode<E> next;

    public DoubleLinkedNode() {

    }

    public DoubleLinkedNode(E item) {
        this(item, null, null);
    }

    public DoubleLinkedNode(E item, DoubleLinkedNode<E> previous, DoubleLinkedNode<E> next) {
        this.item = item;
        this.previous = previous;
        this.next = next;
    }
}
