package org.billcz.common.algorithm.util;

import java.util.Iterator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/23
 */
public class LinkedListStack<Item> implements Stack<Item> {
    private Node head;
    private int n = 0;

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void push(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        n++;
    }

    public Item pop() {
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
