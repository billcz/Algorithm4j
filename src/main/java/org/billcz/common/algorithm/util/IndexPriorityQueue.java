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
        this.vals = (Item[]) new Comparable[maxN];
        this.pq = new int[maxN];
        this.qp = new int[maxN];

        for (int k = 0; k < maxN; k++)
            qp[k] = -1;
    }

    public void add(int k, Item item) {
        qp[k] = n;
        pq[n] = k;
        vals[k] = item;
        siftUp(n);
        n++;
    }

    public void update(int k, Item item) {
        vals[k] = item;

        siftUp(qp[k]);
        siftDown(qp[k]);
    }

    public boolean contains(int k) {
        return qp[k] != -1;
    }

    public Item delete(int k) {
        if (!contains(k)) return null;

        Item del = vals[k];
        int index = qp[k];
        exchange(index, --n);
        siftUp(index);
        siftDown(index);
        qp[k] = -1;
        vals[k] = null;
        return del;
    }

    private int compare(int i, int j) {
        return vals[pq[i]].compareTo(vals[pq[j]]);
    }

    private void siftUp(int i) {
        while (i > 0) {
            int parent = (i - 1) >>> 1;
            if (compare(i, parent) >= 0)
                break;

            exchange(i, parent);
            i = parent;
        }
    }

    private void siftDown(int i) {
        int half = n >>> 1;
        while (i < half) {
            int child = (i << 1)  + 1;
            int right = child + 1;
            if (right < n && compare(child, right) > 0) {
                child = right;
            }

            if (compare(i, child) <= 0)
                break;

            exchange(i, child);
            i = child;
        }
    }

    public Item poll() {
        return delete(pq[0]);
    }

    public Item peek() {
        return vals[pq[0]];
    }

    private void exchange(int i, int j) {
        int swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;

        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }
}
