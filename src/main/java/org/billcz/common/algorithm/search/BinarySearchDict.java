package org.billcz.common.algorithm.search;

import org.billcz.common.algorithm.util.Set;

import java.util.Comparator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/26
 */
public class BinarySearchDict<K, V> implements SortDict<K, V> {
    private K[] keys;
    private V[] vals;
    int size;
    Comparator comparator;
    private static final int INITIAL_CAPACITY = 10;

    public BinarySearchDict() {
        this(INITIAL_CAPACITY, null);
    }

    public BinarySearchDict(Comparator comparator) {
        this(INITIAL_CAPACITY, comparator);
    }

    public BinarySearchDict(int initialCapacity, Comparator comparator) {
        this.keys = (K[]) new Object[initialCapacity];
        this.vals = (V[]) new Object[initialCapacity];
        this.comparator = comparator;
    }

    public void put(K k, V v) {
        int i = rank(k);

        if (v == null) {
            delete(k);
            return;
        }

        if (i < size && compare(keys[i], k) == 0) {
            vals[i] = v;
            return;
        }

        if (size == keys.length) {
            grow(2 * size);
        }

        System.arraycopy(keys, i, keys, i + 1, (size - i));
        System.arraycopy(vals, i, vals, i + 1, (size - i));
        keys[i] = k;
        vals[i] = v;
        size++;
    }

    public V get(K k) {
        int i = rank(k);
        if (i < size && compare(keys[i], k) == 0) {
            return vals[i];
        }

        return null;
    }

    public void delete(K k) {
        int i = rank(k);
        if (i < size && compare(keys[i], k) == 0) {
            System.arraycopy(keys, i + 1, keys, i, (size - i));
            System.arraycopy(vals, i + 1, vals, i, (size - i));
            size--;

            if (size == (keys.length / 2)) {
                grow(keys.length / 2);
            }
        }
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

    public K getFirst() {
        return keys == null ? null : keys[0];
    }

    public K getLast() {
        return keys == null ? null : keys[size - 1];
    }

    private void grow(int capacity) {
        K[] newKeys = (K[]) new Object[capacity];
        V[] newVals = (V[]) new Object[capacity];
        System.arraycopy(keys, 0, newKeys, 0, size);
        System.arraycopy(vals, 0, newVals, 0, size);
        keys = newKeys;
        vals = newVals;
    }

    private int rank(K k) {
        int lo = 0;
        int hi = size - 1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1);
            int cmp = compare(k, keys[mid]);
            if (cmp > 0) lo = mid + 1;
            else if (cmp < 0) hi = mid - 1;
            else return mid;
        }

        return lo;
    }

    private int compare(Object o1, Object o2) {
        return comparator == null ? ((Comparable<? super K>) o1).compareTo((K)o2) :
                comparator.compare(o1, o2);
    }
}
