package org.billcz.common.algorithm.util;

import org.billcz.common.algorithm.search.Dict;
import org.billcz.common.algorithm.search.HashDict;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/10/24
 */
public class IndexPQ<Item> {
    PriorityQueue<Item> pq;
    Dict<Integer, Item> dict;

    public IndexPQ(int topN, Comparator<Item> comparator) {
        pq = new PriorityQueue<Item>(topN, comparator);
        dict = new HashDict<Integer, Item>();
    }

    public void add(int i, Item item) {
        pq.add(item);
        dict.put(i, item);
    }

    public void update(int i, Item item) {
        pq.add(item);
        dict.put(i, item);
    }

    public Item get(int i) {
        return dict.get(i);
    }

    public Item poll() {
        return pq.poll();
    }

    public Item peek() {
        return pq.peek();
    }

}
