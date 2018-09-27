package org.billcz.common.algorithm.search;

import org.billcz.common.algorithm.util.Set;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/26
 */
public interface Dict<K, V> {
    void put(K k, V v);

    V get(K k);

    void remove(K k);

    int size();

    boolean isEmpty();

    Set<K> Keys();

    boolean containsKey(K k);
}
