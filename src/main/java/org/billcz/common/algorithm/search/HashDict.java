package org.billcz.common.algorithm.search;

import org.billcz.common.algorithm.util.Set;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/26
 */
public class HashDict<K, V> implements Dict<K, V> {
    private Node<K, V>[] tables;
    private int size;
    private int buckets;
    private static int INIATIAL_CAPACITY = 100;

    public HashDict() {
        this(INIATIAL_CAPACITY);
    }

    public HashDict(int buckets) {
        this.buckets = buckets;
        this.tables = (Node<K, V>[]) new Node[buckets];
    }

    public void put(K k, V v) {
        if (v == null) {
            remove(k);
        }

        int hashCode = hash(k);
        Node node = tables[hashCode];

        if (node == null) {
            tables[hashCode] = new Node<K, V>(hashCode, k , v, null);
            size++;
            return;
        }

        Node pre = node;
        while (node != null) {
            if (k.equals(node.k)) {
                node.v = v;
                break;
            }
            pre = node;
            node = node.next;
        }

        if (node == null) {
            pre.next = new Node<K, V>(hashCode, k, v, null);
            size++;
        }
    }

    public V get(K k) {
        int hashCode = hash(k);
        Node node = tables[hashCode];
        Node result = null;
        while (node != null) {
            if (node.k == k) {
                result = node;
                break;
            }
            node = node.next;
        }

        return result == null ? null : (V) result.v;
    }

    public void remove(K k) {
        int hashCode = hash(k);
        Node root = tables[hashCode];
        Node pre = root;
        Node node = root;
        while (node != null) {
            if (node.k == k) {
                break;
            }
            pre = node;
            node = node.next;
        }

        size--;
        if (node == root) {
            tables[hashCode] = null;
            return;
        }

        pre.next = node.next;
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

    public boolean containsKey(K k) {
        return get(k) != null;
    }

    private class Node<K, V> {
        private int hashCode;
        private K k;
        private V v;
        private Node next;

        public Node(int hashCode, K k, V v, Node next) {
            this.hashCode = hashCode;
            this.k = k;
            this.v = v;
            this.next = next;
        }
    }

    private int hash(Object o) {
        return o == null ? 0 : o.hashCode() % buckets;
    }

}
