package org.billcz.common.algorithm.search;

import org.billcz.common.algorithm.util.Set;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/27
 */
public class BalanceBinaryTreeDict<K extends Comparable<? super K>, V> implements SortDict<K, V> {
    public void put(K k, V v) {

    }

    public V get(K k) {
        return null;
    }

    public void remove(K k) {

    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public Set<K> Keys() {
        return null;
    }

    public boolean containsKey(K k) {
        return false;
    }

    public K getFirst() {
        return null;
    }

    public K getLast() {
        return null;
    }

    private class Node {
        private K k;
        private V v;
        private int size;
        private Node left;
        private Node right;

        public Node(K k, V v, int size, Node left, Node right) {
            this.k = k;
            this.v = v;
            this.size = size;
            this.left = left;
            this.right = right;
        }
    }

}
