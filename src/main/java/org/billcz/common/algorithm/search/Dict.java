package org.billcz.common.algorithm.search;

import java.util.Collection;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/26
 */
public interface Dict<K, V> {
    void put(K k, V v);

    V get(K k);

    int size();

    boolean isEmpty();

    Collection<K> Keys();
}
