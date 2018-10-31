package org.billcz.common.util;


import org.billcz.common.algorithm.util.IndexPriorityQueue;
import org.billcz.common.algorithm.util.PriorityQueue;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/25
 */
public class IndexPriorityQueueTest {
    public static void main(String[] args) {
        IndexPriorityQueue<Integer> pq = new IndexPriorityQueue<Integer>(10);
        pq.add(1, 100);
        pq.add(3, 200);
        pq.add(0, 10);
        pq.update(3, 500);

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.peek());

    }
}
