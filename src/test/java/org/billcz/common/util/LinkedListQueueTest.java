package org.billcz.common.util;

import org.billcz.common.algorithm.util.LinkedListQueue;
import org.billcz.common.algorithm.util.LinkedListStack;
import org.billcz.common.algorithm.util.Queue;
import org.billcz.common.algorithm.util.Stack;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/23
 */
public class LinkedListQueueTest {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedListQueue<Integer>();

        for (int i = 0; i < 2; i++) {
            queue.enqueue(i);
        }

        for (Integer i : queue) {
            System.out.println("remain: " + i);
        }
        System.out.println("size: " + queue.size());
    }
}
