package org.billcz.common.algorithm.util;

import java.util.Iterator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/24
 */
public class LinkedListBag<Item> implements Bag<Item> {
    private Node head;
    private int n;

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public void add(Item item) {
        Node oldHead = head;
        head = new Node();
        head.item = item;
        head.next = oldHead;
        n++;
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
