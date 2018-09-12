package org.billcz.common.util;

import org.billcz.common.algorithm.util.Bag;
import org.billcz.common.algorithm.util.LinkedListBag;
import org.billcz.common.algorithm.util.LinkedListQueue;
import org.billcz.common.algorithm.util.Queue;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/23
 */
public class LinkedListBagTest {
    public static void main(String[] args) {
        Bag<Integer> bag = new LinkedListBag<Integer>();

        for (int i = 0; i < 2; i++) {
            bag.add(i);
        }

        for (Integer i : bag) {
            System.out.println("remain: " + i);
        }
        System.out.println("size: " + bag.size());
    }
}
