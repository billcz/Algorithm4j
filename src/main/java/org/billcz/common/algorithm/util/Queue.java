package org.billcz.common.algorithm.util;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/23
 */
public interface Queue<Item> extends Iterable<Item> {

    int size();

    boolean isEmpty();

    void enqueue(Item item);

    Item dequeue();

}
