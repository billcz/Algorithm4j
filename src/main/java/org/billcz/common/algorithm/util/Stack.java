package org.billcz.common.algorithm.util;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/8/23
 */
public interface Stack<Item> extends Iterable<Item> {

    int size();

    boolean isEmpty();

    void push(Item item);

    Item pop();

}
