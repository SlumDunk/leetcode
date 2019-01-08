package com.github.collections;

/**
 * @Author: zerongliu
 * @Date: 1/8/19 15:53
 * @Description:链表节点
 */
public class Node<E> {
    public E item;
    public Node<E> next;

    public Node() {
        this(null);
    }

    public Node(E item) {
        this(item, null);
    }

    public Node(E item, Node<E> next) {
        this.item = item;
        this.next = next;
    }
}
