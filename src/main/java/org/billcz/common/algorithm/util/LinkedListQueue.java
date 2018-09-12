package org.billcz.common.algorithm.util;

import java.util.Iterator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/24
 */
public class LinkedListQueue<Item> implements Queue<Item> {
    private Node tail;
    private Node head;

    private int n;
    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void enqueue(Item item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        tail.next = null;

        if (isEmpty()) head = tail;
        else oldTail.next = tail;
        n++;
    }

    public Item dequeue() {
        Item item = head.item;
        head = head.next;
        n--;
        return item;
    }

    private class Node {
        private Item item;
        private Node next;
    }

    public Iterator<Item> iterator() {
        return new ListIter(head);
    }

    private class ListIter implements Iterator<Item> {
        Node ptr;

        ListIter(Node ptr) {
            this.ptr = ptr;
        }

        public boolean hasNext() {
            return ptr != null;
        }

        public Item next() {
            Item item = ptr.item;
            ptr = ptr.next;
            return item;
        }

        public void remove() {

        }
    }
}
