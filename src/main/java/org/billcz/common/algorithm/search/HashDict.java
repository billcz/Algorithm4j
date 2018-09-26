package org.billcz.common.algorithm.search;

import org.billcz.common.algorithm.util.Set;

import java.util.HashMap;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/26
 */
public class HashDict<K, V> implements Dict<K, V> {
    private Node[] tables;
    private int size;

    public void put(K k, V v) {
    }

    public V get(K k) {
        int hashCode = hash(k);
        Node root = tables[hashCode];
        V result = null;
        while (root.next != null) {
        }
        return result;
    }

    public void delete(K k) {

    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Set<K> Keys() {
        return null;
    }

    private class Node {
        private K k;
        private V v;
        private Node next;
    }

    public int hash(Object o) {
        return o == null ? 0 : o.hashCode();
    }
}
