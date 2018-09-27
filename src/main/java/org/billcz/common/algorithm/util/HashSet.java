package org.billcz.common.algorithm.util;

import org.billcz.common.algorithm.search.HashDict;

import java.util.Iterator;

/**
 * Description:
 * Author: billcz
 * Create time: 2018/9/27
 */
public class HashSet<Item> implements Set<Item> {
    private HashDict<Item, Item> hashDict;

    public HashSet() {
        this.hashDict = new HashDict<Item, Item>();
    }

    public boolean add(Item item) {
        if (hashDict.containsKey(item)) return true;
        hashDict.put(item, item);
        return true;
    }

    public boolean remove(Item item) {
        if (!hashDict.containsKey(item)) return true;
        hashDict.remove(item);
        return false;
    }

    public int size() {
        return hashDict.size();
    }

    public boolean isEmpty() {
        return hashDict.isEmpty();
    }

    public boolean contains(Item item) {
        return hashDict.containsKey(item);
    }

    public Iterator<Item> iterator() {
        return null;
    }
}
