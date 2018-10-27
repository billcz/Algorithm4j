package org.billcz.common.algorithm.util;

/**
 * Description:
 * Author: billcz
 * Create time: 27/10/2018
 */
public class IndexPriorityQueue<Item extends Comparable<? super Item>> {
    private Item[] vals;
    private int[] pq;
    private int[] qp;
    private int n;
    private int maxN;

    public IndexPriorityQueue(int maxN) {
        this.maxN = maxN;
        this.vals = (Item[]) new Object[maxN];
        this.pq = new int[maxN];
        this.qp = new int[maxN];

        for (int k = 0; k < maxN; k++)
            qp[k] = -1;
    }

    public void add(int k, Item item) {
        qp[k] = n;
        pq[n] = k;
        vals[k] = item;
        siftUp(n, item);
        n++;
    }

    public void update(int k, Item item) {
        vals[k] = item;

        siftUp(qp[k], item);
        siftDown(qp[k], item);
    }

    public void delete(int k) {
        vals[k] = null;
        exchange(qp[k], --n);
        qp[k] = -1;


    }

    private void siftUp(int i, Item item) {
        while (i > 0) {
            int parent = (i - 1) >>> 1;
            Item p = vals[pq[i]];

            if (item.compareTo(p)>= 0)
                break;

            exchange(i, parent);
            i = parent;
        }
    }

    private void siftDown(int i, Item item) {
        int half = n >>> 1;
        while (i < half) {
            int child = (i << 1)  + 1;
            Item c = vals[pq[child]];
            int right = child + 1;
            if (right < n && c.compareTo(vals[pq[right]]) > 0) {
                child = right;
                c = vals[pq[child]];
            }

            if (item.compareTo(c) <= 0)
                break;

            exchange(i, child);
            i = child;
        }
    }

    private void exchange(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
}
