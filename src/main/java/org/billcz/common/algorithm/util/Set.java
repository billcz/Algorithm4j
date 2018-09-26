package org.billcz.common.algorithm.util;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/26
 */
public interface Set<Item> extends Iterable<Item> {
    boolean add(Item item);

    boolean remove(Item item);

    int size();

    boolean isEmpty();

    boolean contains(Item item);

}
