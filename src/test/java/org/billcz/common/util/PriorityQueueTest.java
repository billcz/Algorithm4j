package org.billcz.common.util;


import org.billcz.common.algorithm.util.PriorityQueue;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/25
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        Integer[] values = new Integer[] { 3, 1, 3, 2, 5, 3, 5, 4, 9, 6, 7 , 8, 0 };
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(6, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (Integer i : values) {
            pq.add(i);
        }

        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }


    }
}
