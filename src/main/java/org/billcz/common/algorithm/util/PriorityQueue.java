package org.billcz.common.algorithm.util;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/19
 */
public class PriorityQueue<Item> {
    private Item[] queues;
    private int topN;
    private Comparator comparator;
    private int size;

    public PriorityQueue(int topN, Comparator<Item> comparator) {
        this.topN = topN;
        this.comparator = comparator;
        this.queues = (Item[]) new Object[topN];
    }

    public void add(Item item) {
        if (size == 0) {
            queues[size++] = item;
            return;
        }

        if (size < topN) {
            int i = size;
            siftUp(i, item);
            size++;
        } else {
            Item first = peek();
            if (comparator.compare(item, first) <= 0) return;
            poll();
            add(item);
        }


    }

    public Item peek() {
        return queues[0];
    }

    public Item poll() {
        Item result = queues[0];
        Item x = queues[size - 1];
        siftDown(0, x);
        size--;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    private void siftUp(int k, Item item) {
        while (k > 0) {
            int parent = (k - 1) >>> 1;
            Item p = queues[parent];
            if (comparator.compare(item, p) >= 0)
                break;
            queues[k] = p;
            k = parent;
        }

        queues[k] = item;
    }

    private void siftDown(int k, Item item) {
        int half = size >>> 1;
        while (k < half) {
            int child = (k << 1)  + 1;
            Item c = queues[child];
            int right = child + 1;
            if (right < size && comparator.compare(c, queues[right]) > 0) {
                child = right;
                c = queues[child];
            }

            if (comparator.compare(item, c) <= 0)
                break;
            queues[k] = c;
            k = child;
        }

        queues[k] = item;

    }



}
